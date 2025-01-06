WITH RECURSIVE HOUR_TABLE AS (
    SELECT 0 AS HOUR
    UNION ALL 
    SELECT HOUR + 1
    FROM HOUR_TABLE
    WHERE HOUR < 23
),
GROUPED_DATA AS (
    SELECT HOUR(DATETIME) AS HOUR, COUNT(ANIMAL_ID) AS CNT
    FROM ANIMAL_OUTS
    GROUP BY HOUR(DATETIME)
)

-- 0시부터 23시까지, 각 시간대별로 입양이 몇 건이나 발생했는지 조회
SELECT H.HOUR AS HOUR, IF (G.CNT IS NULL, 0, G.CNT) AS COUNT
FROM HOUR_TABLE H LEFT OUTER JOIN GROUPED_DATA G ON H.HOUR = G.HOUR
;