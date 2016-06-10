create table member(
	member_no 			number(22) 		primary key not null,
	member_name 		varchar2(12) 	not null,
	member_id 			varchar2(12) 	not null,
	member_password 	varchar2(100) 	not null,
	member_email 		varchar2(50) 	not null,
	member_mpoint 		number(12) 		default 0 not null,
	member_rpoint 		number(12) 		default 0 not null,
	member_spoint 		number(12) 		default 0 not null,
	member_flag 		varchar2(12) 	default 'Y' not null,
	member_last_login 	date 			default sysdate not null
)
create sequence seq_member_member_no

create table admin(
	admin_no number(22) primary key not null,
	member_no number(22) not null,
	constraint admin_member_no foreign key(member_no) references member(member_no) on delete cascade
)
create sequence seq_admin_admin_no

create table stop(
	stop_no 			number(22) 	primary key not null,
	member_no 			number(22) 	not null,
	stop_start_date 	date 		not null,
	stop_end_date 		date 		not null,
	stop_reason 		varchar2(50),
	constraint stop_member_no foreign key(member_no) references member(member_no) on delete cascade
)
create sequence seq_stop_stop_no

create table board(
	board_no 		number(22) 		not null,
	category_no		number(22) 		not null,
	menu_no 		number(22)		 not null,
	board_name		varchar2(22) 	not null,
	board_title 	varchar2(50) 	not null,
	board_content 	varchar2(1500) 	not null,
	board_complete 	varchar2(10) 	default 'N' not null,
	board_regdate 	date 			default sysdate not null,
	board_flag 		varchar2(10) 	default 'Y' not null,
	member_no  	 	number(22) 		not null,
	constraint pk_board_board_no primary key(board_no,category_no,menu_no),
	constraint board_member_no foreign key(member_no) references member(member_no) on delete cascade
)
alter table accuser add menu_no number(22) not null
alter table board add constraint pk_board_board_no primary key (board_no,category_no,menu_no)
create sequence seq_board_board_no

create table menu(
	menu_no 	number(22)	 primary key not null,
	menu_name 	varchar2(50) not null
)
create sequence seq_menu_menu_no

create table category(
	category_no 	number(22) 		not null,
	category_name 	varchar2(50) 	not null,
	menu_no 		number(22) 		not null,
	constraint pk_category_category_no primary key(category_no,menu_no),
	constraint	category_menu_no foreign key(menu_no) references menu(menu_no) on delete cascade
)
create sequence seq_category_category_no

create table files(
	files_no 		number(22)     primary key not null,
	menu_no 		number(22)		not null,
	files_realname 	varchar2(200) 	not null,
	files_fakename 	varchar2(200) 	not null,
	board_no 		number(22) 		not null,
	category_no	number(22)		 not null
)
alter table files add constraint fk_files_board foreign key (board_no,category_no,menu_no) 
			references board(board_no,category_no,menu_no) on delete cascade
create sequence seq_files_files_no

create table reply(
	reply_no 		number(22) 		primary key not null,
	reply_content 	varchar2(150) 	not null,
	board_no 		number(22) 		not null,
	category_no 	number(22) 		not null,
	menu_no 		number(22)		not null
)
alter table reply drop constraint fk_reply_board
alter table reply add constraint fk_reply_board foreign key (board_no,category_no,menu_no)
			references board(board_no,category_no,menu_no) on delete cascade
create sequence seq_reply_reply_no

create table accuser(
	accuser_no			number(22) primary key not null,
	accuser_content		varchar2(1500) not null,
	board_no			number(22),
	category_no			number(22),
	menu_no 		    number(22),
	stop_no				number(22),
	member_no			number(22),
	user_no				number(22),
	constraint accuser_stop_no foreign key(stop_no) references stop(stop_no) on delete cascade
)
alter table accuser add constraint fk_accuser_board foreign key (board_no,category_no,menu_no)
			references board(board_no,category_no,menu_no) on delete cascade
create sequence seq_accuser_accuser_no

select a.admin_no, m.member_no, m.member_name from admin a, member m where a.member_no = m.member_no
order by a.admin_no
select * from board
	select
		b.board_no,
		b.category_no,
		b.board_name,
		b.board_title,
		b.board_content,
		b.board_complete,
		b.board_regdate,
		b.board_flag,
		b.member_no,
		m.member_id
	from
		board b,
		member m
	where
		b.member_no = m.member_no