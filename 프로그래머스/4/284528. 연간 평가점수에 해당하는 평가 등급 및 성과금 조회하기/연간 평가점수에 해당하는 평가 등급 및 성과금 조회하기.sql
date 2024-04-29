-- HR_DEPARTMENT : 회사 부서
-- HR_EMPLOYEES: 회사의 사원 정보
-- HR_GRADE: 2022년 사원의 평가 정보

WITH avgscore_grade AS (
    SELECT EMP_NO, AVG(SCORE) AS AVG_SCORE,
        CASE
            WHEN 96 <= AVG(SCORE)
            THEN 'S'
            WHEN 90 <= AVG(SCORE)
            THEN 'A'
            WHEN 80 <= AVG(SCORE)
            THEN 'B'
            ELSE 'C'
        END AS GRADE
    FROM HR_GRADE
    GROUP BY EMP_NO
)
SELECT E.EMP_NO, EMP_NAME, A.GRADE,
    CASE
            WHEN A.GRADE = 'S'
            THEN E.SAL * 0.2
            WHEN A.GRADE = 'A'
            THEN E.SAL * 0.15
            WHEN A.GRADE = 'B'
            THEN E.SAL * 0.1
            ELSE 0
        END AS BONUS
FROM HR_EMPLOYEES E JOIN avgscore_grade A ON E.EMP_NO = A.EMP_NO
ORDER BY EMP_NO ASC
;