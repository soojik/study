-- 코드를 작성해주세요
WITH P_CODE AS (SELECT 'A' AS GRADE, SUM(CODE) AS CODE FROM SKILLCODES WHERE NAME = 'Python'),
C_CODE AS (SELECT 'B' AS GRADE, SUM(CODE) AS CODE FROM SKILLCODES WHERE NAME = 'C#'),
F_CODE AS (SELECT 'C' AS GRADE, SUM(CODE) AS CODE FROM SKILLCODES WHERE CATEGORY = 'Front End'),
USER_CODE AS (SELECT CASE
        WHEN D.SKILL_CODE & P.CODE AND D.SKILL_CODE & F.CODE
        THEN 'A'
        WHEN D.SKILL_CODE & C.CODE
        THEN 'B'
        WHEN D.SKILL_CODE & F.CODE
        THEN 'C'
    END AS GRADE, D.ID AS ID, D.EMAIL AS EMAIL
FROM DEVELOPERS D, P_CODE P, C_CODE C, F_CODE F
)
SELECT GRADE, ID, EMAIL
FROM USER_CODE
WHERE GRADE IS NOT NULL
ORDER BY GRADE ASC, ID ASC
;