INSERT INTO month (id, name, number) VALUES (DEFAULT, 'jaanuar', 1);
INSERT INTO month (id, name, number) VALUES (DEFAULT, 'veebruar', 2);
INSERT INTO month (id, name, number) VALUES (DEFAULT, 'märts', 3);
INSERT INTO month (id, name, number) VALUES (DEFAULT, 'aprill', 4);
INSERT INTO month (id, name, number) VALUES (DEFAULT, 'mai', 5);
INSERT INTO month (id, name, number) VALUES (DEFAULT, 'juuni', 6);
INSERT INTO month (id, name, number) VALUES (DEFAULT, 'juuli', 7);
INSERT INTO month (id, name, number) VALUES (DEFAULT, 'august', 8);
INSERT INTO month (id, name, number) VALUES (DEFAULT, 'september', 9);
INSERT INTO month (id, name, number) VALUES (DEFAULT, 'oktoober', 10);
INSERT INTO month (id, name, number) VALUES (DEFAULT, 'november', 11);
INSERT INTO month (id, name, number) VALUES (DEFAULT, 'detsember', 12);

INSERT INTO role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO role (id, name) VALUES (DEFAULT, 'customer');

INSERT INTO "user" (id, role_id, user_name, password, email) VALUES (DEFAULT, 2, 'liisi', 'student123', 'liisi@budgebuddy.com');
INSERT INTO "user" (id,  role_id, user_name, password, email) VALUES (DEFAULT, 2, 'maris', 'student123', 'maris@budgetbuddy.com');
INSERT INTO "user" (id,  role_id, user_name, password, email) VALUES (DEFAULT, 2, 'katri', 'student123', 'katri@budgetbuddy.com');

INSERT INTO standard_category (id, name, sequence, type) VALUES (DEFAULT, 'Aktiivsed tulud', 1, 'i');
INSERT INTO standard_category (id, name, sequence, type) VALUES (DEFAULT, 'Passiivsed tulud', 2, 'i');
INSERT INTO standard_category (id, name, sequence, type) VALUES (DEFAULT, 'Vältimatud kulud', 3, 'e');
INSERT INTO standard_category (id, name, sequence, type) VALUES (DEFAULT, 'Eluase', 4, 'e');
INSERT INTO standard_category (id, name, sequence, type) VALUES (DEFAULT, 'Hooajalised kulud', 5, 'e');
INSERT INTO standard_category (id, name, sequence, type) VALUES (DEFAULT, 'Elukvaliteet', 6, 'e');
INSERT INTO standard_category (id, name, sequence, type) VALUES (DEFAULT, 'Lapsed', 7, 'e');
INSERT INTO standard_category (id, name, sequence, type) VALUES (DEFAULT, 'Meelelahutus', 8, 'e');

INSERT INTO standard_subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Palk', 1, 'i');
INSERT INTO standard_subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Lastetoetus', 2, 'i');
INSERT INTO standard_subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Dividendid', 3, 'i');
INSERT INTO standard_subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Üüritulu', 4, 'i');
INSERT INTO standard_subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Toidupood', 5, 'e');
INSERT INTO standard_subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Transport', 6, 'e');
INSERT INTO standard_subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Lemmikloom', 7, 'e');
INSERT INTO standard_subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Telefon', 8, 'e');
INSERT INTO standard_subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Kodukulud', 9, 'e');
INSERT INTO standard_subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Ravikulud', 10, 'e');
INSERT INTO standard_subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Tasud ja viivised', 11, 'e');

INSERT INTO standard_category_relation (id, standard_category_id, standard_subcategory_id) VALUES (DEFAULT, 1, 1);
INSERT INTO standard_category_relation (id, standard_category_id, standard_subcategory_id) VALUES (DEFAULT, 1, 2);
INSERT INTO standard_category_relation (id, standard_category_id, standard_subcategory_id) VALUES (DEFAULT, 2, 3);
INSERT INTO standard_category_relation (id, standard_category_id, standard_subcategory_id) VALUES (DEFAULT, 2, 4);
INSERT INTO standard_category_relation (id, standard_category_id, standard_subcategory_id) VALUES (DEFAULT, 3, 5);
INSERT INTO standard_category_relation (id, standard_category_id, standard_subcategory_id) VALUES (DEFAULT, 3, 6);
INSERT INTO standard_category_relation (id, standard_category_id, standard_subcategory_id) VALUES (DEFAULT, 3, 7);
INSERT INTO standard_category_relation (id, standard_category_id, standard_subcategory_id) VALUES (DEFAULT, 3, 8);
INSERT INTO standard_category_relation (id, standard_category_id, standard_subcategory_id) VALUES (DEFAULT, 3, 9);
INSERT INTO standard_category_relation (id, standard_category_id, standard_subcategory_id) VALUES (DEFAULT, 3, 10);
INSERT INTO standard_category_relation (id, standard_category_id, standard_subcategory_id) VALUES (DEFAULT, 3, 11);

INSERT INTO account_type (id, name, description) VALUES (DEFAULT, 'Arvelduskonto', 'Tavaline arvelduskonto, kust teed igapäevaseid makseid');
INSERT INTO account_type (id, name, description) VALUES (DEFAULT, 'Säästukonto / hoius', 'Arvelduskonto, kuhu paned raha kõrvale');
INSERT INTO account_type (id, name, description) VALUES (DEFAULT, 'Krediitkaart', 'See kaart, mis võib miinusesse minna');
INSERT INTO account_type (id, name, description) VALUES (DEFAULT, 'Investeerimiskonto', 'Pangakonto, millelt teed investeeringuid');
INSERT INTO account_type (id, name, description) VALUES (DEFAULT, 'Kodulaen', 'Kodulaenu jääk');
INSERT INTO account_type (id, name, description) VALUES (DEFAULT, 'Muu laen', 'Muu laenu jääk');

INSERT INTO account (id, user_id, account_type_id, name, description, balance) VALUES (DEFAULT, 1, 1, 'Konto LHV pangas', 'Minu konto LHV pangas', 100);
INSERT INTO account (id, user_id, account_type_id, name, description, balance) VALUES (DEFAULT, 1, 3, 'Swedbank krediitkaart', 'Kredekas', 0);

INSERT INTO category (id, user_id, name, sequence, type) VALUES (DEFAULT, 1, 'Aktiivsed tulud', 1, 'i');
INSERT INTO category (id, user_id, name, sequence, type) VALUES (DEFAULT, 1, 'Passiivsed tulud', 2, 'i');
INSERT INTO category (id, user_id, name, sequence, type) VALUES (DEFAULT, 1, 'Vältimatud kulud', 3, 'e');
INSERT INTO category (id, user_id, name, sequence, type) VALUES (DEFAULT, 1, 'Eluase', 4, 'e');
INSERT INTO category (id, user_id, name, sequence, type) VALUES (DEFAULT, 1, 'Hooajalised kulud', 5, 'e');
INSERT INTO category (id, user_id, name, sequence, type) VALUES (DEFAULT, 1, 'Elukvaliteet', 6, 'e');
INSERT INTO category (id, user_id, name, sequence, type) VALUES (DEFAULT, 1, 'Lapsed', 7, 'e');
INSERT INTO category (id, user_id, name, sequence, type) VALUES (DEFAULT, 1, 'Meelelahutus', 8, 'e');

INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Palk', 1, 'i');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Lastetoetus', 2, 'i');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Dividendid', 3, 'i');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Üüritulu', 4, 'i');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Toidupood', 5, 'e');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Transport', 6, 'e');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Lemmikloom', 7, 'e');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Telefon', 8, 'e');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Kodukulud', 9, 'e');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Ravikulud', 10, 'e');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Tasud ja viivised', 11, 'e');

INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 1, 1, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 1, 2, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 2, 3, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 2, 4, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 3, 5, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 3, 6, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 3, 7, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 3, 8, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 3, 9, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 3, 10, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 3, 11, true);

INSERT INTO category (id, user_id, name, sequence, type) VALUES (DEFAULT, 2, 'Aktiivsed tulud', 1, 'i');
INSERT INTO category (id, user_id, name, sequence, type) VALUES (DEFAULT, 2, 'Passiivsed tulud', 2, 'i');
INSERT INTO category (id, user_id, name, sequence, type) VALUES (DEFAULT, 2, 'Vältimatud kulud', 3, 'e');
INSERT INTO category (id, user_id, name, sequence, type) VALUES (DEFAULT, 2, 'Eluase', 4, 'e');
INSERT INTO category (id, user_id, name, sequence, type) VALUES (DEFAULT, 2, 'Hooajalised kulud', 5, 'e');
INSERT INTO category (id, user_id, name, sequence, type) VALUES (DEFAULT, 2, 'Elukvaliteet', 6, 'e');
INSERT INTO category (id, user_id, name, sequence, type) VALUES (DEFAULT, 2, 'Lapsed', 7, 'e');
INSERT INTO category (id, user_id, name, sequence, type) VALUES (DEFAULT, 2, 'Meelelahutus', 8, 'e');

INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Palk', 1, 'i');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Lastetoetus', 2, 'i');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Dividendid', 3, 'i');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Üüritulu', 4, 'i');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Toidupood', 5, 'e');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Transport', 6, 'e');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Lemmikloom', 7, 'e');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Telefon', 8, 'e');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Kodukulud', 9, 'e');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Ravikulud', 10, 'e');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Tasud ja viivised', 11, 'e');

INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 9, 12, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 9, 13, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 10, 14, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 10, 15, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 11, 16, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 11, 17, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 11, 18, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 11, 19, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 11, 20, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 11, 21, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 11, 22, true);

INSERT INTO category (id, user_id, name, sequence, type) VALUES (DEFAULT, 3, 'Aktiivsed tulud', 1, 'i');
INSERT INTO category (id, user_id, name, sequence, type) VALUES (DEFAULT, 3, 'Passiivsed tulud', 2, 'i');
INSERT INTO category (id, user_id, name, sequence, type) VALUES (DEFAULT, 3, 'Vältimatud kulud', 3, 'e');
INSERT INTO category (id, user_id, name, sequence, type) VALUES (DEFAULT, 3, 'Eluase', 4, 'e');
INSERT INTO category (id, user_id, name, sequence, type) VALUES (DEFAULT, 3, 'Hooajalised kulud', 5, 'e');
INSERT INTO category (id, user_id, name, sequence, type) VALUES (DEFAULT, 3, 'Elukvaliteet', 6, 'e');
INSERT INTO category (id, user_id, name, sequence, type) VALUES (DEFAULT, 3, 'Lapsed', 7, 'e');
INSERT INTO category (id, user_id, name, sequence, type) VALUES (DEFAULT, 3, 'Meelelahutus', 8, 'e');

INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Palk', 1, 'i');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Lastetoetus', 2, 'i');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Dividendid', 3, 'i');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Üüritulu', 4, 'i');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Toidupood', 5, 'e');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Transport', 6, 'e');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Lemmikloom', 7, 'e');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Telefon', 8, 'e');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Kodukulud', 9, 'e');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Ravikulud', 10, 'e');
INSERT INTO subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Tasud ja viivised', 11, 'e');

INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 17, 23, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 17, 24, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 18, 25, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 18, 26, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 19, 27, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 19, 28, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 19, 29, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 19, 30, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 19, 31, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 19, 32, true);
INSERT INTO category_relation (id, category_id, subcategory_id, is_active) VALUES (DEFAULT, 19, 33, true);

INSERT INTO transaction (id, user_id,sender_account_id,receiver_account_id,date,subcategory_id,description,amount,type,is_active) VALUES (DEFAULT,1,1,NULL,'2022-08-01',5,'Selver',10.4,'e',true);
INSERT INTO transaction (id, user_id,sender_account_id,receiver_account_id,date,subcategory_id,description,amount,type,is_active) VALUES (DEFAULT,1,1,NULL,'2022-08-02',5,'Selver',100.22,'e',true);
INSERT INTO transaction (id, user_id,sender_account_id,receiver_account_id,date,subcategory_id,description,amount,type,is_active) VALUES (DEFAULT,1,1,NULL,'2022-08-05',5,'Selver',25.78,'e',true);
INSERT INTO transaction (id, user_id,sender_account_id,receiver_account_id,date,subcategory_id,description,amount,type,is_active) VALUES (DEFAULT,1,1,NULL,'2022-08-05',6,'Kulu',25.41,'e',true);
INSERT INTO transaction (id, user_id,sender_account_id,receiver_account_id,date,subcategory_id,description,amount,type,is_active) VALUES (DEFAULT,1,1,NULL,'2022-09-01',5,'Selver',10.03,'e',true);
INSERT INTO transaction (id, user_id,sender_account_id,receiver_account_id,date,subcategory_id,description,amount,type,is_active) VALUES (DEFAULT,1,1,NULL,'2022-09-02',5,'Rimi',7.55,'e',true);
INSERT INTO transaction (id, user_id,sender_account_id,receiver_account_id,date,subcategory_id,description,amount,type,is_active) VALUES (DEFAULT,1,1,NULL,'2022-09-05',5,'Selver toit',45.70,'e',true);

