-- 보호소에서 중성화 수술을 거친 동물 정보를 알아보려 합니다.
-- 보호소에 들어올 당시에는 중성화되지 않았지만, 보호소를 나갈 당시에는 중성화된 동물의 아이디와 생물 종, 이름을 조회하는 아이디 순으로 조회하는 SQL 문을 작성해주세요.
SELECT a1.ANIMAL_ID, a1.ANIMAL_TYPE, a1.NAME--, a1.SEX_UPON_INTAKE, a2.SEX_UPON_OUTCOME
FROM ANIMAL_INS a1 INNER JOIN ANIMAL_OUTS a2 ON a1.ANIMAL_ID = a2.ANIMAL_ID
WHERE a1.SEX_UPON_INTAKE LIKE 'Intact%' AND (a2.SEX_UPON_OUTCOME LIKE 'Spayed%' OR a2.SEX_UPON_OUTCOME LIKE 'Neutered%')
ORDER BY a1.ANIMAL_ID
;