-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           8.0.23 - MySQL Community Server - GPL
-- OS do Servidor:               Linux
-- HeidiSQL Versão:              11.1.0.6116
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Copiando estrutura do banco de dados para clinica
DROP DATABASE IF EXISTS `clinica`;
CREATE DATABASE IF NOT EXISTS `clinica` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `clinica`;

-- Copiando estrutura para tabela clinica.enfermeiro
DROP TABLE IF EXISTS `enfermeiro`;
CREATE TABLE IF NOT EXISTS `enfermeiro` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `cpf` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `authorities` varchar(100) NOT NULL DEFAULT 'ROLE_USER',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela clinica.enfermeiro: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `enfermeiro` DISABLE KEYS */;
INSERT INTO `enfermeiro` (`id`, `username`, `cpf`, `password`, `authorities`) VALUES
	(1, 'Doug', '123.321.231-00', '{bcrypt}$2a$10$XAxuWyJ1.wJYTLuem.upxeNRja8rTEoIyrAaKjVADyz42RXboX6nq', 'ROLE_USER'),
	(2, 'coisa', '123.311.231-00', '{bcrypt}$2a$10$XAxuWyJ1.wJYTLuem.upxeNRja8rTEoIyrAaKjVADyz42RXboX6nq', 'ROLE_USER'),
	(3, 'coisa', '123.311.231-00', '{bcrypt}$2a$10$XAxuWyJ1.wJYTLuem.upxeNRja8rTEoIyrAaKjVADyz42RXboX6nq', 'ROLE_USER'),
	(4, 'coisa', '123.311.231-00', '{bcrypt}$2a$10$XAxuWyJ1.wJYTLuem.upxeNRja8rTEoIyrAaKjVADyz42RXboX6nq', 'ROLE_USER');
/*!40000 ALTER TABLE `enfermeiro` ENABLE KEYS */;

-- Copiando estrutura para tabela clinica.medico
DROP TABLE IF EXISTS `medico`;
CREATE TABLE IF NOT EXISTS `medico` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `cpf` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `authorities` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela clinica.medico: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `medico` DISABLE KEYS */;
INSERT INTO `medico` (`id`, `username`, `cpf`, `password`, `authorities`) VALUES
	(1, 'bao', '133.191.656-90', '{bcrypt}$2a$10$XAxuWyJ1.wJYTLuem.upxeNRja8rTEoIyrAaKjVADyz42RXboX6nq', 'ROLE_ADMIN');
/*!40000 ALTER TABLE `medico` ENABLE KEYS */;

-- Copiando estrutura para tabela clinica.paciente
DROP TABLE IF EXISTS `paciente`;
CREATE TABLE IF NOT EXISTS `paciente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `cpf` varchar(45) NOT NULL,
  `nascimento` date DEFAULT NULL,
  `peso` float DEFAULT NULL,
  `altura` float DEFAULT NULL,
  `uf` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Copiando dados para a tabela clinica.paciente: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
INSERT INTO `paciente` (`id`, `nome`, `cpf`, `nascimento`, `peso`, `altura`, `uf`) VALUES
	(1, 'Ivam', '133.191.656-90', '1999-12-27', 87, 190, 'MG'),
	(2, 'Douglas', '133.191.333-90', '2001-11-04', 83, 1.8, 'MG');
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
