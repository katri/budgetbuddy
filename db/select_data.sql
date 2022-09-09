-- kokku liidetud standard tabelite vaade
SELECT sc.name AS "standard gategories", ss.name AS "standard subgategories"
FROM standard_category_relation
         JOIN standard_category sc ON sc.id = standard_category_relation.standard_category_id
         JOIN standard_subcategory ss ON ss.id = standard_category_relation.standard_subcategory_id;


-- kokku liidetud custom kliendi tabelite vaade
SELECT c.name AS "gategories", s.name AS "subgategories"
FROM category_relation
         JOIN category c ON c.id = category_relation.category_id
         JOIN subcategory s ON s.id = category_relation.subcategory_id;


