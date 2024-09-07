-- 년, 월, 성별 별로 상품을 구매한 회원수를 집계
SELECT TO_CHAR(o.sales_date, 'yyyy') AS YEAR, TO_CHAR(o.sales_date, 'mm') - 0 AS MONTH, u.gender AS GENDER, COUNT(DISTINCT(u.user_id)) AS USERS
FROM USER_INFO u INNER JOIN ONLINE_SALE o ON u.user_id = o.user_id
GROUP BY TO_CHAR(o.sales_date, 'yyyy'), TO_CHAR(o.sales_date, 'mm'), u.gender HAVING u.gender IS NOT NULL
ORDER BY YEAR, MONTH, GENDER
;