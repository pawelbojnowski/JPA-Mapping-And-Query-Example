CREATE SCHEMA IF NOT EXISTS mapping_1_base_entity;
CREATE SCHEMA IF NOT EXISTS mapping_2_many_to_one;
CREATE SCHEMA IF NOT EXISTS mapping_3_many_to_many;
CREATE SCHEMA IF NOT EXISTS mapping_4_one_to_one;
CREATE SCHEMA IF NOT EXISTS mapping_5_embedded;
CREATE SCHEMA IF NOT EXISTS mapping_6_collections;
CREATE SCHEMA IF NOT EXISTS mapping_7_collections_map;
CREATE SCHEMA IF NOT EXISTS mapping_8_id_class;
CREATE SCHEMA IF NOT EXISTS mapping_9_inheritance;
CREATE SCHEMA IF NOT EXISTS mapping_10_secondary_table;
CREATE SCHEMA IF NOT EXISTS mapping_11_join_tables;
CREATE SCHEMA IF NOT EXISTS queries;

--- INSERTS
INSERT INTO queries.error (createdDate, description, errorType, level, name, parent_error_id) VALUES ('2015-07-10', 'description 1', 1, 1, 'name 1', NULL);
INSERT INTO queries.error (createdDate, description, errorType, level, name, parent_error_id) VALUES ('2015-07-10', 'description 2', 1, 6, 'name 2', 1);
INSERT INTO queries.error (createdDate, description, errorType, level, name, parent_error_id) VALUES ('2015-07-10', 'description 3', 1, 5, 'name 3', 1);
INSERT INTO queries.error (createdDate, description, errorType, level, name, parent_error_id) VALUES ('2015-07-15', 'description 4', 1, 1, 'name 4', NULL);
INSERT INTO queries.error (createdDate, description, errorType, level, name, parent_error_id) VALUES ('2015-07-15', 'description 5', 2, 1, 'name 5', 4);
INSERT INTO queries.error (createdDate, description, errorType, level, name, parent_error_id) VALUES ('2015-07-15', 'description 6', 2, 12, 'name 6', 4);
INSERT INTO queries.error (createdDate, description, errorType, level, name, parent_error_id) VALUES ('2015-07-15', 'description 7', 0, 10, 'name 7', 4);

DROP TABLE IF EXISTS queries.error_view;
CREATE OR REPLACE VIEW queries.error_view AS SELECT id, CONCAT('View_', name) AS name, CONCAT('View_', description) AS description FROM queries.error;