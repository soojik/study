-- 자동차 종류가 '세단'인 자동차, 10월에 대여를 시작한 기록
WITH Car_Type AS (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_CAR
    WHERE CAR_TYPE = '세단'
)
SELECT DISTINCT(C.CAR_ID)
FROM Car_Type JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY C ON Car_Type.CAR_ID = C.CAR_ID
WHERE MONTH(START_DATE) = 10
ORDER BY C.CAR_ID DESC
;