-- 리뷰를 가장 많이 작성한 회원의 리뷰들
WITH highest_review_member AS (
    SELECT MEMBER_ID, COUNT(*) AS review_cnt
    FROM REST_REVIEW
    GROUP BY MEMBER_ID
    ORDER BY review_cnt DESC
    LIMIT 1
)
SELECT M.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM MEMBER_PROFILE M JOIN REST_REVIEW R ON M.MEMBER_ID = R.MEMBER_ID, highest_review_member H
WHERE R.MEMBER_ID = H.MEMBER_ID
ORDER BY REVIEW_DATE ASC, R.REVIEW_TEXT ASC
;