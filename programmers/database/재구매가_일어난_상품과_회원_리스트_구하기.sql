-- 코드를 입력하세요
SELECT USER_ID, PRODUCT_ID
    FROM ONLINE_SALE
        GROUP BY USER_ID, PRODUCT_ID
            HAVING COUNT(ONLINE_SALE_ID) > 1
                ORDER BY USER_ID ASC, PRODUCT_ID DESC;

# 동일한 회원이 동일한 상품 재구매
# 재구매한 회원ID, 상품ID 출력
# 회원ID 오름, 상품 ID 내림
