-- 코드를 입력하세요
SELECT p.PRODUCT_CODE, p.PRICE * SUM(o.SALES_AMOUNT) AS SALES
FROM PRODUCT p
INNER JOIN OFFLINE_SALE o ON p.PRODUCT_ID = o.PRODUCT_ID
GROUP BY PRODUCT_CODE
ORDER BY SALES DESC, p.PRODUCT_CODE;