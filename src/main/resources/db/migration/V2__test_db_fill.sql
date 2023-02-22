INSERT INTO cities(name)
VALUES ('Moscow'),
       ('Sochi'),
       ('Tyumen'),
       ('Saint Petersburg'),
       ('Kazan');

INSERT INTO streets(name, city_id)
VALUES ('Plastunskaya', 2),
       ('Tomskaya', 1),
       ('Lenina', 3),
       ('Chepaeva', 4),
       ('Vysockogo', 5),
       ('Lipovaya', 2),
       ('Gorkovo', 3),
       ('Goncharova', 5);

INSERT INTO houses(number, street_id)
VALUES (5, 1),
       (13, 2),
       (67, 3),
       (44, 4),
       (56, 5),
       (9, 6),
       (111, 7),
       (24, 8),
       (37, 1),
       (59, 2),
       (92, 3),
       (65, 4),
       (215, 5);

INSERT INTO apartments(area, house_id)
VALUES (55.8, 6),
       (63.2, 4),
       (111.7, 3),
       (44.5, 1),
       (98.8, 2),
       (43.5, 5),
       (28.4, 7),
       (53.1, 8),
       (24.3, 9),
       (51.8, 10),
       (81.5, 11),
       (76.2, 12),
       (39.7, 13),
       (34.5, 12),
       (46.7, 13),
       (81.3, 13);