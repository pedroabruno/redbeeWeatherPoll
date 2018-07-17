CREATE SCHEMA `weather` ;

CREATE TABLE `weather`.`persona` (
	`idpersona` VARCHAR(200) NOT NULL,
	PRIMARY KEY (`idpersona`)
);
  
CREATE TABLE `weather`.`ciudad` (
	`idCiudad` VARCHAR(200) NOT NULL,
	`codigo` VARCHAR(45) NULL,
	`temperatura` INT NULL,
	`condicion` VARCHAR(200) NULL,
	PRIMARY KEY (`idCiudad`)
);

CREATE TABLE `weather`.`relpersonaciudad` (
	`idPersona` VARCHAR(200) NOT NULL,
	`idCiudad` VARCHAR(200) NOT NULL,
	PRIMARY KEY (`idPersona`, `idCiudad`)
);

ALTER TABLE `weather`.`relpersonaciudad` 
ADD CONSTRAINT `fkRelPersona`
  FOREIGN KEY (`idPersona`)
  REFERENCES `weather`.`persona` (`idpersona`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
ALTER TABLE `weather`.`relpersonaciudad` 
ADD INDEX `dkRelCiudad_idx` (`idCiudad` ASC) VISIBLE;
;
ALTER TABLE `weather`.`relpersonaciudad` 
ADD CONSTRAINT `dkRelCiudad`
  FOREIGN KEY (`idCiudad`)
  REFERENCES `weather`.`ciudad` (`idCiudad`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
