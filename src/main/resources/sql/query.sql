create table article
(row_num serial,
 id_art varchar(255),
 nam varchar(255),
 code varchar(255),
 username varchar(255),
 guid varchar(255));

select  * from article;

truncate table article;

alter sequence article_row_num_seq restart with 1;