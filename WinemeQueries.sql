USE wineme;
SELECT * FROM wineme.wine;

-- INTJ
SELECT * FROM wine WHERE
description LIKE '%dry%'
OR description LIKE '%depth%'
OR description LIKE '%strong%'
OR description LIKE '%spicy%'
ORDER BY
IF(description LIKE '%dry%',1,0)+
IF(description LIKE '%depth%',1,0)+
IF(description LIKE '%strong%',1,0)+ 
IF(description LIKE '%spicy%',1,0) DESC LIMIT 10;

-- INTJ
SELECT * FROM wine WHERE
description LIKE '%dry%'
OR description LIKE '%depth%'
OR description LIKE '%strong%'
OR description LIKE '%spicy%'
ORDER BY
IF(description LIKE '%dry%',1,0)+
IF(description LIKE '%depth%',1,0)+
IF(description LIKE '%strong%',1,0)+ 
IF(description LIKE '%spicy%',1,0) DESC LIMIT 10;