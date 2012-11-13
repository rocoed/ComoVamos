/*
SQLyog Ultimate v9.63 
MySQL - 5.5.27 : Database - comovamos
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`comovamos` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `comovamos`;

/*Table structure for table `com_actividades` */

DROP TABLE IF EXISTS `com_actividades`;

CREATE TABLE `com_actividades` (
  `ACT_id` int(11) NOT NULL AUTO_INCREMENT,
  `ACT_nombre` varchar(45) DEFAULT NULL,
  `ACT_TipodeActividad` int(11) NOT NULL,
  PRIMARY KEY (`ACT_id`),
  KEY `fk_Actividad_TipoDeActividad1_idx` (`ACT_TipodeActividad`),
  CONSTRAINT `fk_Actividad_TipoDeActividad1` FOREIGN KEY (`ACT_TipodeActividad`) REFERENCES `com_tipodeactividades` (`TIP_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `com_actividades` */

LOCK TABLES `com_actividades` WRITE;

UNLOCK TABLES;

/*Table structure for table `com_detallepreguntas` */

DROP TABLE IF EXISTS `com_detallepreguntas`;

CREATE TABLE `com_detallepreguntas` (
  `DET_id` int(11) NOT NULL AUTO_INCREMENT,
  `DET_Pregunta` varchar(100) NOT NULL,
  `DET_Tipo` varchar(20) DEFAULT NULL,
  `DET_Formula` varchar(100) DEFAULT NULL,
  `DET_Resultado` varchar(100) NOT NULL,
  `DET_Color` varchar(10) DEFAULT NULL,
  `DET_Plantilla` int(11) NOT NULL,
  PRIMARY KEY (`DET_id`),
  KEY `fk_COM_DetallesEncuestas_COM_Encuestas1_idx` (`DET_Plantilla`),
  CONSTRAINT `fk_COM_DetallesEncuestas_COM_Encuestas1` FOREIGN KEY (`DET_Plantilla`) REFERENCES `com_plantilla` (`PLA_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `com_detallepreguntas` */

LOCK TABLES `com_detallepreguntas` WRITE;

UNLOCK TABLES;

/*Table structure for table `com_entidad` */

DROP TABLE IF EXISTS `com_entidad`;

CREATE TABLE `com_entidad` (
  `DZN_id` int(11) NOT NULL AUTO_INCREMENT,
  `DZN_NombreEntidad` varchar(100) NOT NULL,
  `DZN_descripcion` varchar(400) DEFAULT NULL,
  `DZN_Region` int(11) NOT NULL,
  PRIMARY KEY (`DZN_id`),
  KEY `fk_COM_DetalleZonas_COM_Zonas1_idx` (`DZN_Region`),
  CONSTRAINT `fk_COM_DetalleZonas_COM_Zonas1` FOREIGN KEY (`DZN_Region`) REFERENCES `com_region` (`REG_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `com_entidad` */

LOCK TABLES `com_entidad` WRITE;

UNLOCK TABLES;

/*Table structure for table `com_historial` */

DROP TABLE IF EXISTS `com_historial`;

CREATE TABLE `com_historial` (
  `HIS_id` int(11) NOT NULL AUTO_INCREMENT,
  `HIS_Usuario` int(11) NOT NULL,
  `HIS_Actividad` int(11) NOT NULL,
  `HIS_fecha` varchar(45) DEFAULT NULL,
  `HIS_hora` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`HIS_id`),
  KEY `fk_Historial_Usuario_idx` (`HIS_Usuario`),
  KEY `fk_Historial_Actividad1_idx` (`HIS_Actividad`),
  CONSTRAINT `fk_Historial_Usuario` FOREIGN KEY (`HIS_Usuario`) REFERENCES `com_usuarios` (`USU_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Historial_Actividad1` FOREIGN KEY (`HIS_Actividad`) REFERENCES `com_actividades` (`ACT_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `com_historial` */

LOCK TABLES `com_historial` WRITE;

UNLOCK TABLES;

/*Table structure for table `com_indicador` */

DROP TABLE IF EXISTS `com_indicador`;

CREATE TABLE `com_indicador` (
  `IND_flag` tinyint(1) DEFAULT '0',
  `IND_id` int(11) NOT NULL AUTO_INCREMENT,
  `IND_Nombre` varchar(45) NOT NULL,
  `IND_Formula` varchar(100) DEFAULT NULL,
  `IND_Color` varchar(10) DEFAULT NULL,
  `IND_Padre` int(11) DEFAULT NULL,
  PRIMARY KEY (`IND_id`),
  KEY `fk_COM_Indicador_COM_Indicador1_idx` (`IND_Padre`),
  CONSTRAINT `fk_COM_Indicador_COM_Indicador1` FOREIGN KEY (`IND_Padre`) REFERENCES `com_indicador` (`IND_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `com_indicador` */

LOCK TABLES `com_indicador` WRITE;

UNLOCK TABLES;

/*Table structure for table `com_perfiles` */

DROP TABLE IF EXISTS `com_perfiles`;

CREATE TABLE `com_perfiles` (
  `PERF_id` int(11) NOT NULL AUTO_INCREMENT,
  `PERF_nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PERF_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `com_perfiles` */

LOCK TABLES `com_perfiles` WRITE;

UNLOCK TABLES;

/*Table structure for table `com_plantilla` */

DROP TABLE IF EXISTS `com_plantilla`;

CREATE TABLE `com_plantilla` (
  `PLA_flag` tinyint(1) DEFAULT '0',
  `PLA_id` int(11) NOT NULL AUTO_INCREMENT,
  `PLA_NomPlantilla` varchar(100) NOT NULL,
  `PLA_Descripcion` varchar(300) DEFAULT NULL,
  `PLA_Periodo` datetime NOT NULL,
  `PLA_Indicador` int(11) NOT NULL,
  `PLA_Usuario` int(11) NOT NULL,
  PRIMARY KEY (`PLA_id`),
  KEY `fk_COM_Encuestas_COM_Usuario1_idx` (`PLA_Usuario`),
  KEY `fk_COM_Plantila_COM_Indicador1_idx` (`PLA_Indicador`),
  CONSTRAINT `fk_COM_Encuestas_COM_Usuario1` FOREIGN KEY (`PLA_Usuario`) REFERENCES `com_usuarios` (`USU_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_COM_Plantila_COM_Indicador1` FOREIGN KEY (`PLA_Indicador`) REFERENCES `com_indicador` (`IND_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `com_plantilla` */

LOCK TABLES `com_plantilla` WRITE;

UNLOCK TABLES;

/*Table structure for table `com_preguntassecretas` */

DROP TABLE IF EXISTS `com_preguntassecretas`;

CREATE TABLE `com_preguntassecretas` (
  `PRE_id` int(11) NOT NULL AUTO_INCREMENT,
  `PRE_pregunta` varchar(45) DEFAULT NULL,
  `PRE_respuesta` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PRE_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `com_preguntassecretas` */

LOCK TABLES `com_preguntassecretas` WRITE;

UNLOCK TABLES;

/*Table structure for table `com_region` */

DROP TABLE IF EXISTS `com_region`;

CREATE TABLE `com_region` (
  `REG_id` int(11) NOT NULL AUTO_INCREMENT,
  `REG_nombreRegion` varchar(150) NOT NULL,
  `REG_Encuesta` int(11) NOT NULL,
  PRIMARY KEY (`REG_id`),
  KEY `fk_COM_Zonas_COM_Encuestas1_idx` (`REG_Encuesta`),
  CONSTRAINT `fk_COM_Zonas_COM_Encuestas1` FOREIGN KEY (`REG_Encuesta`) REFERENCES `com_plantilla` (`PLA_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `com_region` */

LOCK TABLES `com_region` WRITE;

UNLOCK TABLES;

/*Table structure for table `com_tipodeactividades` */

DROP TABLE IF EXISTS `com_tipodeactividades`;

CREATE TABLE `com_tipodeactividades` (
  `TIP_id` int(11) NOT NULL AUTO_INCREMENT,
  `TIP_nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`TIP_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `com_tipodeactividades` */

LOCK TABLES `com_tipodeactividades` WRITE;

UNLOCK TABLES;

/*Table structure for table `com_usuarios` */

DROP TABLE IF EXISTS `com_usuarios`;

CREATE TABLE `com_usuarios` (
  `USU_id` int(11) NOT NULL AUTO_INCREMENT,
  `USU_usuario` varchar(45) NOT NULL,
  `USU_contraseña` varchar(45) NOT NULL,
  `USU_Perfiles` int(11) NOT NULL,
  `USU_nombreCompleto` varchar(45) DEFAULT NULL,
  `USU_dirección` varchar(45) DEFAULT NULL,
  `USU_teléfono` varchar(45) DEFAULT NULL,
  `USU_correo` varchar(45) DEFAULT NULL,
  `USU_PreguntaSecreta` int(11) NOT NULL,
  PRIMARY KEY (`USU_id`),
  KEY `fk_Usuario_Perfil1_idx` (`USU_Perfiles`),
  KEY `fk_Usuario_PreguntaSecreta1_idx` (`USU_PreguntaSecreta`),
  CONSTRAINT `fk_Usuario_Perfil1` FOREIGN KEY (`USU_Perfiles`) REFERENCES `com_perfiles` (`PERF_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_PreguntaSecreta1` FOREIGN KEY (`USU_PreguntaSecreta`) REFERENCES `com_preguntassecretas` (`PRE_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `com_usuarios` */

LOCK TABLES `com_usuarios` WRITE;

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
