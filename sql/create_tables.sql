--\i C:\workspace\poker\db\create_tables.sql

drop sequence poker.hand_seq;
create sequence poker.hand_seq START 1;

drop table poker.bj_table;
drop table poker.bj_result;
drop table poker.bj_hand;
drop table poker.bj_showdown;

create table poker.bj_showdown(
	show_id INTEGER PRIMARY KEY,
	decision VARCHAR(10),
	house VARCHAR(2),
	hand_processed BOOLEAN
);

create table poker.bj_hand(
	show_id INTEGER REFERENCES poker.bj_showdown,
	hand_id INTEGER,
	hand VARCHAR(20),
	hand_soft VARCHAR(5),
	hand_hard VARCHAR(5),
	decision VARCHAR(10),
	house VARCHAR(2),
	profit DOUBLE PRECISION,
	PRIMARY KEY(show_id,hand_id)
);

create table poker.bj_result(
	result_id SERIAL,
	show_id INTEGER,
	hand_id INTEGER,
	hand_type VARCHAR(5),
	decision VARCHAR(1),
	house VARCHAR(2),
	profit DOUBLE PRECISION,
	FOREIGN KEY(show_id,hand_id) REFERENCES poker.bj_hand
);

create table poker.bj_table(
	hand_type VARCHAR(5),
	house VARCHAR(2),
	decision VARCHAR(1)
);