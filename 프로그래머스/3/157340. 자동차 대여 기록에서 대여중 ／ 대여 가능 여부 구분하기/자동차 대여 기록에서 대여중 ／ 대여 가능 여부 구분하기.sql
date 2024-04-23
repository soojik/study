-- 2022년 10월 16일에 대여 중인 자동차인 경우 '대여중' 이라고 표시하고, 대여 중이지 않은 자동차인 경우 '대여 가능' (AVAILABILITY)
WITH IS_CAR_RENTALED AS (
    SELECT CAR_ID, 1 AS AVA
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE <= '2022-10-16' AND '2022-10-16' <= END_DATE
) 
SELECT C.CAR_ID, IF (I.CAR_ID IS NULL, '대여 가능', '대여중') AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY C LEFT OUTER JOIN IS_CAR_RENTALED I ON C.CAR_ID = I.CAR_ID 
GROUP BY C.CAR_ID
ORDER BY C.CAR_ID DESC
;