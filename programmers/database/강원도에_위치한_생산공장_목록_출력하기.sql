-- 코드를 입력하세요
SELECT FACTORY_ID, FACTORY_NAME, ADDRESS
    FROM FOOD_FACTORY
        WHERE ADDRESS LIKE '강원%'
            ORDER BY FACTORY_ID ASC;

# 강원도
# 공장 ID, 공장 이름, 주소
# 공장 ID 오름차순
