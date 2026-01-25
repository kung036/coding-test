-- ORACLE
SELECT  ID,
        NAME,
        HOST_ID
FROM    PLACES 
WHERE   host_id IN (
            SELECT HOST_ID
            FROM   PLACES 
            GROUP  BY HOST_ID
            HAVING COUNT(*) >= 2
        )
ORDER BY id;