# ************************************************************
# Antares - SQL Client
# Version 0.7.30
# 
# https://antares-sql.app/
# https://github.com/antares-sql/antares
# 
# Host: 127.0.0.1 (MySQL Community Server - GPL 9.1.0)
# Database: jfx-jdbc
# Generation time: 2025-01-06T22:24:12-04:00
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
SET NAMES utf8mb4;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table cadidados
# ------------------------------------------------------------

DROP TABLE IF EXISTS `cadidados`;

CREATE TABLE `cadidados` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `email` varchar(120) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `birthDate` date DEFAULT NULL,
  `BaseSalary` double DEFAULT NULL,
  `perfil` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `departamentoId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_departamento` FOREIGN KEY (`id`) REFERENCES `departamentos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `cadidados` WRITE;
/*!40000 ALTER TABLE `cadidados` DISABLE KEYS */;

INSERT INTO `cadidados` (`id`, `name`, `email`, `birthDate`, `BaseSalary`, `perfil`, `departamentoId`) VALUES
	(1, "Bob Brown", "bob@gmail.com", "1998-04-21", 1000, "PAE", 1),
	(2, "Maria Green", "maria@gmail.com", "1979-12-31", 3500, "AC", 2),
	(3, "Alex Pink", "alexcolouteucucomdurex@gmail.com", "1997-03-04", 3000, "CE", 2);

/*!40000 ALTER TABLE `cadidados` ENABLE KEYS */;
UNLOCK TABLES;



# Dump of table departamentos
# ------------------------------------------------------------

DROP TABLE IF EXISTS `departamentos`;

CREATE TABLE `departamentos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(110) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `gerente` varchar(110) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `coordenador` varchar(110) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `departamentos` WRITE;
/*!40000 ALTER TABLE `departamentos` DISABLE KEYS */;

INSERT INTO `departamentos` (`id`, `name`, `gerente`, `coordenador`) VALUES
	(1, "TECNOLOGIA DA INFORMACAO", "FREDSON PALMA LOPES", "JOSE PEREIRA DA SILVA (Juca)"),
	(2, "CONTAS MEDICAS", "RICARDO ALVES TAVARES", "WESLEY DA SILVA DIAS"),
	(3, "DESENVOLVIMENTO DE MERCADO", "JEFFERSON CLAUDIO DIAS PAIAO", "FERNANDA NAYARA PEREIRA SANTOS DINIZ");

/*!40000 ALTER TABLE `departamentos` ENABLE KEYS */;
UNLOCK TABLES;



# Dump of table vagas
# ------------------------------------------------------------

DROP TABLE IF EXISTS `vagas`;

CREATE TABLE `vagas` (
  `id` tinyint NOT NULL,
  `nome_vaga` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `setor` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tipo` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `data_encerramento` tinyint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;





# Dump of views
# ------------------------------------------------------------

# Creating temporary tables to overcome VIEW dependency errors


/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

# Dump completed on 2025-01-06T22:24:12-04:00
