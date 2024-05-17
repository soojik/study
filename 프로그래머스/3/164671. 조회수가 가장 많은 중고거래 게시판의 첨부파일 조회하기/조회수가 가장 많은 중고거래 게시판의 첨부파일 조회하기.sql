-- 코드를 입력하세요
WITH MOST_VIEWD_BOARD AS ( 
    SELECT BOARD_ID
    FROM (SELECT BOARD_ID
    FROM USED_GOODS_BOARD B
    ORDER BY VIEWS DESC) MOST_VIEWD
    WHERE ROWNUM = 1
)
SELECT ('/home/grep/src/' || B.BOARD_ID || '/' || FILE_ID || FILE_NAME || FILE_EXT) AS FILE_PATH
FROM MOST_VIEWD_BOARD B, USED_GOODS_FILE F
WHERE B.BOARD_ID = F.BOARD_ID
ORDER BY FILE_PATH DESC
;