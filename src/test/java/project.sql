create table member(
	member_no 			number(22) 		not null,
	member_name 		varchar2(12) 	not null,
	member_id 			varchar2(12) 	primary key not null,
	member_password 	varchar2(200) 	not null,
	member_email 		varchar2(50) 	not null,
	member_mpoint 		number(12) 		default 0 not null,
	member_rpoint 		number(12) 		default 0 not null,
	member_spoint 		number(12) 		default 0 not null,
	member_flag 		varchar2(12) 	default 'Y' not null,
	member_last_login 	date 			default sysdate not null
)
alter table member add authority VARCHAR(20) default 'ROLE_USER' NOT NULL
create sequence seq_member_member_no
select * from stop
drop table board;
drop table files
drop table menu;
drop table accuser
drop table category
drop table reply;
drop table member
drop table admin
drop table authorities
delete from MEMBER
select * from member
insert into authorities (member_id,authority) values('azxcv', 'ROLE_USER')
CREATE TABLE authorities (
  member_id varchar2(12) NOT NULL,
  authority VARCHAR(20) NOT NULL,
  CONSTRAINT fk_authorities FOREIGN KEY(member_id) REFERENCES member(member_id)
);
CREATE UNIQUE INDEX ix_authorities ON authorities(member_id,authority);

create table admin(
	admin_no number(22) primary key not null,
	member_id varchar2(12) not null,
	constraint admin_member_no foreign key(member_id) references member(member_id) on delete cascade
)
create sequence seq_admin_admin_no

create table stop(
	stop_no 			number(22) 	primary key not null,
	member_id 			varchar2(12) 	not null,
	stop_start_date 	date 		not null,
	stop_end_date 		date 		not null,
	stop_reason 		varchar2(50),
	constraint stop_member_no foreign key(member_id) references member(member_id) on delete cascade
)
select * from stop

alter table stop add stop_start_date date
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
	member_id  	 	varchar2(12) 		not null,
	constraint pk_board_board_no primary key(board_no,category_no),
	constraint board_member_no foreign key(member_id) references member(member_id) on delete cascade
)
select * from board
alter table board add board_hit number(22) default 0
alter table board add board_recommand number(22) default 0
alter table board rename constraint pk_board_board_no primary key(board_no,category_no) to pk_board_board_no primary key(board_no,cateogry_no,menu_no)
alter table board drop (board_hit)
alter table accuser add menu_no number(22) not null
alter table board add constraint pk_board_board_no primary key (board_no,category_no,menu_no)
create sequence seq_board_board_no
drop sequence seq_board_board_no
alter table board add (member_no number(22))	

create table menu(
	menu_no 	number(22)	 primary key not null,
	menu_name 	varchar2(50) not null
)
drop sequence seq_menu_menu_no
create sequence seq_menu_menu_no

create table category(
	category_no 	number(22) 		not null,
	category_name 	varchar2(50) 	not null,
	menu_no 		number(22) 		not null,
	constraint pk_category_category_no primary key(category_no,menu_no),
	constraint	category_menu_no foreign key(menu_no) references menu(menu_no) on delete cascade
)
drop table cateogry
alter table board add constraint fk_board_member_no foreign key (member_no) 
			references member(member_no) on delete cascade
drop sequence seq_category_category_no
create sequence seq_category_category_no

create table files(
	files_no 		number(22)     primary key not null,
	menu_no 		number(22)		not null,
	files_realname 	varchar2(200) 	not null,
	files_fakename 	varchar2(200) 	not null,
	board_no 		number(22) 		not null,
	category_no	number(22)		 not null
)

select * from accused
delete from accused where accused_no = 61
alter table files add constraint fk_files_board foreign key (board_no,category_no,menu_no) 
			references board(board_no,category_no,menu_no) on delete cascade
alter table files add stop_no number(22)
create sequence seq_files_files_no

create table reply(
	reply_no 		number(22) 		primary key not null,
	reply_content 	varchar2(150) 	not null,
	board_no 		number(22) 		not null,
	category_no 	number(22) 		not null,
	member_id		varchar2(12)		not null,
	reply_regdate   date			default sysdate not null,
	menu_no 		number(22)		
)
select * from reply
drop table reply
alter table reply add reply_flag  varchar2(10) default 'Y' not null
alter table reply drop constraint fk_reply_board
alter table reply add constraint fk_reply_board foreign key (board_no,category_no,menu_no)
			references board(board_no,category_no,menu_no) on delete cascade
create sequence seq_reply_reply_no
drop sequence seq_reply_reply_no

create table accused(
	accused_no			number(22) primary key not null,
	member_id			varchar2(12) not null,
	stop_start_date 	date 		not null,
	stop_end_date 		date 		not null
)
alter table accused add accused_flag varchar2(12) default 'Y' not null
create sequence seq_accused_accused_no
alter table accused add	constraint	accused_member_id foreign key(member_id) references member(member_id) on delete cascade
drop table accuser
alter table accuser add constraint fk_accuser_board foreign key (board_no,category_no,menu_no)
			references board(board_no,category_no,menu_no) on delete cascade
create sequence seq_accuser_accuser_no

create table recommand(
	board_no		number(22),
	category_no		number(22),
	member_id		varchar2(12),
	constraint pk_recommand_recommand primary key (board_no,category_no,member_id),
	constraint	fk_recmmand_recommand foreign key(member_id) references member(member_id) on delete cascade
)

delete from MEMBER;
select * from MEMBER
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
update board set member_no=1
insert into menu(menu_no,menu_name) values(seq_menu_menu_no.nextval,'공지사항')
insert into menu(menu_no,menu_name) values(seq_menu_menu_no.nextval,'Programming')
insert into menu(menu_no,menu_name) values(seq_menu_menu_no.nextval,'Q & A')
select * from menu;
insert into CATEGORY(category_no,category_name,menu_no) values(seq_category_category_no.nextval,'자유게시판',3)
select * from category;
insert into board(menu_no,category_no,board_no,board_title,board_content,member_id) values(1,2,seq_board_board_no.nextval,'test1','게시판게시판','1234');
alter table reply drop column menu_no
insert into REPLY(reply_no, reply_content, board_no, category_no,menu_no,member_id,reply_regdate) values(seq_reply_reply_no.nextval,'뭐',26,2,1,'1234',sysdate);
select * from board
select * from member
select * from REPLY order by reply_no

	select
		b.board_no,
		b.menu_no,
		b.category_no,
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
	and
		b.menu_no = 1
	and
		b.category_no= 2

		select 
		menu_no,
		menu_name
	from
		menu
		
	
	select 
		count(*) 
	from 
		board 
	where CATEGORY_NO = 2
select
 h.* from(
	select 
		ROWNUM r, t.* 
	from 
	(
		select 
			ROWNUM rn, e.* 
		from 
		(
			select
				b.board_no,
				b.menu_no,
				b.category_no,
				b.board_title,
				b.board_content,
				b.board_complete,
				b.board_regdate,
				b.board_flag,
				m.member_id,
				m.member_name
			from
				board b,
				member m
			where
				b.member_id = m.member_id
			and
				b.category_no = 2
		) e order by rn desc
	)t ) h
 where r between 2 and 21
 
 select
			b.board_no,
			b.menu_no,
			b.category_no,
			b.board_title,
			b.board_content,
			b.board_complete,
			to_char(b.board_regdate),
			b.board_flag,
			b.member_no,
			m.member_id,
			m.member_name,
			c.category_name
	from
			board b,
			member m,
			category c
	where
			b.member_no = m.member_no
	and
			b.category_no = c.category_no
	and
			b.category_no = 2
	and
			b.board_no = 26
			
			select member_id as username,member_password as password from member where member_id = '1234'
			
				select
		  member_id,
		  member_password,
		  authority
	from
		member
	where member_id = '1234'
	select * from board
	select * from recommand
	delete from recommand
	select * from board
	update board set
		board_recommand 	=	0
	where
		board_no 	= 	85
	and
		category_no	= 	1
		
		select 
		count(*) 
	from 
		board 
	where
		board_flag = 'N'
		
	update reply set
		reply_flag = 'Y'
		
		select * from files
		select * from reply
		select * from member
			update
		member
	set
		authority = 'ROLE_USER'
	where
		member_id = '1234'
		alter table member rename column member_last_login to member_hire_date
		alter table member add member_last_login date
update member set
	member_last_login = sysdate
	
	update member set
		authority = 'ROLE_ADMIN'
	where member_id = 'nohaff'
	select * from files
	
		select 
		files_no,
		menu_no,
		category_no,
		board_no,
		files_realname,
		files_fakename
	from
		files
	where
		category_no = 2
	and
		board_no = 130
	and 
		stop_no = NULL
		
			select
		h.*
	from
	(
		select 
			ROWNUM r, t.* 
		from 
		(
			select 
				ROWNUM rn, e.* 
			from 
			(
				select
					s.member_id as sMemberId,
					b.member_id as wMemberId,
					s.stop_title as stopTitle,
					s.stop_reason as stopReason,
					s.stop_no as stopNo,
					b.board_no as boardNo,
					b.category_no as categoryNo,
					b.board_title as boardTitle,
					b.menu_no as menuNo
				from
					board b,
					stop s
				where
					b.board_no = s.board_no 
			) e order by rn desc
		)t
	)h 
	where r between 1 and 10
	
	select
		count(*)
	from
		accused
	where
		member_id = 'nohaff'
		select * from accused
		select * from member order by member_no
		update ACCUSED
		set accused_flag = 'Y'
		update member
		set authority = 'ROLE_STOP'
		where member_id = 'aa'
		select * from files
		where stop_no is not null
		select * from board order by board_recommand desc, board_no desc
		
		select
		h.*
	from
	(
		select 
			ROWNUM r, t.* 
		from 
		(
			select 
				ROWNUM rn, e.* 
			from 
			(
				select
					s.member_id as sMemberId,
					b.member_id as wMemberId,
					s.stop_title as stopTitle,
					s.stop_reason as stopReason,
					s.stop_no as stopNo,
					b.board_no as boardNo,
					b.category_no as categoryNo,
					b.board_title as boardTitle,
					b.menu_no as menuNo
				from
					board b,
					stop s
				where
					b.board_no = s.board_no 
				order by stop_no
			) e order by rn desc
		)t
	)h 
	where r between 1 and 10
	
	select
		h.*
	from
	(
		select 
			ROWNUM r, t.* 
		from 
		(
			select 
				ROWNUM rn, e.* 
			from 
			(
				select
					b.board_no as boardNo,
					b.menu_no  as menuNo,
					b.category_no as categoryNo,
					b.board_title as boardTitle,
					b.board_content as boardContent,
					b.board_complete as boardComplete,
					b.board_hit as boardHit,
					b.board_regdate as boardRegdate,
					b.board_flag as boardFlag,
					b.member_id as memberId,
					b.board_recommand as boardRecommandPoint,
					c.category_name as categoryName
				from
					board b,
					category c
				where
					b.category_no = c.category_no
				and
					b.board_flag  = 'Y'
					order by b.board_recommand desc, b.board_no desc
			) e 
		)t
	where rn between 1 and 5
	)h 
	select * from files where stop_no is null
	select b.*,c.category_name from board b , category c where b.category_no=c.category_no order by b.board_regdate desc
	select 
		files_no,
		menu_no,
		category_no,
		board_no,
		files_realname,
		files_fakename
	from
		files
	where
		category_no = 2
	and
		board_no = 141
	and 
		stop_no is null
		
		select * from member
commit