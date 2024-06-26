-- 평균 길이가 33cm 이상인 물고기들을 종류별로 분류하여 잡은 수, 최대 길이, 물고기의 종류
SELECT COUNT(ID) AS FISH_COUNT, MAX(LENGTH) AS MAX_LENGTH, FISH_TYPE 
FROM FISH_INFO
GROUP BY FISH_TYPE HAVING 33 <= AVG(IF(LENGTH IS NULL, 10, LENGTH))
ORDER BY FISH_TYPE ASC
;