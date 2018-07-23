create table IF NOT EXISTS pessoa (
  `ID_PESSOA` bigint(9) NOT NULL auto_increment,
  `DS_NOME` varchar(300) COLLATE latin1_general_ci NOT NULL,
  `DS_EMAIL` varchar(300) COLLATE latin1_general_ci NOT NULL,
  `DS_CPF` varchar(11) COLLATE latin1_general_ci NOT NULL,
  `DS_TELEFONE` varchar(8) COLLATE latin1_general_ci NOT NULL,
   primary key (ID_PESSOA)

)Engine=InnoDB default charset = utf8;
