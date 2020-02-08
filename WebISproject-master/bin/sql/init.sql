INSERT INTO `wis`.`student` (`card_number`, `first_name`, `last_name`, `deleted`, `version`) VALUES ('123', 'Jovan', 'Jovanovic', b'0', b'0');

INSERT INTO `wis`.`course` (`ects`, `deleted`, `number_of_excercises`, `number_of_lectures`, `obligatory`, `title`, `version`) VALUES (6, 0, 4, 2, 1, 'Objektno orjentisano programiranje', 0);
INSERT INTO `wis`.`course` (`ects`, `deleted`, `number_of_excercises`, `number_of_lectures`, `obligatory`, `title`, `version`) VALUES (4, 0, 4, 2, 1, 'Algoritmi', 0);
INSERT INTO `wis`.`course` (`ects`, `deleted`, `number_of_excercises`, `number_of_lectures`, `obligatory`, `title`, `version`) VALUES (5, 0, 4, 2, 1, 'Strukture podataka', 0);
INSERT INTO `wis`.`course` (`ects`, `deleted`, `number_of_excercises`, `number_of_lectures`, `obligatory`, `title`, `version`) VALUES (3, 0, 4, 2, 1, 'Linerna algebra', 0);
INSERT INTO `wis`.`course` (`ects`, `deleted`, `number_of_excercises`, `number_of_lectures`, `obligatory`, `title`, `version`) VALUES (6, 0, 4, 2, 1, 'Diskretna matematika', 0);
INSERT INTO `wis`.`course` (`ects`, `deleted`, `number_of_excercises`, `number_of_lectures`, `obligatory`, `title`, `version`) VALUES (7, 0, 4, 2, 1, 'Teorija grafova', 0);
INSERT INTO `wis`.`course` (`ects`, `deleted`, `number_of_excercises`, `number_of_lectures`, `obligatory`, `title`, `version`) VALUES (8, 0, 4, 2, 1, 'Statisktika i verovatnoća', 0);
INSERT INTO `wis`.`course` (`ects`, `deleted`, `number_of_excercises`, `number_of_lectures`, `obligatory`, `title`, `version`) VALUES (5, 0, 4, 2, 1, 'Soft computing', 0);
INSERT INTO `wis`.`course` (`ects`, `deleted`, `number_of_excercises`, `number_of_lectures`, `obligatory`, `title`, `version`) VALUES (6, 0, 4, 2, 1, 'Funkcionalno programiranje', 0);
INSERT INTO `wis`.`course` (`ects`, `deleted`, `number_of_excercises`, `number_of_lectures`, `obligatory`, `title`, `version`) VALUES (4, 0, 4, 2, 1, 'Logicko programiranje', 0);
INSERT INTO `wis`.`course` (`ects`, `deleted`, `number_of_excercises`, `number_of_lectures`, `obligatory`, `title`, `version`) VALUES (7, 0, 4, 2, 1, 'Biološki insipirisano računarstvo', 0);
INSERT INTO `wis`.`course` (`ects`, `deleted`, `number_of_excercises`, `number_of_lectures`, `obligatory`, `title`, `version`) VALUES (7, 0, 4, 2, 1, 'proceduralno programiranje', 0);
INSERT INTO `wis`.`course` (`ects`, `deleted`, `number_of_excercises`, `number_of_lectures`, `obligatory`, `title`, `version`) VALUES (3, 0, 4, 2, 1, 'Paradigme programiranja', 0);
INSERT INTO `wis`.`course` (`ects`, `deleted`, `number_of_excercises`, `number_of_lectures`, `obligatory`, `title`, `version`) VALUES (6, 0, 4, 2, 1, 'Modelovanje softvera', 0);
INSERT INTO `wis`.`course` (`ects`, `deleted`, `number_of_excercises`, `number_of_lectures`, `obligatory`, `title`, `version`) VALUES (7, 0, 4, 2, 1, 'Web programiranje', 0);
INSERT INTO `wis`.`course` (`ects`, `deleted`, `number_of_excercises`, `number_of_lectures`, `obligatory`, `title`, `version`) VALUES (5, 0, 4, 2, 1, 'Arhitekture Web aplikacija', 0);
INSERT INTO `wis`.`course` (`ects`, `deleted`, `number_of_excercises`, `number_of_lectures`, `obligatory`, `title`, `version`) VALUES (5, 0, 4, 2, 1, 'Racunarska inteligencija', 0);
INSERT INTO `wis`.`course` (`ects`, `deleted`, `number_of_excercises`, `number_of_lectures`, `obligatory`, `title`, `version`) VALUES (4, 0, 4, 2, 1, 'Masinsko ucenje', 0);
INSERT INTO `wis`.`course` (`ects`, `deleted`, `number_of_excercises`, `number_of_lectures`, `obligatory`, `title`, `version`) VALUES (7, 0, 4, 2, 1, 'Poslovna inteligencija', 0);
INSERT INTO `wis`.`course` (`ects`, `deleted`, `number_of_excercises`, `number_of_lectures`, `obligatory`, `title`, `version`) VALUES (8, 0, 4, 2, 1, 'Neruonske mreze', 0);
INSERT INTO `wis`.`course` (`ects`, `deleted`, `number_of_excercises`, `number_of_lectures`, `obligatory`, `title`, `version`) VALUES (5, 0, 4, 2, 1, 'Fuzzy sistemi', 0);
INSERT INTO `wis`.`course` (`ects`, `deleted`, `number_of_excercises`, `number_of_lectures`, `obligatory`, `title`, `version`) VALUES (4, 0, 4, 2, 1, 'Operaciona istrazivanja', 0);
INSERT INTO `wis`.`course` (`ects`, `deleted`, `number_of_excercises`, `number_of_lectures`, `obligatory`, `title`, `version`) VALUES (3, 0, 4, 2, 1, 'Duboko ucenje', 0);

INSERT INTO `wis`.`course_realization` (`deleted`, `end_date`, `start_date`, `version`, `course_id`) VALUES (0, '2019-02-02', '2019-06-06', 0, 1);

INSERT INTO `wis`.`course_attending` (`deleted`, `version`, `student_id`, `course_realization_id`) VALUES (0, 0, 19, 1);

INSERT INTO `wis`.`teacher` (`deleted`, `first_name`, `last_name`, `personal_identification_number`, `version`) VALUES (0, 'Stefan', 'Stefanovic', '123123', 0);

INSERT INTO `wis`.`year_of_study` (`deleted`, `number_of_year`, `version`) VALUES (0, 1, 0);
INSERT INTO `wis`.`year_of_study` (`deleted`, `number_of_year`, `version`) VALUES (0, 2, 0);
INSERT INTO `wis`.`year_of_study` (`deleted`, `number_of_year`, `version`) VALUES (0, 3, 0);
INSERT INTO `wis`.`year_of_study` (`deleted`, `number_of_year`, `version`) VALUES (0, 4, 0);
