-- 우유와 요거트를 동시에 구입한 장바구니의 아이디를 조회
SELECT DISTINCT(m.CART_ID)
FROM (SELECT CART_ID FROM CART_PRODUCTS WHERE NAME='Milk') m
    INNER JOIN (SELECT CART_ID FROM CART_PRODUCTS WHERE NAME='Yogurt') y
        ON m.CART_ID = y.CART_ID
ORDER BY m.CART_ID ASC
;
