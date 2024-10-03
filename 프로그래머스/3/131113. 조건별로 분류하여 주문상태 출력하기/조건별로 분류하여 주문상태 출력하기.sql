-- 2022년 5월 1일을 기준으로 주문 ID, 제품 ID, 출고일자, 출고여부를 조회
SELECT
ORDER_ID, PRODUCT_ID, TO_CHAR(OUT_DATE, 'YYYY-MM-DD'),
    CASE
        WHEN OUT_DATE IS NULL THEN '출고미정'
        WHEN TO_CHAR(OUT_DATE, 'YYYY-MM-DD') <= '2022-05-01' THEN '출고완료'
        ELSE '출고대기'
    END
AS "출고여부"
FROM FOOD_ORDER
ORDER BY ORDER_ID ASC
;