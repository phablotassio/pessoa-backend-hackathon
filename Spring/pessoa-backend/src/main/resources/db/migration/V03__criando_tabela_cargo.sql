CREATE TABLE IF NOT EXISTS cargo (
  `ID_CARGO` int(11) NOT NULL auto_increment,
  `DS_CARGO` varchar(40) COLLATE latin1_general_ci NOT NULL,
  primary key (ID_CARGO)
)engine = innodb default charset=utf8;
