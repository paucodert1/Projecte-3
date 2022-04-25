drop database if exists nwn;
create database nwn;

use nwn;

CREATE TABLE `Monitors` (
	`DNI` varchar(9) NOT NULL,
	`Nom` varchar(20) NOT NULL,
	`Cognom_1` varchar(20) NOT NULL,
	`Cognom_2` varchar(20) NOT NULL,
	`Tel` INT(9) NOT NULL,
	`Data_naixement` DATE NOT NULL,
	`Correu-e` varchar(255) NOT NULL,
	PRIMARY KEY (`DNI`)
);

CREATE TABLE `Cursos` (
	`ID` INT NOT NULL AUTO_INCREMENT,
	`Nom` varchar(20) NOT NULL,
	`Descripcio` varchar(255) NOT NULL,
	`DNI` varchar(9) NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Individual` (
	`ID` INT NOT NULL,
	`Preu/h` INT NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Colectiu` (
	`ID` INT NOT NULL,
	`Preu` INT NOT NULL,
	`Max_participants` INT NOT NULL,
	`Data` DATE NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Competicio` (
	`ID` INT NOT NULL,
	`Preu` INT NOT NULL,
	`Nivell` INT NOT NULL,
	`Data_inici` DATE NOT NULL,
	`Data_fi` DATE NOT NULL,
	`Durada` DATETIME NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Clients` (
	`DNI` varchar(9) NOT NULL,
	`Nom` varchar(20) NOT NULL,
	`Cognom_1` varchar(20) NOT NULL,
	`Cognom_2` varchar(20) NOT NULL,
	`Tel` INT(9) NOT NULL,
	`Data_naixement` DATE NOT NULL,
	`Correu-e` varchar(50) NOT NULL,
	`Sexe` varchar(1) NOT NULL,
	`Compte_Bancari` varchar(50) NOT NULL,
	`Usuari` varchar(20) NOT NULL,
	`Contrasenya` varchar(20) NOT NULL,
	PRIMARY KEY (`DNI`)
);

CREATE TABLE `Federats` (
	`DNI` varchar(9) NOT NULL,
	`Num_Fed` INT(20) NOT NULL,
	`Data_caduc` DATE NOT NULL,
	`Nivell` INT NOT NULL,
	PRIMARY KEY (`DNI`)
);

CREATE TABLE `Curse_I` (
	`ID` INT NOT NULL,
	`DNI` varchar(9) NOT NULL,
	`Hores` TIME NOT NULL,
	`Data` DATE NOT NULL,
	`Descomte/h` INT NOT NULL,
	`Preu_final` INT NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Curse_Col` (
	`ID` INT NOT NULL,
	`DNI` varchar(9) NOT NULL,
	`Descomte_FN` INT NOT NULL,
	`Preu_final` INT NOT NULL,
	`Cant_persones` INT NOT NULL,
	PRIMARY KEY (`ID`,`DNI`)
);

CREATE TABLE `Curse_Com` (
	`ID` INT NOT NULL,
	`DNI` varchar(9) NOT NULL,
	`Preu_final` INT NOT NULL,
	PRIMARY KEY (`ID`,`DNI`)
);

CREATE TABLE `Familia_nombrosa` (
	`DNI` varchar(9) NOT NULL,
	`Carnet_FN` varchar(40) NOT NULL,
	`Data_caduc` DATE NOT NULL,
	PRIMARY KEY (`DNI`)
);

CREATE TABLE `Productes` (
	`ID` INT NOT NULL AUTO_INCREMENT,
	`Marca` varchar(20) NOT NULL,
	`Model` varchar(20) NOT NULL,
	`Preu` INT NOT NULL,
	`Descompte` INT NOT NULL default '0',
	`Usos` INT NOT NULL DEFAULT '0',
	`Estat` BOOLEAN NOT NULL DEFAULT true,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Botes` (
	`ID` INT NOT NULL AUTO_INCREMENT,
	`Talla` INT NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Pals` (
	`ID` INT NOT NULL AUTO_INCREMENT,
	`Alçada` INT NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Esquís` (
	`ID` INT NOT NULL AUTO_INCREMENT,
	`Tipus` varchar(50) NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Kits` (
	`ID` INT NOT NULL AUTO_INCREMENT,
	`ID_P1` INT NOT NULL,
	`ID_P2` INT NOT NULL,
	`ID_P3` INT NOT NULL,
	`Preu` INT NOT NULL,
	`Usos` INT NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Format` (
	`ID_P` INT NOT NULL,
	`ID_K` INT NOT NULL,
	`Preu_Final` INT NOT NULL,
	PRIMARY KEY (`ID_P`,`ID_K`)
);

CREATE TABLE `Lloga_K` (
	`ID` int NOT NULL,
	`DNI` varchar(9) NOT NULL,
	`Data` DATETIME NOT NULL,
	`Data_tornada` DATETIME NOT NULL,
	PRIMARY KEY (`ID`,`DNI`)
);

CREATE TABLE `Lloga_P` (
	`ID` INT NOT NULL,
	`DNI` varchar(9) NOT NULL,
	`Data` DATETIME NOT NULL,
	`Preu_final` INT NOT NULL,
	`Data_tornada` DATETIME NOT NULL,
	PRIMARY KEY (`ID`,`DNI`)
);


ALTER TABLE `Cursos` ADD CONSTRAINT `Cursos_fk0` FOREIGN KEY (`DNI`) REFERENCES `Monitors`(`DNI`);

ALTER TABLE `Individual` ADD CONSTRAINT `Individual_fk0` FOREIGN KEY (`ID`) REFERENCES `Cursos`(`ID`);

ALTER TABLE `Colectiu` ADD CONSTRAINT `Colectiu_fk0` FOREIGN KEY (`ID`) REFERENCES `Cursos`(`ID`);

ALTER TABLE `Competicio` ADD CONSTRAINT `Competició_fk0` FOREIGN KEY (`ID`) REFERENCES `Cursos`(`ID`);

ALTER TABLE `Federats` ADD CONSTRAINT `Federats_fk0` FOREIGN KEY (`DNI`) REFERENCES `Clients`(`DNI`);

ALTER TABLE `Curse_I` ADD CONSTRAINT `Curse_I_fk0` FOREIGN KEY (`ID`) REFERENCES `Cursos`(`ID`);

ALTER TABLE `Curse_I` ADD CONSTRAINT `Curse_I_fk1` FOREIGN KEY (`DNI`) REFERENCES `Clients`(`DNI`);

ALTER TABLE `Curse_Col` ADD CONSTRAINT `Curse_Col_fk0` FOREIGN KEY (`ID`) REFERENCES `Cursos`(`ID`);

ALTER TABLE `Curse_Col` ADD CONSTRAINT `Curse_Col_fk1` FOREIGN KEY (`DNI`) REFERENCES `Clients`(`DNI`);

ALTER TABLE `Curse_Com` ADD CONSTRAINT `Curse_Com_fk0` FOREIGN KEY (`ID`) REFERENCES `Cursos`(`ID`);

ALTER TABLE `Curse_Com` ADD CONSTRAINT `Curse_Com_fk1` FOREIGN KEY (`DNI`) REFERENCES `Federats`(`DNI`);

ALTER TABLE `Familia_nombrosa` ADD CONSTRAINT `Familia_nombrosa_fk0` FOREIGN KEY (`DNI`) REFERENCES `Clients`(`DNI`);

ALTER TABLE `Botes` ADD CONSTRAINT `Botes_fk0` FOREIGN KEY (`ID`) REFERENCES `Productes`(`ID`);

ALTER TABLE `Pals` ADD CONSTRAINT `Pals_fk0` FOREIGN KEY (`ID`) REFERENCES `Productes`(`ID`);

ALTER TABLE `Esquís` ADD CONSTRAINT `Esquís_fk0` FOREIGN KEY (`ID`) REFERENCES `Productes`(`ID`);

ALTER TABLE `Format` ADD CONSTRAINT `Format_fk0` FOREIGN KEY (`ID_P`) REFERENCES `Productes`(`ID`);

ALTER TABLE `Format` ADD CONSTRAINT `Format_fk1` FOREIGN KEY (`ID_K`) REFERENCES `Kits`(`ID`);

ALTER TABLE `Lloga_K` ADD CONSTRAINT `Lloga_K_fk0` FOREIGN KEY (`ID`) REFERENCES `Kits`(`ID`);

ALTER TABLE `Lloga_K` ADD CONSTRAINT `Lloga_K_fk1` FOREIGN KEY (`DNI`) REFERENCES `Clients`(`DNI`);

ALTER TABLE `Lloga_P` ADD CONSTRAINT `Lloga_P_fk0` FOREIGN KEY (`ID`) REFERENCES `Productes`(`ID`);

ALTER TABLE `Lloga_P` ADD CONSTRAINT `Lloga_P_fk1` FOREIGN KEY (`DNI`) REFERENCES `Clients`(`DNI`);



#################
##   INSERTS   ##
#################

# Monitors #
insert into Monitors value ("78103615P", "Sergi", "Pont", "Balague", 600382677, 25/08/2003, "sergipb@gmail.com");
insert into Monitors value ("12345678J", "Marta", "Moreno", "Rubio", 643125476, 06/04/2000, "martamr@gmail.com");
insert into Monitors value ("56864844G", "Jordi", "Estnañ", "Font", 684212354, 18/10/1990, "jordief@gmail.com");


# Cursos #
insert into Cursos value (1, "Inicial", "Curs per a nous usuaris sense cap experiencia", "78103615P");
insert into Cursos value (default, "Desens Basic", "Curs per apendre a baixa corectament", "56864844G");
insert into Cursos value (default, "Mitg", "Curs per usuaris amb experiencia basica", "78103615P");
insert into Cursos value (default, "Max velocitat", "Curs per aconseguir la maxima velocitat en vaixada", "12345678J");
insert into Cursos value (default, "Acrobacies Basiques", "Curs per comensa amb acrobasies", "56864844G");

	# Individual #
	insert into individual value (1, 50);
	insert into individual value (3, 55);

	# Colectiu #
	insert into colectiu value (2, 30, 10, 05/01/2022);
	
	# Competicio #
    insert into competicio value (4, 60, 3, 05/01/2022, 07/01/2022, "48:00:00");
    insert into competicio value (5, 70, 1, 03/01/2022, 07/01/2022, "96:00:00");


# Clients #

insert into clients value ("15423675U", "Pau", "Rubio", "Silva", 62378912, 21/03/2003, "paurubiosilva@gmail.com", "M", "ES25 0019 0832 4975 2231 4577", "Prubio", "1234");
insert into clients value ("94941664R", "Sergi", "Folorencia", "Rotj", 624879216, 03/02/2003, "sergifr@gmail.com", "M", "ES28 6814 4959 7380 2145 2793", "UwU", "1234");
insert into clients value ("51515482D", "Paula", "Sanchez", "Canosa", 679123574, 19/11/2001, "paulasc@gmail.com", "F", "ES26 0149 3779 6978 6983 9149", "Paulita", "1234");
insert into clients value ("81664477H", "Paco", "Gimenez", "Gerra", 634897123, 07/05/1970, "pacogg@gmail.com", "M", "ES81 0077 9275 2263 3174 6967", "PacoGG", "1234");

	# Federat #
    
    insert into federats value ("51515482D", "564694", 22/04/2022, 3);
    
    # Familia Nombrosa #
    
	insert into Familia_nombrosa value ("81664477H", "69464616476", 22/04/2024);
    
    
# Curse_I #

insert into Curse_I value (1, "94941664R", "04:00:00", 14/01/2022, 30, 140);
insert into Curse_I value (3, "15423675U", "07:00:00", 14/01/2022, 50, 175);

# Curse_Col #

insert into Curse_Col value (2, "81664477H", 40, 108, 6);
insert into Curse_Col value (2, "15423675U", 0, 90, 3);

# Curse_Com #

insert into Curse_com value (4, "51515482D", 60);

# Productes #

insert into Productes value (1, "Salomon", "MAX 8", 50, default, default, default);
insert into Productes value (default, "Atomic", "REDSTER X5", 70, default, default, default);
insert into Productes value (default, "Wedze", "BOOST 580", 40, default, default, default);
insert into Productes value (default, "Salomon", "QUEST ACCESS 70", 20, default, default, default);
insert into Productes value (default, "Fischer", "Travers TS", 50, default, default, default);
insert into Productes value (default, "Wedze", "WID 300", 15, default, default, default);
insert into Productes value (default, "Kerma", "Elite 2", 15, default, default, default);
insert into Productes value (default, "Inovik", "POLE 900", 20, default, default, default);
insert into Productes value (default, "Wedze", "BOOST 500", 10, default, default, default);

	# Esquís #
    
    insert into esquís value (1, "Pista");
    insert into esquís value (2, "Freestyle");
    insert into esquís value (3, "Todo Terreno");
    
    # Botes #
    
    insert into esquís value (4, 40);
    insert into esquís value (5, 38);
    insert into esquís value (6, 36);
    
    # Pals #
    
    insert into esquís value (7, "120");
    insert into esquís value (8, "130");
    insert into esquís value (9, "110");
    