-- 코드를 입력하세요
WITH has_milk_and_yogurt AS (
    SELECT *
    FROM CART_PRODUCTS
    WHERE NAME = 'Milk'
    GROUP BY CART_ID
    UNION
    SELECT *
    FROM CART_PRODUCTS
    WHERE NAME = 'Yogurt'
    GROUP BY CART_ID
)
SELECT CART_ID
FROM has_milk_and_yogurt
GROUP BY CART_ID HAVING 2 <= COUNT(*)
ORDER BY CART_ID ASC
;