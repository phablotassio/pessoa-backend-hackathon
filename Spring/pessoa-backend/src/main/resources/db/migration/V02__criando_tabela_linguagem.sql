CREATE TABLE IF NOT EXISTS linguagem(
  `ID_LINGUAGEM` int(11) NOT NULL auto_increment,
  `DS_LINGUAGEM` varchar(40) COLLATE latin1_general_ci NOT NULL,
  `SG_LINGUAGEM` varchar(3) COLLATE latin1_general_ci NOT NULL,
  primary key(ID_LINGUAGEM)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
