-- 
SELECT p.product_id, p.product_name, p.price * SUM(o.amount) AS TOTAL_SALES
FROM FOOD_PRODUCT p INNER JOIN FOOD_ORDER o ON p.product_id = o.product_id AND TO_CHAR(o.PRODUCE_DATE, 'YYYY-MM') = '2022-05'
GROUP BY p.product_id, p.product_name, p.price
ORDER BY TOTAL_SALES DESC, p.product_id ASC
;