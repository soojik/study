-- 보호소에서는 몇 시에 입양이 가장 활발하게 일어나는지 알아보려 합니다.
-- 0시부터 23시까지, 각 시간대별로 입양이 몇 건이나 발생했는지 조회
WITH HOUR_TABLE AS (
    SELECT LEVEL - 1 AS HOUR
    FROM DUAL
    CONNECT BY LEVEL <= 24
)
SELECT H.HOUR, COUNT(O.ANIMAL_ID) AS COUNT
FROM HOUR_TABLE H LEFT OUTER JOIN ANIMAL_OUTS O ON H.HOUR = (TO_CHAR(O.DATETIME, 'HH24')+0)
GROUP BY H.HOUR
ORDER BY H.HOUR ASC
;
