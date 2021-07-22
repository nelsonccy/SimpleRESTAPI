drop table if exists transaction CASCADE ;
drop table if exists account CASCADE ;

create table account (id bigint NOT NULL AUTO_INCREMENT, balance decimal(19,2), name varchar(255), primary key (id));
create table transaction (
	id bigint NOT NULL AUTO_INCREMENT, 
	amount decimal(19,2), 
	created_time_stamp timestamp, 
	receiver_id bigint, sender_id bigint, primary key (id),
	foreign key(receiver_id) references account(id) ON DELETE CASCADE,
	foreign key(sender_id) references account(id) ON DELETE CASCADE);
