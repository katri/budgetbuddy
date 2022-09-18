-- kokku liidetud standard tabelite vaade
SELECT sc.name AS "standard categories", ss.name AS "standard subcategories"
FROM standard_category_relation
         JOIN standard_category sc ON sc.id = standard_category_relation.standard_category_id
         JOIN standard_subcategory ss ON ss.id = standard_category_relation.standard_subcategory_id;


-- kokku liidetud custom kliendi tabelite vaade
SELECT c.user_id AS user, c.name AS "categories", s.name AS "subcategories"
FROM category_relation
         JOIN category c ON c.id = category_relation.category_id
         JOIN subcategory s ON s.id = category_relation.subcategory_id;

SELECT *
FROM transaction t
WHERE  EXTRACT(MONTH from date) = 8
  AND t.subcategory_id = 5



