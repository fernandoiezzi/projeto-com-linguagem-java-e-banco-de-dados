use cursoja;


CREATE  TABLE IF NOT EXISTS usuario (
  idusuario INT NOT NULL AUTO_INCREMENT ,
  nome VARCHAR(100) NOT NULL ,
  login VARCHAR(100) NOT NULL ,
  senha VARCHAR(100) NOT NULL, 
  PRIMARY KEY (idusuario) )
ENGINE = InnoDB;

insert into usuario(nome, login, senha) values ('Antônio Pedro', 'antonio.pedro', '123456');
insert into usuario(nome, login, senha) values ('Adminstrador', 'admin', 'admin123');
