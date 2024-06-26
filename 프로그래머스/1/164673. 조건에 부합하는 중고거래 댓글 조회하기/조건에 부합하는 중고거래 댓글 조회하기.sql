-- 코드를 입력하세요
SELECT TITLE, B.BOARD_ID, REPLY_ID, R.WRITER_ID, R.CONTENTS, TO_CHAR(R.CREATED_DATE, 'YYYY-MM-DD') AS CREATED_DATE
FROM USED_GOODS_BOARD B, USED_GOODS_REPLY R
WHERE TO_CHAR(B.CREATED_DATE, 'YYYYMM') = '202210' AND B.BOARD_ID = R.BOARD_ID
ORDER BY CREATED_DATE ASC, TITLE ASC