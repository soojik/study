-- 코드를 입력하세요
SELECT PT_NAME, PT_NO, GEND_CD, AGE, IF (TLNO IS NULL, "NONE", TLNO) AS TLNO
        FROM PATIENT
            WHERE AGE <= 12 AND GEND_CD = 'W'  
               ORDER BY AGE DESC, PT_NAME ASC;

# 12세 이하
# 여자
# 환자이름, 번호, 성별코드, 나이, 전화번호 (if null = 'NONE')
# 나이 내림차순, 이름 오름차순
