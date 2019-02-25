-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema pruebaMood
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `pruebaMood` ;

-- -----------------------------------------------------
-- Schema pruebaMood
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pruebaMood` DEFAULT CHARACTER SET utf8 ;
USE `pruebaMood` ;

-- -----------------------------------------------------
-- Table `pruebaMood`.`compra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pruebaMood`.`compra` ;

CREATE TABLE IF NOT EXISTS `pruebaMood`.`compra` (
  `idcompras` INT NOT NULL AUTO_INCREMENT,
  `folio` VARCHAR(45) NULL,
  `fecha` DATE NULL,
  `proveedor` VARCHAR(45) NULL,
  `total` VARCHAR(45) NULL,
  `MermaTotal` VARCHAR(45) NULL,
  `sellos` VARCHAR(45) NULL,
  PRIMARY KEY (`idcompras`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pruebaMood`.`partida`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pruebaMood`.`partida` ;

CREATE TABLE IF NOT EXISTS `pruebaMood`.`partida` (
  `idpartida` INT NOT NULL AUTO_INCREMENT,
  `numPartida` VARCHAR(45) NULL,
  `kilos_eti` VARCHAR(45) NULL,
  `Pieza` VARCHAR(45) NULL,
  `Libras` VARCHAR(45) NULL,
  `pesoBascula` VARCHAR(45) NULL,
  `pesoMuerto` VARCHAR(45) NULL,
  `merma` VARCHAR(45) NULL,
  `costo` VARCHAR(45) NULL,
  `estado` VARCHAR(45) NULL,
  `compra_id` VARCHAR(45) NULL,
  `fecha` DATE NULL,
  `producto` VARCHAR(45) NULL,
  `mermaRCP` VARCHAR(45) NULL,
  PRIMARY KEY (`idpartida`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pruebaMood`.`Productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pruebaMood`.`Productos` ;

CREATE TABLE IF NOT EXISTS `pruebaMood`.`Productos` (
  `idProductos` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NULL,
  `um` VARCHAR(45) NULL,
  `exitencia` VARCHAR(45) NULL,
  PRIMARY KEY (`idProductos`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pruebaMood`.`chofer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pruebaMood`.`chofer` ;

CREATE TABLE IF NOT EXISTS `pruebaMood`.`chofer` (
  `idchofer` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `dir` VARCHAR(45) NULL,
  `tel` VARCHAR(45) NULL,
  PRIMARY KEY (`idchofer`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pruebaMood`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pruebaMood`.`cliente` ;

CREATE TABLE IF NOT EXISTS `pruebaMood`.`cliente` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `direcion` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  PRIMARY KEY (`idcliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pruebaMood`.`sucursal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pruebaMood`.`sucursal` ;

CREATE TABLE IF NOT EXISTS `pruebaMood`.`sucursal` (
  `idsucursal` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `direcion` VARCHAR(45) NULL,
  `rfc` VARCHAR(45) NULL,
  `tel` VARCHAR(45) NULL,
  `cp` VARCHAR(45) NULL,
  `regimen` VARCHAR(45) NULL,
  PRIMARY KEY (`idsucursal`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pruebaMood`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pruebaMood`.`usuario` ;

CREATE TABLE IF NOT EXISTS `pruebaMood`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `usuario` VARCHAR(45) NULL,
  `contra` VARCHAR(45) NULL,
  `dir` VARCHAR(45) NULL,
  `tel` VARCHAR(45) NULL,
  `rol` VARCHAR(45) NULL,
  PRIMARY KEY (`idusuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pruebaMood`.`salidas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pruebaMood`.`salidas` ;

CREATE TABLE IF NOT EXISTS `pruebaMood`.`salidas` (
  `folio` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NULL,
  `destino` VARCHAR(45) NULL,
  `usuario` VARCHAR(45) NULL,
  `chofer` VARCHAR(45) NULL,
  `total` VARCHAR(45) NULL,
  `recepcion` VARCHAR(45) NULL,
  `recibio` VARCHAR(45) NULL,
  PRIMARY KEY (`folio`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pruebaMood`.`venta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pruebaMood`.`venta` ;

CREATE TABLE IF NOT EXISTS `pruebaMood`.`venta` (
  `idventa` INT NOT NULL AUTO_INCREMENT,
  `fecha` DATE NULL,
  `usuario` VARCHAR(45) NULL,
  `cliente` VARCHAR(45) NULL,
  `repartidor` VARCHAR(45) NULL,
  `estado` VARCHAR(45) NULL,
  `total` VARCHAR(45) NULL,
  `descuento` VARCHAR(45) NULL,
  `observacion` VARCHAR(45) NULL,
  PRIMARY KEY (`idventa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pruebaMood`.`pruducto_venta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `pruebaMood`.`pruducto_venta` ;

CREATE TABLE IF NOT EXISTS `pruebaMood`.`pruducto_venta` (
  `idpruducto_venta` INT NOT NULL AUTO_INCREMENT,
  `producto` VARCHAR(45) NULL,
  `piezas` VARCHAR(45) NULL,
  `kilos` VARCHAR(45) NULL,
  `precio` VARCHAR(45) NULL,
  `subTotal` VARCHAR(45) NULL,
  PRIMARY KEY (`idpruducto_venta`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
