CREATE DATABASE IF NOT EXISTS cursoja DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE cursoja ;

-- -----------------------------------------------------
-- Table cursoja.curso
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS curso (
  idcurso INT NOT NULL AUTO_INCREMENT ,
  nome VARCHAR(100) NOT NULL ,
  valor DECIMAL(11,2) NOT NULL ,
  PRIMARY KEY (idcurso) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table cursoja.professor
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS professor (
  idprofessor INT NOT NULL AUTO_INCREMENT ,
  nome VARCHAR(100) NOT NULL ,
  celular VARCHAR(20) NOT NULL ,
  valorhora DECIMAL(11,2) NOT NULL ,
  PRIMARY KEY (idprofessor) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table cursoja.turma
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS turma (
  idturma INT NOT NULL AUTO_INCREMENT ,
  datainicio DATETIME NOT NULL ,
  datafim DATETIME NOT NULL ,
  curso_id INT NOT NULL ,
  professor_id INT NOT NULL ,
  PRIMARY KEY (idturma) ,
  INDEX fk_turma_curso_idx (curso_id ASC) ,
  INDEX fk_turma_professor1_idx (professor_id ASC) ,
  CONSTRAINT fk_turma_curso
    FOREIGN KEY (curso_id )
    REFERENCES cursoja.curso (idcurso )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_turma_professor1
    FOREIGN KEY (professor_id )
    REFERENCES cursoja.professor (idprofessor )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

