-- 아직 입양을 못 간 동물 중!! 가장 오래 보호소에 있었던 동물 3마리의 이름과 보호 시작일을 조회
SELECT I.NAME, I.DATETIME
FROM ANIMAL_INS I LEFT OUTER JOIN ANIMAL_OUTS O ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE O.DATETIME IS NULL
ORDER BY I.DATETIME ASC
LIMIT 3
;