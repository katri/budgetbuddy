-- Kustutab public schema (mis põhimõtteliselt kustutab kõik tabelid)
DROP SCHEMA public CASCADE;
-- Loob uue public schema vajalikud õigused
CREATE SCHEMA public
-- taastab vajalikud andmebaasi õigused
    GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- SIIA ALLA TULEB VERTABELO TABELITE LOOMISE OSA

-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-09-08 20:40:06.79

-- tables
-- Table: account
CREATE TABLE account (
                         id serial  NOT NULL,
                         user_id int  NOT NULL,
                         account_type_id int  NOT NULL,
                         name varchar(255)  NOT NULL,
                         description varchar(255)  NULL,
                         balance int  NOT NULL,
                         CONSTRAINT account_pk PRIMARY KEY (id)
);

-- Table: account_type
CREATE TABLE account_type (
                              id serial  NOT NULL,
                              name varchar(255)  NOT NULL,
                              description varchar(255)  NULL,
                              CONSTRAINT account_type_pk PRIMARY KEY (id)
);

-- Table: budgeted
CREATE TABLE budgeted (
                          id serial  NOT NULL,
                          user_id int  NOT NULL,
                          year int  NOT NULL,
                          month_id int  NOT NULL,
                          amount int  NOT NULL,
                          subcategory_id int  NOT NULL,
                          is_active boolean  NOT NULL DEFAULT true,
                          CONSTRAINT budgeted_pk PRIMARY KEY (id)
);

-- Table: category
CREATE TABLE category (
                          id serial  NOT NULL,
                          user_id int  NOT NULL,
                          name varchar(255)  NOT NULL,
                          sequence int  NOT NULL,
                          type char(1)  NOT NULL,
                          CONSTRAINT category_pk PRIMARY KEY (id)
);

-- Table: category_relation
CREATE TABLE category_relation (
                                   id serial  NOT NULL,
                                   category_id int  NOT NULL,
                                   subcategory_id int  NOT NULL,
                                   is_active boolean  NOT NULL DEFAULT true,
                                   CONSTRAINT category_relation_pk PRIMARY KEY (id)
);

-- Table: month
CREATE TABLE month (
                       id serial  NOT NULL,
                       name varchar(255)  NOT NULL,
                       number int  NOT NULL,
                       CONSTRAINT month_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
                      id serial  NOT NULL,
                      name varchar(255)  NOT NULL,
                      CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: standard_category
CREATE TABLE standard_category (
                                   id serial  NOT NULL,
                                   name varchar(255)  NOT NULL,
                                   sequence int  NOT NULL,
                                   type char(1)  NOT NULL,
                                   CONSTRAINT standard_category_pk PRIMARY KEY (id)
);

-- Table: standard_category_relation
CREATE TABLE standard_category_relation (
                                            id serial  NOT NULL,
                                            standard_category_id int  NOT NULL,
                                            standard_subcategory_id int  NOT NULL,
                                            CONSTRAINT standard_category_relation_pk PRIMARY KEY (id)
);

-- Table: standard_subcategory
CREATE TABLE standard_subcategory (
                                      id serial  NOT NULL,
                                      name varchar(255)  NOT NULL,
                                      sequence int  NOT NULL,
                                      type char(1)  NULL,
                                      CONSTRAINT standard_subcategory_pk PRIMARY KEY (id)
);

-- Table: subcategory
CREATE TABLE subcategory (
                             id serial  NOT NULL,
                             name varchar(255)  NOT NULL,
                             sequence int  NOT NULL,
                             type char(1)  NULL,
                             CONSTRAINT subcategory_pk PRIMARY KEY (id)
);

-- Table: transaction
CREATE TABLE transaction (
                             id serial  NOT NULL,
                             user_id int  NOT NULL,
                             sender_account_id int  NOT NULL,
                             receiver_account_id int  NULL,
                             date date  NOT NULL,
                             subcategory_id int  NOT NULL,
                             description varchar(255)  NULL,
                             amount int  NOT NULL,
                             type char(1)  NOT NULL,
                             is_active boolean  NOT NULL DEFAULT true,
                             CONSTRAINT transaction_log_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
                        id serial  NOT NULL,
                        role_id int  NOT NULL,
                        user_name varchar(255)  NOT NULL,
                        password varchar(255)  NOT NULL,
                        email varchar(255)  NOT NULL,
                        CONSTRAINT user_ak_1 UNIQUE (user_name) NOT DEFERRABLE  INITIALLY IMMEDIATE,
                        CONSTRAINT user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: account_type (table: account)
ALTER TABLE account ADD CONSTRAINT account_type
    FOREIGN KEY (account_type_id)
        REFERENCES account_type (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: account_user (table: account)
ALTER TABLE account ADD CONSTRAINT account_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: budgeted_month (table: budgeted)
ALTER TABLE budgeted ADD CONSTRAINT budgeted_month
    FOREIGN KEY (month_id)
        REFERENCES month (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: budgeted_subcategory (table: budgeted)
ALTER TABLE budgeted ADD CONSTRAINT budgeted_subcategory
    FOREIGN KEY (subcategory_id)
        REFERENCES subcategory (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: budgeted_user (table: budgeted)
ALTER TABLE budgeted ADD CONSTRAINT budgeted_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: category_relation_category (table: category_relation)
ALTER TABLE category_relation ADD CONSTRAINT category_relation_category
    FOREIGN KEY (category_id)
        REFERENCES category (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: category_relation_subcategory (table: category_relation)
ALTER TABLE category_relation ADD CONSTRAINT category_relation_subcategory
    FOREIGN KEY (subcategory_id)
        REFERENCES subcategory (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: category_user (table: category)
ALTER TABLE category ADD CONSTRAINT category_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: standard_category_relation_standard_category (table: standard_category_relation)
ALTER TABLE standard_category_relation ADD CONSTRAINT standard_category_relation_standard_category
    FOREIGN KEY (standard_category_id)
        REFERENCES standard_category (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: standard_category_relation_standard_subcategory (table: standard_category_relation)
ALTER TABLE standard_category_relation ADD CONSTRAINT standard_category_relation_standard_subcategory
    FOREIGN KEY (standard_subcategory_id)
        REFERENCES standard_subcategory (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: transaction_account_receiver (table: transaction)
ALTER TABLE transaction ADD CONSTRAINT transaction_account_receiver
    FOREIGN KEY (receiver_account_id)
        REFERENCES account (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: transaction_account_sender (table: transaction)
ALTER TABLE transaction ADD CONSTRAINT transaction_account_sender
    FOREIGN KEY (sender_account_id)
        REFERENCES account (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: transaction_subcategory (table: transaction)
ALTER TABLE transaction ADD CONSTRAINT transaction_subcategory
    FOREIGN KEY (subcategory_id)
        REFERENCES subcategory (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: transaction_user (table: transaction)
ALTER TABLE transaction ADD CONSTRAINT transaction_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_role
    FOREIGN KEY (role_id)
        REFERENCES role (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.

