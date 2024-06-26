-- 
WITH ABOVE_7 AS (
    SELECT CAR_ID, ROUND(AVG(END_DATE - START_DATE + 1), 1) AS AVERAGE_DURATION
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    GROUP BY CAR_ID HAVING 7 <= AVG(END_DATE - START_DATE + 1)
)
SELECT *
FROM ABOVE_7
ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC
;