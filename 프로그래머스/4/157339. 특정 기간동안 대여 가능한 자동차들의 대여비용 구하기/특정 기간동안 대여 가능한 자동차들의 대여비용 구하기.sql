-- 세단 또는 SUV
WITH DISCOUNT_PLAN AS (
    SELECT CAR_TYPE, DISCOUNT_RATE
    FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    WHERE CAR_TYPE IN ('세단', 'SUV') AND DURATION_TYPE LIKE '30%'
),
-- 대여 가능한 차
RENTAL_AVAIL AS (
    SELECT DISTINCT CAR_ID, CAR_TYPE
    FROM CAR_RENTAL_COMPANY_CAR
    WHERE CAR_TYPE IN ('세단', 'SUV') AND CAR_ID NOT IN (
        SELECT CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE TO_CHAR(START_DATE, 'YYYY-MM') = '2022-11' OR TO_CHAR(END_DATE, 'YYYY-MM') = '2022-11' OR (TO_CHAR(START_DATE, 'YYYY-MM') <= '2022-11' AND TO_CHAR(END_DATE, 'YYYY-MM') >= '2022-11')
    )
)
SELECT CAR_ID, CAR_TYPE, FEE
FROM (
    SELECT R.CAR_ID, R.CAR_TYPE, (C.DAILY_FEE * (1-D.DISCOUNT_RATE/100) * 30) AS FEE
    FROM RENTAL_AVAIL R, DISCOUNT_PLAN D, CAR_RENTAL_COMPANY_CAR C
    WHERE R.CAR_TYPE = D.CAR_TYPE AND R.CAR_ID = C.CAR_ID
)
WHERE 500000 <= FEE AND FEE < 2000000
ORDER BY FEE DESC, CAR_TYPE ASC, CAR_ID DESC
;