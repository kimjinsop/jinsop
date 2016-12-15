create table member (
  mem_id varchar2(50) not null primary key,
  mem_passwd varchar2(10) not null,
  mem_name varchar2 (30) not null,
  mem_cell varchar2(15) not null,
  mem_status char default 'Y',
  mem_register date default sysdate
);

create table noticeboard (
  nb_num number not null primary key,
  mem_id varchar2(50) not null,
  nb_title varchar2(50) not null,
  nb_content clob not null,
  nb_register date default sysdate,
  constraint nb_fk1 foreign key (mem_id) references member (mem_id)
);
create sequence nb_seq;

create table community (
  cm_num number not null primary key,
  mem_id varchar2(50) not null,
  cm_title varchar2(50) not null,
  cm_content clob not null,
  cm_image varchar2(200),
  cm_register date default sysdate,
  cm_readcount number default 0,
  constraint cm_fk1 foreign key (mem_id) references member (mem_id)
);
create sequence cm_seq;

create table reply (
  re_num number not null primary key,
  mem_id varchar2(50) not null,
  cm_num number not null,
  re_content clob not null,
  re_register date default sysdate,
  constraint re_fk1 foreign key (mem_id) references member (mem_id),
  constraint re_fk2 foreign key (cm_num) references community (cm_num)
);
create sequence re_seq;

create table model(
  mo_model varchar2(50) not null,
  mo_brand varchar2(30) not null,
  mo_image varchar2(200) not null,
  mo_code varchar2(20) not null
);

create table items (
  it_num number not null primary key,
  mem_id varchar2(50) not null,
  it_brand varchar2(30) not null,
  it_model varchar2(50) not null,
  it_image varchar2(200) not null,
  it_code varchar2(20) not null,
  it_size number(3) not null,
  it_price number not null,
  it_status char default 'N',
  it_register date default sysdate,
  constraint it_fk1 foreign key (mem_id) references member (mem_id)
);
create sequence it_seq;

create table buy (
  buy_num number not null primary key,
  mem_id varchar2(50) not null,
  it_num number not null,
  buy_zip varchar2(6) not null,
  buy_addr1 varchar2(50) not null,
  buy_addr2 varchar2(100),
  buy_register date default sysdate,
  constraint buy_fk1 foreign key (mem_id) references member (mem_id),
  constraint buy_fk2 foreign key (it_num) references items (it_num)
);
create sequence buy_seq;

create table faq (
  faq_num number not null primary key,
  mem_id varchar2(50) not null,
  faq_title varchar2(50) not null,
  faq_content clob not null,
  faq_register date default sysdate,
  constraint faq_fk1 foreign key (mem_id) references member (mem_id)
);
create sequence faq_seq;

create table point (
  mem_id varchar2(50) not null,
  point number,
  constraint point_fk1 foreign key (mem_id) references member (mem_id)
);