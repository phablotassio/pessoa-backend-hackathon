create database cadastro default character set utf8 default collate utf8_general_ci;
use cadastro;

create table IF NOT EXISTS pessoa (
  `ID_PESSOA` bigint(9) NOT NULL auto_increment,
  `DS_NOME` varchar(300) COLLATE latin1_general_ci NOT NULL,
  `DS_EMAIL` varchar(300) COLLATE latin1_general_ci NOT NULL,
  `DS_CPF` varchar(11) COLLATE latin1_general_ci NOT NULL,
  `DS_TELEFONE` varchar(8) COLLATE latin1_general_ci NOT NULL,
   primary key (ID_PESSOA)

)Engine=InnoDB default charset = utf8;



CREATE TABLE IF NOT EXISTS linguagem  (
  `ID_LINGUAGEM` int(11) NOT NULL auto_increment,
  `DS_LINGUAGEM` varchar(40) COLLATE latin1_general_ci NOT NULL,
  `SG_LINGUAGEM` varchar(3) COLLATE latin1_general_ci NOT NULL,
  primary key(ID_LINGUAGEM)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS  cargo(
  `ID_CARGO` int(11) NOT NULL auto_increment,
  `DS_CARGO` varchar(40) COLLATE latin1_general_ci NOT NULL,
  primary key (ID_CARGO)
)engine = innodb default charset=utf8;


CREATE TABLE IF NOT EXISTS profissao (
  `ID_PROFISSAO` int(11) NOT NULL auto_increment,
  `ID_PESSOA` bigint(9) NOT NULL,
  `ID_CARGO` int(11) NOT NULL,
  `ID_LINGUAGEM` int(11) NOT NULL,
  foreign key(`ID_PESSOA`) references pessoa(`ID_PESSOA`),
  foreign key(`ID_CARGO`) references cargo(`ID_CARGO`),
  foreign key(`ID_LINGUAGEM`) references linguagem(`ID_LINGUAGEM`),
  primary key(ID_PROFISSAO)
 
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
