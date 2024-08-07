--  2022년 10월에 작성된 게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일을 조회
SELECT UGB.TITLE, UGB.BOARD_ID, UGR.REPLY_ID, UGR.WRITER_ID, UGR.CONTENTS, TO_CHAR(UGR.CREATED_DATE, 'YYYY-MM-DD') AS CREATED_DATE
FROM USED_GOODS_BOARD UGB, USED_GOODS_REPLY UGR
WHERE UGB.BOARD_ID = UGR.BOARD_ID
AND TO_CHAR(UGB.CREATED_DATE, 'YYYY-MM') = '2022-10'
ORDER BY UGR.CREATED_DATE ASC, UGB.TITLE ASC
;