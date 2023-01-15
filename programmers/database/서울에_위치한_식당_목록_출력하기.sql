-- 코드를 입력하세요

SELECT REST_INFO.REST_ID, REST_INFO.REST_NAME, REST_INFO.FOOD_TYPE,
    REST_INFO.FAVORITES, REST_INFO.ADDRESS,
    ROUND(AVG(REST_REVIEW.REVIEW_SCORE), 2) AS SCORE
        FROM REST_INFO, REST_REVIEW
            WHERE REST_INFO.REST_ID = REST_REVIEW.REST_ID
                AND ADDRESS LIKE '서울%'
                    GROUP BY REST_INFO.REST_ID
                        ORDER BY SCORE DESC, REST_INFO.FAVORITES DESC;

# REST_INFO, REST_REVIEW
# 서울 위치
# 식당ID, 식당이름, 음식종류, 즐겨찾기 수, 주소, 리뷰 평균 점수
# 리뷰 평균 점수는 소수점 세번째 자리에서 반올림
# 평균점수 내림차순, 즐겨찾기 수 내림차순
