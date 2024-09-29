-- 이 서비스에서는 공간을 둘 이상 등록한 사람을 "헤비 유저"라고 부릅니다. 헤비 유저가 등록한 공간의 정보를 아이디 순으로 조회
WITH ABOVE_2 AS (
    SELECT HOST_ID
    FROM PLACES
    GROUP BY HOST_ID HAVING 2 <= COUNT(ID)
)
SELECT P.ID, P.NAME, P.HOST_ID
FROM ABOVE_2 A INNER JOIN PLACES P ON A.HOST_ID = P.HOST_ID
ORDER BY P.ID ASC
;