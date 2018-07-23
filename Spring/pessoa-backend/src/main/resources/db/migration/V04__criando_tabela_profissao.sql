CREATE TABLE IF NOT EXISTS profissao (
  `ID_PROFISSAO` int(11) NOT NULL auto_increment,
  `ID_PESSOA` bigint(9) NOT NULL,
  `ID_CARGO` int(11) NOT NULL,
  `ID_LINGUAGEM` int(11) NOT NULL,
  foreign key(`ID_PESSOA`) references pessoa(`ID_PESSOA`)ON DELETE     CASCADE,
  foreign key(`ID_CARGO`) references cargo(`ID_CARGO`) ON DELETE     CASCADE,
  foreign key(`ID_LINGUAGEM`) references linguagem(`ID_LINGUAGEM`) ON DELETE     CASCADE,
  primary key(ID_PROFISSAO)
 
  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
