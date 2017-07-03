CREATE TABLE `Book` (
  `id` bigint auto_increment not null,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE Author (
	id bigint auto_increment not null,
	name varchar(255) default null,
	firstname varchar(255) default null,
	primary key(id)
);

CREATE TABLE Book_Author (
	id_book bigint not null,
	id_author bigint not null,
	foreign key(id_book) references Book(id),
	foreign key(id_author) references Author(id)
);