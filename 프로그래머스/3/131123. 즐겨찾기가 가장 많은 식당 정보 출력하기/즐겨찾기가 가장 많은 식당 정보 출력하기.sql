-- 음식종류별로 즐겨찾기수가 가장 많은 식당의 음식 종류, ID, 식당 이름, 즐겨찾기수를 조회
WITH MAX_FAV AS (
    SELECT FOOD_TYPE, MAX(FAVORITES) AS MAX
    FROM REST_INFO
    GROUP BY FOOD_TYPE
)

SELECT R.FOOD_TYPE, R.REST_ID, R.REST_NAME, R.FAVORITES
FROM REST_INFO R INNER JOIN MAX_FAV M ON R.FOOD_TYPE = M.FOOD_TYPE AND R.FAVORITES = M.MAX
ORDER BY R.FOOD_TYPE DESC
;