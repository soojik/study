-- 가장 높은 조회수 게시글
WITH HV AS (
    SELECT BOARD_ID
    FROM (
        SELECT BOARD_ID
        FROM USED_GOODS_BOARD 
        ORDER BY VIEWS DESC
    )
    WHERE ROWNUM = 1
)

SELECT '/home/grep/src/' || HV.BOARD_ID || '/' || UGF.FILE_ID || UGF.FILE_NAME || FILE_EXT AS FILE_PATH
FROM HV LEFT OUTER JOIN USED_GOODS_FILE UGF ON HV.BOARD_ID = UGF.BOARD_ID
ORDER BY UGF.FILE_ID DESC
;