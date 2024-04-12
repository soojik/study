-- 코드를 작성해주세요
SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPERS
WHERE SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME='C#') OR SKILL_CODE & (SELECT CODE FROM SKILLCODES WHERE NAME='Python')
ORDER BY ID ASC
;