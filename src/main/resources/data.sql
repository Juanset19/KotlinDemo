INSERT INTO genre(id, name) VALUES (1, 'HISTORY');
INSERT INTO genre(id, name) VALUES (2, 'THRILLER');
INSERT INTO genre(id, name) VALUES (3, 'ROMANCE');
INSERT INTO genre(id, name) VALUES (4, 'ART');
INSERT INTO genre(id, name) VALUES (5, 'ACADEMIC');
INSERT INTO genre(id, name) VALUES (6, 'FANTASY');

INSERT INTO author(id, name, last_name) VALUES (1, 'Gabriel', 'García Marquez');
INSERT INTO author(id, name, last_name) VALUES (2, 'Hector', 'Abad');
INSERT INTO author(id, name, last_name) VALUES (3, 'Efraim', 'Medina');
INSERT INTO author(id, name, last_name) VALUES (4, 'Carl', 'Sagan');

INSERT INTO book(id, title, genre_id, author_id) VALUES (1, 'Cien años de soledad', 6, 1);
INSERT INTO book(id, title, genre_id, author_id) VALUES (2, 'El olvido que seremos', 1, 2);
INSERT INTO book(id, title, genre_id, author_id) VALUES (3, 'Érase una vez el amor pero tuve que matarlo', 3, 3);
INSERT INTO book(id, title, genre_id, author_id) VALUES (4, 'Los dragones del edén', 1, 4);
INSERT INTO book(id, title, genre_id, author_id) VALUES (5, 'Relato de un naúfrago', 1, 1);
INSERT INTO book(id, title, genre_id, author_id) VALUES (6, 'Cinema Árbol', 1, 3);

