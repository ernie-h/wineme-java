USE wineme;
SELECT * FROM wineme.wine;

-- TO migrate WINE REVIEWS into OUR db
USE wine_project;
INSERT INTO wineme.wine(description,title,variety)
SELECT wine.description, wine.title, wine.variety
FROM wine_project.wine;

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