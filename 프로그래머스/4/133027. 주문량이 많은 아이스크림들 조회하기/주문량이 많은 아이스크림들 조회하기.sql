-- 7월 아이스크림 총 주문량과 상반기의 아이스크림 총 주문량을 더한 값이 큰 순서대로 상위 3개의 맛을 조회
WITH SUM_AT_JULY AS (
    SELECT FLAVOR, SUM(TOTAL_ORDER) AS TOTAL_ORDER
    FROM JULY
    GROUP BY FLAVOR
)
SELECT FLAVOR
FROM (
    SELECT F.FLAVOR, (F.TOTAL_ORDER + J.TOTAL_ORDER) AS TOTAL, ROWNUM
    FROM FIRST_HALF F FULL OUTER JOIN SUM_AT_JULY J ON F.FLAVOR = J.FLAVOR
    ORDER BY TOTAL DESC
)
WHERE ROWNUM <= 3
;
