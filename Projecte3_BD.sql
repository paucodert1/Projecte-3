drop database if exists nwn;
create database nwn;

use nwn;

CREATE TABLE `monitors` (
	`dni` varchar(9) NOT NULL,
	`nom` varchar(20) NOT NULL,
	`cognom_1` varchar(20) NOT NULL,
	`cognom_2` varchar(20) NOT NULL,
	`tel` INT(9) NOT NULL,
	`data_naixement` DATE NOT NULL,
	`correu_e` varchar(255) NOT NULL,
	PRIMARY KEY (`dni`)
);

CREATE TABLE `cursos` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nom` varchar(20) NOT NULL,
	`descripcio` varchar(255) NOT NULL,
	`dni` varchar(9) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `individual` (
	`id` INT NOT NULL,
	`preu/h` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `colectiu` (
	`id` INT NOT NULL,
	`preu` INT NOT NULL,
	`max_participants` INT NOT NULL,
	`data` DATE NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `competicio` (
	`id` INT NOT NULL,
	`preu` INT NOT NULL,
	`nivell` INT NOT NULL,
	`data_inici` DATE NOT NULL,
	`data_fi` DATE NOT NULL,
	`durada` int NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `clients` (
	`dni` varchar(9) NOT NULL,
	`nom` varchar(20) NOT NULL,
	`cognom_1` varchar(20) NOT NULL,
	`cognom_2` varchar(20) NOT NULL,
	`tel` INT(9) NOT NULL,
	`data_naixement` DATE NOT NULL,
	`correu_e` varchar(50) NOT NULL,
	`sexe` varchar(1) NOT NULL,
	`compte_Bancari` varchar(50) NOT NULL,
	`usuari` varchar(20) NOT NULL,
	`contrasenya` varchar(32) NOT NULL,
	PRIMARY KEY (`dni`)
);

CREATE TABLE `federats` (
	`dni` varchar(9) NOT NULL,
	`num_fed` INT(20) NOT NULL,
	`data_caduc_f` DATE NOT NULL,
	`nivell` INT NOT NULL,
	PRIMARY KEY (`dni`)
);

CREATE TABLE `curse_i` (
	`id` INT NOT NULL,
	`dni` varchar(9) NOT NULL,
	`hores` TIME NOT NULL,
	`data` DATE NOT NULL,
	`descomte/h` INT NOT NULL,
	`preu_final` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `curse_col` (
	`id` INT NOT NULL,
	`dni` varchar(9) NOT NULL,
	`descomte_fn` INT NOT NULL,
	`preu_final` INT NOT NULL,
	`cant_persones` INT NOT NULL,
	PRIMARY KEY (`id`,`dni`)
);

CREATE TABLE `curse_com` (
	`id` INT NOT NULL,
	`dni` varchar(9) NOT NULL,
	PRIMARY KEY (`id`,`dni`)
);

CREATE TABLE `familia_nombrosa` (
	`dni` varchar(9) NOT NULL,
	`carnet_fn` varchar(40) NOT NULL,
	`data_caduc_fn` DATE NOT NULL,
	PRIMARY KEY (`dni`)
);

CREATE TABLE `productes` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`marca` varchar(20) NOT NULL,
	`model` varchar(20) NOT NULL,
	`preu` INT NOT NULL,
	`descompte` INT NOT NULL default '0',
	`usos` INT NOT NULL DEFAULT '0',
	`estat` BOOLEAN NOT NULL DEFAULT true,
    `foto`  varchar(50) NOT null,
	PRIMARY KEY (`id`)
);

CREATE TABLE `botes` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`talla` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `pals` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`alçada` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `esquís` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`tipus` varchar(50) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `kits` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`usos` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `format` (
    `id_p1` INT NOT NULL,
    `id_p2` INT NOT NULL,
    `id_p3` INT NOT NULL,
    `id_k` INT NOT NULL,
	`preu_final` INT NOT NULL,
    PRIMARY KEY (`id_p1` , `id_p2` , `id_p3` , `id_k`)
);

CREATE TABLE `lloga_k` (
	`id` int NOT NULL,
	`dni` varchar(9) NOT NULL,
	`data` DATETIME NOT NULL,
	`data_tornada` DATETIME NOT NULL,
	PRIMARY KEY (`id`,`dni`)
);

CREATE TABLE `lloga_p` (
	`id` INT NOT NULL,
	`dni` varchar(9) NOT NULL,
	`data` DATETIME NOT NULL,
	`preu_final` INT NOT NULL,
	`data_tornada` DATETIME,
	PRIMARY KEY (`id`,`dni`)
);


ALTER TABLE `cursos` ADD CONSTRAINT `cursos_fk0` FOREIGN KEY (`dni`) REFERENCES `monitors`(`dni`);

ALTER TABLE `individual` ADD CONSTRAINT `individual_fk0` FOREIGN KEY (`id`) REFERENCES `cursos`(`id`);

ALTER TABLE `colectiu` ADD CONSTRAINT `colectiu_fk0` FOREIGN KEY (`id`) REFERENCES `cursos`(`id`);

ALTER TABLE `competicio` ADD CONSTRAINT `competició_fk0` FOREIGN KEY (`id`) REFERENCES `cursos`(`id`);

ALTER TABLE `federats` ADD CONSTRAINT `federats_fk0` FOREIGN KEY (`dni`) REFERENCES `clients`(`dni`);

ALTER TABLE `curse_i` ADD CONSTRAINT `curse_i_fk0` FOREIGN KEY (`id`) REFERENCES `cursos`(`id`);

ALTER TABLE `curse_i` ADD CONSTRAINT `curse_i_fk1` FOREIGN KEY (`dni`) REFERENCES `clients`(`dni`);

ALTER TABLE `curse_col` ADD CONSTRAINT `curse_col_fk0` FOREIGN KEY (`id`) REFERENCES `cursos`(`id`);

ALTER TABLE `curse_col` ADD CONSTRAINT `curse_col_fk1` FOREIGN KEY (`dni`) REFERENCES `clients`(`dni`);

ALTER TABLE `curse_com` ADD CONSTRAINT `curse_com_fk0` FOREIGN KEY (`id`) REFERENCES `cursos`(`id`);

ALTER TABLE `curse_com` ADD CONSTRAINT `curse_com_fk1` FOREIGN KEY (`dni`) REFERENCES `federats`(`dni`);

ALTER TABLE `familia_nombrosa` ADD CONSTRAINT `familia_nombrosa_fk0` FOREIGN KEY (`dni`) REFERENCES `clients`(`dni`);

ALTER TABLE `botes` ADD CONSTRAINT `botes_fk0` FOREIGN KEY (`id`) REFERENCES `productes`(`id`);

ALTER TABLE `pals` ADD CONSTRAINT `pals_fk0` FOREIGN KEY (`id`) REFERENCES `productes`(`id`);

ALTER TABLE `esquís` ADD CONSTRAINT `esquís_fk0` FOREIGN KEY (`id`) REFERENCES `productes`(`id`);

ALTER TABLE `format` ADD CONSTRAINT `format_fk1` FOREIGN KEY (`id_p1`) REFERENCES `productes`(`id`);

ALTER TABLE `format` ADD CONSTRAINT `format_fk2` FOREIGN KEY (`id_p2`) REFERENCES `productes`(`id`);

ALTER TABLE `format` ADD CONSTRAINT `format_fk3` FOREIGN KEY (`id_p3`) REFERENCES `productes`(`id`);

ALTER TABLE `format` ADD CONSTRAINT `format_fk0` FOREIGN KEY (`id_k`) REFERENCES `kits`(`id`);

ALTER TABLE `lloga_k` ADD CONSTRAINT `lloga_k_fk0` FOREIGN KEY (`id`) REFERENCES `kits`(`id`);

ALTER TABLE `lloga_k` ADD CONSTRAINT `lloga_k_fk1` FOREIGN KEY (`dni`) REFERENCES `clients`(`dni`);

ALTER TABLE `lloga_p` ADD CONSTRAINT `lloga_p_fk0` FOREIGN KEY (`id`) REFERENCES `productes`(`id`);

ALTER TABLE `lloga_p` ADD CONSTRAINT `lloga_p_fk1` FOREIGN KEY (`dni`) REFERENCES `clients`(`dni`);



#################
##   INSERTS   ##
#################

# Monitors #
insert into monitors value ("78103615P", "Sergi", "Pont", "Balague", 600382677, "2003/08/25", "sergipb@gmail.com");
insert into monitors value ("12345678J", "Marta", "Moreno", "Rubio", 643125476, "2000/04/06", "martamr@gmail.com");
insert into monitors value ("56864844G", "Jordi", "Estnañ", "Font", 684212354, "1990/10/18", "jordief@gmail.com");


# Cursos #
insert into cursos value (1, "Inicial", "Curs per a nous usuaris sense cap experiencia", "78103615P");
insert into cursos value (default, "Desens Basic", "Curs per apendre a baixa corectament", "56864844G");
insert into cursos value (default, "Mitg", "Curs per usuaris amb experiencia basica", "78103615P");
insert into cursos value (default, "Max velocitat", "Curs per aconseguir la maxima velocitat en vaixada", "12345678J");
insert into cursos value (default, "Acrobacies Basiques", "Curs per comensa amb acrobasies", "56864844G");

	# Individual #
	insert into individual value (1, 50);
	insert into individual value (3, 55);

	# Colectiu #
	insert into colectiu value (2, 30, 10, "2022/01/03");
	
	# Competicio #
    insert into competicio value (4, 60, 3, "2022/01/03", "2022/01/07", "2");
    insert into competicio value (5, 70, 1, "2022/01/03", "2022/01/07", "4");


# Clients #

insert into clients value ("15423675U", "Pau", "Rubio", "Silva", 62378912, "2003/03/21", "paurubiosilva@gmail.com", "M", "ES25 0019 0832 4975 2231 4577", "Prubio", md5("1234"));
insert into clients value ("94941664R", "Sergi", "Folorencia", "Rotj", 624879216, "2003/02/03", "sergifr@gmail.com", "M", "ES28 6814 4959 7380 2145 2793", "UwU", md5("1234"));
insert into clients value ("51515482D", "Paula", "Sanchez", "Canosa", 679123574, "2001/11/19", "paulasc@gmail.com", "F", "ES26 0149 3779 6978 6983 9149", "Paulita", md5("1234"));
insert into clients value ("81664477H", "Paco", "Gimenez", "Gerra", 634897123, "1970/05/07", "pacogg@gmail.com", "M", "ES81 0077 9275 2263 3174 6967", "PacoGG", md5("1234"));

	# Federat #
    
    insert into federats value ("51515482D", "564694", "2022/04/22", 3);
    
    # Familia Nombrosa #
    
	insert into familia_nombrosa value ("81664477H", "69464616476", "2024/04/22");
    
    
# Curse_I #

insert into curse_i value (1, "94941664R", "04:00:00", "2022/01/14", 30, 140);
insert into curse_i value (3, "15423675U", "07:00:00", "2022/01/14", 50, 175);

# Curse_Col #

insert into curse_col value (2, "81664477H", 40, 108, 6);
insert into curse_col value (2, "15423675U", 0, 90, 3);

# Curse_Com #

insert into curse_com value (4, "51515482D");

# Productes #

insert into productes value (1, "Salomon", "MAX 8", 50, default, 1, default, "esqui-salo.jpeg");
insert into productes value (default, "Atomic", "REDSTER X5", 70, default, default, default, "esqui-atomic.jpeg");
insert into productes value (default, "Wedze", "BOOST 580", 40, default, 1, default, "esqui-wedze.jpg");
insert into productes value (default, "Salomon", "QUEST ACCESS 70", 20, default, 1, default, "botes-salo.jpg");
insert into productes value (default, "Fischer", "Travers TS", 50, default, 1, default, "botes-travers.jpg");
insert into productes value (default, "Wedze", "WID 300", 15, default, default, default, "botes-wedze.jpg");
insert into productes value (default, "Kerma", "Elite 2", 15, default, 1, default, "pal-elite.jpeg");
insert into productes value (default, "Inovik", "POLE 900", 20, default, default, default, "palo-pole.jpeg");
insert into productes value (default, "Wedze", "BOOST 500", 10, default, 1, default, "palo-wedze.jpg");

	# Esquís #
    
    insert into esquís value (1, "Pista");
    insert into esquís value (2, "Freestyle");
    insert into esquís value (3, "Todo Terreno");
    
    # Botes #
    
    insert into botes value (4, 40);
    insert into botes value (5, 38);
    insert into botes value (6, 36);
    
    # Pals #
    
    insert into pals value (7, "120");
    insert into pals value (8, "130");
    insert into pals value (9, "110");
    
# Kits #

insert into kits values (1, 1);

# Format #

insert into format values (1, 5, 7, 1, 115);

# Lloga_K #
    
insert into lloga_k values (1, "15423675U", "2022/01/14 11:00:00", "2022/01/14 19:00:00");

# Lloga_P #

insert into lloga_p values (3,"94941664R", "2022/01/14 15:00:00", 40, "2022/01/14 19:00:00");
insert into lloga_p values (9,"94941664R", "2022/01/14 15:00:00", 10, "2022/01/14 19:00:00");
insert into lloga_p values (4,"81664477H", "2022/01/05 15:00:00", 20, "2022/01/05 19:00:00");      
    



######################
##   PROCEDIMENTS   ##
######################

DELIMITER //

create procedure lloga_p (in _id int, in _dni varchar(9))
	begin
		declare _preu int;
        declare _desc int;
        declare _usos int;
		declare _preuFinal int;
        
		select preu into _preu
		from productes
		where id = _id;
	
		select descompte into _desc
		from productes
		where id = _id;
        
        set _preuFinal = _preu - ((_preu * _desc) / 100);
        
        insert into lloga_p (id, dni, data, preu_final) value (_id, _dni, localtime(), _preuFinal);
        
        update productes set usos = (usos+1) where id = _id;
        
		select usos into _usos
		from productes
		where id = _id;
        
        if _usos >= 10 then
        
			update productes set estat = false where id = _id;
		
		end if;
        
    end

//


DELIMITER //

create procedure lloga_k (in _id1 int, in _id2 int, in _id2 int, in _dni varchar(9))
	begin
		declare _preu1 int;
		declare _preu2 int;
		declare _preu3 int;
        declare _desc1 int;
        declare _desc2 int;
        declare _desc3 int;
        declare _usos1 int;
        declare _usos2 int;
        declare _usos3 int;
		declare _preuFinalP1 int;
		declare _preuFinalP2 int;
		declare _preuFinalP3 int;
		declare _preuFinal int;
        
		select preu into _preu1
		from productes
		where id = _id1;
        
		select preu into _preu2
		from productes
		where id = _id2;
        
		select preu into _preu3
		from productes
		where id = _id3;
	
		select descompte into _desc1
		from productes
		where id = _id1;
	
		select descompte into _desc2
		from productes
		where id = _id2;
	
		select descompte into _desc3
		from productes
		where id = _id3;
        
        set _preuFinalP1 = _preu1 - ((_preu1 * _desc1) / 100);
        set _preuFinalP2 = _preu2 - ((_preu2 * _desc2) / 100);
        set _preuFinalP3 = _preu3 - ((_preu3 * _desc3) / 100);
        
        SET _preuFinal = _preuFinalP1 + _preuFinalP2 + _preuFinalP3;
        
        insert into lloga_k (id, dni, data, preu_final) value (_id, _dni, localtime(), _preuFinal);
        
        update productes set usos = (usos+1) where id = _id;
        
		select usos into _usos
		from productes
		where id = _id;
        
        if _usos >= 10 then
        
			update productes set estat = false where id = _id;
		
		end if;
        
    end

//

DELIMITER //

create procedure desc_prod_marc (in _desc int, in _marca varchar(20))
	begin
 
		update productes 
        set descompte = _desc
        where marca = _marca;
    
    end

//


##################
##   Funcions   ##
##################



#################
##   Trigers   ##
#################

    
    
    
    
    
    
    
    
    
    
    
    