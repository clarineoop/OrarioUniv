
DROP DATABASE orariouniv;
CREATE DATABASE orariouniv;

use orariouniv;

/*set dateformat dmy*/

CREATE TABLE amministratore(
	id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
	pwd varchar(100),
	nome varchar(40),
	cognome varchar(40)
);

INSERT INTO amministratore(pwd, nome, cognome) VALUES
('H', 'Marco', 'Rossi');


CREATE TABLE corso(
	codice varchar(40) PRIMARY KEY,
	nome varchar(40) NOT NULL,
	num_anni int NOT NULL
);


INSERT INTO corso VALUES
('INFO', 'INFORMATICA', 3);


CREATE TABLE studente(
	matricola int NOT NULL AUTO_INCREMENT,
	nome_studente varchar(40),
	cognome_studente varchar(40),
	pwd varchar(100),
	corso varchar(40),
	anno_corso int,
	FOREIGN KEY(corso) REFERENCES corso(codice)
    ON UPDATE CASCADE ON DELETE CASCADE,
	PRIMARY KEY(matricola) 
);


INSERT INTO studente(nome_studente, cognome_studente, pwd, corso, anno_corso) VALUES
('Luca', 'Gatti', '202946', 'INFO', '2');


CREATE TABLE aula(
	nome_aula varchar(40) PRIMARY KEY
);


INSERT INTO aula VALUES
("Aula1"),
("Aula2"),
("Aula3"),
("Aula4"),
("Aula5"),
("Aula6"),
("Aula7"),
("Aula8"),
("Aula9"),
("Aula10");



CREATE TABLE materia(
	codice varchar(40),
	nome varchar(40) NOT NULL,
	crediti int NOT NULL,
	corso varchar(40),
	anno_corso int,
	FOREIGN KEY(corso) REFERENCES corso(codice)
	ON UPDATE CASCADE ON DELETE CASCADE,
	PRIMARY KEY(codice)
);

/*
INSERT INTO materia() VALUES
(),
(),
();
*/

CREATE TABLE lezione(
	id int NOT NULL AUTO_INCREMENT,
	giorno int NOT NULL, /*va da 1 a 7, 1 per lunedi e 7 per domenica*/
	ora_inizio time NOT NULL,
	ora_fine time NOT NULL,
	aula varchar(40) NOT NULL,
	materia varchar(40) NOT NULL,
	corso varchar(40) NOT NULL,
	anno_corso int NOT NULL,
	PRIMARY KEY(id),
	UNIQUE(giorno, ora_inizio, aula),
	FOREIGN KEY(materia) REFERENCES materia(codice)
       ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY(corso) REFERENCES corso(codice)
       ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY(aula) REFERENCES aula(nome_aula)
       ON UPDATE CASCADE ON DELETE CASCADE
);

/*
INSERT INTO lezione() VALUES
(),
(),
(),
(),
(),
(),
();
*/

CREATE TABLE esame(
	id int NOT NULL AUTO_INCREMENT,
	data date NOT NULL,
	ora_inizio time NOT NULL,
	ora_fine time NOT NULL,
	aula varchar(40) NOT NULL,
	materia varchar(40) NOT NULL,
	PRIMARY KEY(id),
	UNIQUE(data, ora_inizio, aula),
	FOREIGN KEY(materia) REFERENCES materia(codice)
       ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY(aula) REFERENCES aula(nome_aula)
       ON UPDATE CASCADE ON DELETE CASCADE
);

/*
INSERT INTO esame() VALUES
(),
(),
(),
(),
();
*/

CREATE TABLE voto(
	id int NOT NULL AUTO_INCREMENT,
	voto float NOT NULL,
	materia varchar(40),
	studente int,
	PRIMARY KEY(id),
	FOREIGN KEY(materia) REFERENCES materia(codice)
       ON UPDATE CASCADE ON DELETE CASCADE,
	FOREIGN KEY(studente) REFERENCES studente(matricola)
       ON UPDATE CASCADE ON DELETE CASCADE
);

/*
INSERT INTO voto() VALUES
(),
(),
();
*/

CREATE TABLE giorni(
	nome varchar(10) NOT NULL PRIMARY KEY,
	valore int NOT NULL
);

INSERT INTO giorni VALUES
('lunedì', 1),
('martedì', 2),
('mercoledì', 3),
('giovedì', 4),
('venerdì', 5),
('sabato', 6),
('domenica', 7);



/*

IF OBJECT_ID('lezione_di_dopo', 'V') IS NOT NULL
DROP VIEW lezione_di_dopo;

CREATE VIEW lezione_di_dopo AS
SELECT l.giorno, l.ora_inizio, l.ora_fine, l.aula, l.nome_materia
FROM lezione l
WHERE l.nome_studente = 'Marco Rossi'
AND l.giorno >= ( SELECT g.valore from giorni g where g.nome = datename(dw, getdate()) )

IF OBJECT_ID('lezioni_min_day', 'V') IS NOT NULL
DROP VIEW lezioni_min_day;

CREATE VIEW lezioni_min_day AS
SELECT ld.giorno, ld.ora_inizio, ld.ora_fine, ld.aula, ld.nome_materia
FROM lezione_di_dopo ld
WHERE ld.giorno <= ALL(SELECT ld2.giorno FROM lezione_di_dopo ld2)

SELECT lmd.giorno, lmd.ora_inizio, lmd.ora_fine, lmd.aula, lmd.nome_materia
FROM lezioni_min_day lmd
WHERE lmd.ora_inizio > CONVERT (time, SYSDATETIME())
AND lmd.ora_inizio <= ALL(SELECT lmd2.ora_inizio FROM lezioni_min_day lmd2 WHERE lmd2.ora_inizio > CONVERT (time, SYSDATETIME()));


SELECT g.valore from giorni g where g.nome = datename(dw, getdate())

SELECT l.giorno, l.ora_inizio, l.ora_fine, l.aula, l.nome_materia
FROM lezione l
WHERE l.giorno = 1
AND l.nome_studente = 'Marco Rossi'
AND l.ora_inizio <= ALL (SELECT l2.ora_inizio FROM lezione l2 WHERE l2.giorno = 1 AND l2.nome_studente = 'Marco Rossi' )

SELECT l.giorno, l.ora_inizio, l.ora_fine, l.aula, l.nome_materia
FROM lezione l
WHERE l.giorno - 1 = (SELECT g.valore from giorni g where g.nome = datename(dw, getdate()))
AND l.nome_studente = 'Marco Rossi'
AND l.ora_inizio <= ALL (SELECT l2.ora_inizio FROM lezione l2 WHERE l2.giorno = 1 AND l2.nome_studente = 'Marco Rossi' )

SELECT e.data, e.ora_inizio, e.ora_fine, e.aula, e.nome_materia
FROM esame e
WHERE e.data > getdate()
and e.nome_studente = 'Marco Rossi'
and e.data <= ALL (SELECT e2.data FROM esame e2 WHERE e2.data > getdate() and e2.nome_studente = 'Marco Rossi')
and e.ora_inizio <= ALL (SELECT e3.ora_inizio FROM esame e3 WHERE e3.data > getdate() and e3.nome_studente = 'Marco Rossi' AND e3.data <= ALL (SELECT e4.data FROM esame e4 WHERE e4.data > getdate() and e4.nome_studente = 'Marco Rossi'))


SELECT v.voto, v.nome_materia
FROM voto v
WHERE v.nome_studente = 'Marco Rossi'
AND v.voto >= ALL (SELECT v2.voto FROM voto v2 WHERE v2.nome_studente = 'Marco Rossi')

SELECT v.voto, v.nome_materia
FROM voto v
WHERE v.nome_studente = 'Marco Rossi'
AND v.voto <= ALL (SELECT v2.voto FROM voto v2 WHERE v2.nome_studente = 'Marco Rossi')


*/