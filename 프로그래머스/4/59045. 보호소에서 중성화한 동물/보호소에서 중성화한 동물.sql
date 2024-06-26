-- 보호소에 들어올 당시에는 중성화 되지 않았지만, 보호소를 나갈 당시에는 중성화된 동물
-- 아이디와 생물 종, 이름
SELECT I.ANIMAL_ID, I.ANIMAL_TYPE, I.NAME
FROM ANIMAL_INS I JOIN ANIMAL_OUTS O ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE (I.SEX_UPON_INTAKE NOT LIKE 'Spayed%'
    AND I.SEX_UPON_INTAKE NOT LIKE 'Neutered%')
    AND (O.SEX_UPON_OUTCOME LIKE 'Spayed%' OR O.SEX_UPON_OUTCOME LIKE 'Neutered%')
-- 아이디 순
ORDER BY I.ANIMAL_ID
;