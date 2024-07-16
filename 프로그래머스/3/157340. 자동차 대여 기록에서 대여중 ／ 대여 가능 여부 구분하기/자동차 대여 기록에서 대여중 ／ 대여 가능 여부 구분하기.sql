-- 2022년 10월 16일에 대여 중인 자동차인 경우 '대여중' 이라고 표시하고, 대여 중이지 않은 자동차인 경우 '대여 가능'을 표시하는 컬럼(컬럼명: AVAILABILITY)을 추가하여 자동차 ID와 AVAILABILITY 리스트

WITH CAR_RENTALED AS (
    SELECT DISTINCT(CAR_ID) AS CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    WHERE '2022-10-16' BETWEEN TO_CHAR(START_DATE, 'YYYY-MM-DD') AND TO_CHAR(END_DATE, 'YYYY-MM-DD')
)

SELECT H.CAR_ID, DECODE (R.CAR_ID, NULL, '대여 가능', '대여중') AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H LEFT OUTER JOIN CAR_RENTALED R ON H.CAR_ID = R.CAR_ID
GROUP BY H.CAR_ID, R.CAR_ID
ORDER BY H.CAR_ID DESC
;