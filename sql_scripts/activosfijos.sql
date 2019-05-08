CREATE DATABASE  IF NOT EXISTS `activos_fijos` /*!40100 DEFAULT CHARACTER SET latin1 */;

CREATE USER 'jdgamboa'@'localhost' IDENTIFIED BY 'JDkdmt84f7&f0';

GRANT ALL PRIVILEGES ON `activos_fijos`.* TO 'jdgamboa'@'localhost';

USE `activos_fijos`;

DROP TABLE IF EXISTS `empleado`;
CREATE TABLE `empleado` (
  `cod_empleado` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  PRIMARY KEY (`cod_empleado`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `empleado` VALUES 
	('HR001','Andres','Ramirez'),
	('HR002','Pedro','Gonzalez'),
	('HR003','Juan','Gamboa'),
	('HR004','Jorge','Castro'),
	('HR005','Santiago','Vargas');

DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `cod_area` varchar(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `ciudad` varchar(50) NOT NULL,
  PRIMARY KEY (`cod_area`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `area` VALUES 
	('A001','Area abc','Bogota'),
	('A002','Area def','Medellin'),
	('A003','Area ghi','Barranquilla');

DROP TABLE IF EXISTS `activo`;
CREATE TABLE `activo` (
  `serial` varchar(50) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `peso` int DEFAULT NULL,
  `alto` int DEFAULT NULL,
  `ancho` int DEFAULT NULL,
  `largo` int DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  `cod_inventario` varchar(20) NOT NULL UNIQUE,
  `valor_compra` decimal(15,2) NOT NULL,
  `fecha_compra` date NOT NULL,
  `fecha_baja` date DEFAULT NULL,
  `estado` enum('activo', 'dado de baja', 'en reparacion', 'disponible', 'asignado') NOT NULL,
  `asignacion_empleado` varchar(20) DEFAULT NULL,
  `asignacion_area` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`serial`),
  FOREIGN KEY (`asignacion_empleado`) REFERENCES `empleado`(`cod_empleado`),
  FOREIGN KEY (`asignacion_area`) REFERENCES `area`(`cod_area`),
  CONSTRAINT `asignacion` CHECK (
      CASE WHEN `asignacion_empleado` IS NULL THEN 0 ELSE 1 END +
      CASE WHEN `asignacion_area` IS NULL THEN 0 ELSE 1 END = 1
    ),
  CONSTRAINT `fecha_baja_valida` CHECK (
      CASE WHEN `fecha_baja` IS NOT NULL AND `fecha_baja` < `fecha_compra` THEN 0 ELSE 1 END = 1
    )
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `activo` VALUES 
	('ACT-M001','Mesa x','Mesa...', 'Mueble', 10000, 100, 100, 100, 'Ocre', 'ZWS679', 500000.00, '2019-01-01', NULL, 'activo', NULL, 'A001'),
	('ACT-M002','Mesa x','Mesa...', 'Mueble', 10000, 100, 100, 100, 'Ocre', 'KYI249', 400000.00, '2019-03-05', NULL, 'en reparacion', NULL, 'A003'),
	('ACT-M003','Silla y','Silla...', 'Mueble', 8000, 120, 60, 60, 'Negro', 'EFY483', 300000.00, '2019-02-03', NULL, 'activo', NULL, 'A002'),
	('ACT-E001','Laptop z','Laptop...', 'Electronico', 2000, 40, 50, 40, 'Negro', 'ABC003', 1500000.00, '2019-01-01', NULL, 'activo', 'HR003', NULL),
	('ACT-E002','Laptop z','Laptop...', 'Electronico', 2000, 40, 50, 40, 'Negro', 'DEF123', 1500000.00, '2019-01-01', '2019-05-01', 'dado de baja', 'HR001', NULL);

/*
DROP TABLE IF EXISTS `activo`;
CREATE TABLE `activo` (
  `serial` varchar(50) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `peso` int DEFAULT NULL,
  `alto` int DEFAULT NULL,
  `ancho` int DEFAULT NULL,
  `largo` int DEFAULT NULL,
  `color` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`serial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `activo` VALUES 
	('ACT-M001','Mesa x','Mesa...', 'Mueble', 10000, 100, 100, 100, 'Marrón'),
	('ACT-M002','Silla y','Silla...', 'Mueble', 8000, 120, 60, 60, 'Negro'),
	('ACT-E001','Laptop z','Laptop...', 'Electrónico', 2000, 40, 50, 40, 'Negro');
	('ACT-E002','Pantalla z','Pantalla...', 'Electrónico', 5000, 80, 100, 20, 'Negro');

DROP TABLE IF EXISTS `activo_inventario`;
CREATE TABLE `activo_inventario` (
  `cod_inventario` varchar(20) NOT NULL,
  `serial_activo` varchar(50) NOT NULL,
  `valor_compra` decimal(15,2) NOT NULL,
  `fecha_compra` date NOT NULL,
  `fecha_baja` date DEFAULT NULL,
  `estado` enum('activo', 'dado de baja', 'en reparacion', 'disponible', 'asignado') NOT NULL,
  `asignacion_empleado` varchar(20) DEFAULT NULL,
  `asignacion_area` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`num_inventario`),
  FOREIGN KEY (`serial_activo`) REFERENCES `activo`(`serial`),
  FOREIGN KEY (`asignacion_empleado`) REFERENCES `empleado`(`cod_empleado`),
  FOREIGN KEY (`asignacion_area`) REFERENCES `area`(`cod_area`),
  CONSTRAINT `asignacion` CHECK (
      CASE WHEN `asignacion_empleado` IS NULL THEN 0 ELSE 1 END +
      CASE WHEN `asignacion_area` IS NULL THEN 0 ELSE 1 END = 1
    )
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `activo_inventario` VALUES 
	('ABC003','ACT-E001', 1500000.00, '2019-01-01', NULL, 'activo', 'HR003', NULL),
	('DEF123','ACT-E001', 1500000.00, '2019-01-01', '2019-05-01', 'dado de baja', 'HR001', NULL),
	('ZWS679','ACT-M001', 500000.00, '2019-01-01', NULL, 'activo', NULL, 'A001'),
	('EFY483','ACT-M002', 300000.00, '2019-02-03', NULL, 'activo', NULL, 'A002'),
	('KYI249','ACT-M001', 400000.00, '2019-03-05', NULL, 'activo', NULL, 'A003');
*/