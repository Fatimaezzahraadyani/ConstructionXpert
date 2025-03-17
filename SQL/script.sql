Create database ConstructionXpert;
use ConstructionXpert;
create table projets(
	id int auto_increment primary key,
	nom varchar(255) not null,
	description text,
	dateDebut date,
	dateFin date,
	budget Double
);
create table taches(
	id int auto_increment primary key ,
	description text,
	dateDebut date,
	dateFin date,
	projet_id int,
	foreign key (projet_id) references projets(id) on delete cascade
);
create table ressources(
	id int auto_increment primary key,
	nom varchar(255) not null,
	type varchar(100),
	quantite int ,
	tache_id int,
	foreign key (tache_id) references taches(id) on delete cascade
);
show tables;
select * from projets;
select * from taches;
select * from ressources;