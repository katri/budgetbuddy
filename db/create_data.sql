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
INSERT INTO standard_category (id, name, sequence, type) VALUES (DEFAULT, 'Vältimatud kulud', 3, 'o');
INSERT INTO standard_category (id, name, sequence, type) VALUES (DEFAULT, 'Eluase', 4, 'o');
INSERT INTO standard_category (id, name, sequence, type) VALUES (DEFAULT, 'Hooajalised kulud', 5, 'o');
INSERT INTO standard_category (id, name, sequence, type) VALUES (DEFAULT, 'Elukvaliteet', 6, 'o');
INSERT INTO standard_category (id, name, sequence, type) VALUES (DEFAULT, 'Lapsed', 7, 'o');
INSERT INTO standard_category (id, name, sequence, type) VALUES (DEFAULT, 'Meelelahutus', 8, 'o');

INSERT INTO standard_subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Palk', 1, 'i');
INSERT INTO standard_subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Lastetoetus', 2, 'i');
INSERT INTO standard_subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Dividendid', 3, 'i');
INSERT INTO standard_subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Üüritulu', 4, 'i');
INSERT INTO standard_subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Toidupood', 5, 'o');
INSERT INTO standard_subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Transport', 6, 'o');
INSERT INTO standard_subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Lemmikloom', 7, 'o');
INSERT INTO standard_subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Telefon', 8, 'o');
INSERT INTO standard_subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Kodukulud', 9, 'o');
INSERT INTO standard_subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Ravikulud', 10, 'o');
INSERT INTO standard_subcategory (id, name, sequence, type) VALUES (DEFAULT, 'Tasud ja viivised', 11, 'o');

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

INSERT INTO account (id, user_id, type_id, name, description, balance) VALUES (DEFAULT, 1, 1, 'Konto LHV pangas', 'Minu konto LHV pangas', 100);
INSERT INTO account (id, user_id, type_id, name, description, balance) VALUES (DEFAULT, 1, 3, 'Swedbank krediitkaart', 'Kredekas', 0);



