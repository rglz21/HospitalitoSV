-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 21-09-2020 a las 03:47:39
-- Versión del servidor: 8.0.18
-- Versión de PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hospital`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `areas`
--

DROP TABLE IF EXISTS `areas`;
CREATE TABLE IF NOT EXISTS `areas` (
  `idArea` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `idClinic` int(11) NOT NULL,
  PRIMARY KEY (`idArea`),
  KEY `fk_idClinic` (`idClinic`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `areas`
--

INSERT INTO `areas` (`idArea`, `nombre`, `idClinic`) VALUES
(1, 'General', 1),
(2, 'Odontologia', 1),
(3, 'Pediatria', 1),
(4, 'Cardiologia', 1),
(5, 'Psicologia', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

DROP TABLE IF EXISTS `citas`;
CREATE TABLE IF NOT EXISTS `citas` (
  `idCita` int(11) NOT NULL,
  `idMedico` varchar(11) NOT NULL,
  `idPaciente` varchar(11) NOT NULL,
  `Fecha` date NOT NULL,
  `hora` varchar(10) NOT NULL,
  `examen` varchar(25) NOT NULL,
  `tipExamen` varchar(25) NOT NULL,
  PRIMARY KEY (`idCita`),
  KEY `fk_idMedico` (`idMedico`),
  KEY `fk_idPaciente` (`idPaciente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `citas`
--

INSERT INTO `citas` (`idCita`, `idMedico`, `idPaciente`, `Fecha`, `hora`, `examen`, `tipExamen`) VALUES
(1, 'MED-1', 'RG-1', '2020-09-01', '1:00PM', 'Si', 'Examen de Sangre');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clinica`
--

DROP TABLE IF EXISTS `clinica`;
CREATE TABLE IF NOT EXISTS `clinica` (
  `idClinic` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(500) NOT NULL,
  `telefono` varchar(12) NOT NULL,
  PRIMARY KEY (`idClinic`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `clinica`
--

INSERT INTO `clinica` (`idClinic`, `nombre`, `direccion`, `telefono`) VALUES
(1, 'Sucursal 1', 'esta por ahi', '2525-2525');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consulta`
--

DROP TABLE IF EXISTS `consulta`;
CREATE TABLE IF NOT EXISTS `consulta` (
  `idConsulta` varchar(11) NOT NULL,
  `idExpe` varchar(11) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `fecha` date NOT NULL,
  `diagnostico` text NOT NULL,
  PRIMARY KEY (`idConsulta`),
  KEY `idExpe` (`idExpe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `consulta`
--

INSERT INTO `consulta` (`idConsulta`, `idExpe`, `descripcion`, `fecha`, `diagnostico`) VALUES
('1', 'EXP-2020', 'Sele hicieron muchas pruebas y todo arroja que va morir', '2020-09-03', 'Covid');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadopre`
--

DROP TABLE IF EXISTS `estadopre`;
CREATE TABLE IF NOT EXISTS `estadopre` (
  `idEstado` int(11) NOT NULL,
  `Estado` varchar(25) NOT NULL,
  PRIMARY KEY (`idEstado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `estadopre`
--

INSERT INTO `estadopre` (`idEstado`, `Estado`) VALUES
(1, 'En Espera'),
(2, 'Revisado'),
(3, 'Rechazado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `examenes`
--

DROP TABLE IF EXISTS `examenes`;
CREATE TABLE IF NOT EXISTS `examenes` (
  `idExam` varchar(11) NOT NULL,
  `idTipo` int(11) NOT NULL,
  `idPaciente` varchar(11) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `fechaRealizado` date NOT NULL,
  `idLab` int(11) NOT NULL,
  PRIMARY KEY (`idExam`),
  KEY `idTipo` (`idTipo`),
  KEY `idLab` (`idLab`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `examenes`
--

INSERT INTO `examenes` (`idExam`, `idTipo`, `idPaciente`, `descripcion`, `fechaRealizado`, `idLab`) VALUES
('EXAM-1', 1, 'RG-1', 'nivel de plaquetas', '2020-09-02', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `expediente`
--

DROP TABLE IF EXISTS `expediente`;
CREATE TABLE IF NOT EXISTS `expediente` (
  `idExpe` varchar(11) NOT NULL,
  `idPaciente` varchar(11) NOT NULL,
  PRIMARY KEY (`idExpe`),
  KEY `idPaciente` (`idPaciente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `expediente`
--

INSERT INTO `expediente` (`idExpe`, `idPaciente`) VALUES
('EXP-2020', 'RG-1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `farmacia`
--

DROP TABLE IF EXISTS `farmacia`;
CREATE TABLE IF NOT EXISTS `farmacia` (
  `idFarma` int(11) NOT NULL,
  `horaA` varchar(10) NOT NULL,
  `horaC` varchar(10) NOT NULL,
  PRIMARY KEY (`idFarma`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `farmacia`
--

INSERT INTO `farmacia` (`idFarma`, `horaA`, `horaC`) VALUES
(1, '7:00AM', '11:00AM');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `labmedicinas`
--

DROP TABLE IF EXISTS `labmedicinas`;
CREATE TABLE IF NOT EXISTS `labmedicinas` (
  `idLabMed` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `Contacto` varchar(100) NOT NULL,
  PRIMARY KEY (`idLabMed`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `labmedicinas`
--

INSERT INTO `labmedicinas` (`idLabMed`, `nombre`, `Contacto`) VALUES
(1, 'Laboratorio Lopez', '5555-5552');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `laboratorio`
--

DROP TABLE IF EXISTS `laboratorio`;
CREATE TABLE IF NOT EXISTS `laboratorio` (
  `idLab` int(11) NOT NULL,
  `horaA` varchar(10) NOT NULL,
  `horaC` varchar(10) NOT NULL,
  PRIMARY KEY (`idLab`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `laboratorio`
--

INSERT INTO `laboratorio` (`idLab`, `horaA`, `horaC`) VALUES
(1, '10:00AM', '11:00AM');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicamentos`
--

DROP TABLE IF EXISTS `medicamentos`;
CREATE TABLE IF NOT EXISTS `medicamentos` (
  `idMedicamento` varchar(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `mg` varchar(25) NOT NULL,
  `cantidadDisp` int(11) NOT NULL,
  `idLabMed` int(11) NOT NULL,
  PRIMARY KEY (`idMedicamento`),
  KEY `idLabMed` (`idLabMed`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `medicamentos`
--

INSERT INTO `medicamentos` (`idMedicamento`, `nombre`, `descripcion`, `mg`, `cantidadDisp`, `idLabMed`) VALUES
('1', 'Acetaminofen', 'Acetaminofen 500mg, de laboratorios lopez', '500', 10, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicina`
--

DROP TABLE IF EXISTS `medicina`;
CREATE TABLE IF NOT EXISTS `medicina` (
  `idMedicina` varchar(11) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `dosis` varchar(100) NOT NULL,
  `mg` varchar(25) NOT NULL,
  `idReceta` int(11) NOT NULL,
  PRIMARY KEY (`idMedicina`),
  KEY `fk_idRecetaa` (`idReceta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `medicina`
--

INSERT INTO `medicina` (`idMedicina`, `nombre`, `cantidad`, `dosis`, `mg`, `idReceta`) VALUES
('1', 'Acetaminofen', 1, '1 cada 8 horas', '500', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicos`
--

DROP TABLE IF EXISTS `medicos`;
CREATE TABLE IF NOT EXISTS `medicos` (
  `idMedico` varchar(11) NOT NULL,
  `JVPM` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `Apellido` varchar(50) NOT NULL,
  `horaIn` varchar(10) NOT NULL,
  `horaOut` varchar(10) NOT NULL,
  `idArea` int(11) NOT NULL,
  PRIMARY KEY (`idMedico`),
  KEY `fk_idArea` (`idArea`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `medicos`
--

INSERT INTO `medicos` (`idMedico`, `JVPM`, `nombre`, `Apellido`, `horaIn`, `horaOut`, `idArea`) VALUES
('MED-1', '12121212121', 'Mario ', 'Hernandez', '1:00 PM', '12:00AM', 1),
('MED-2', '0123456', 'Perla', 'Rivas', '8:00 am', '1:00pm', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

DROP TABLE IF EXISTS `paciente`;
CREATE TABLE IF NOT EXISTS `paciente` (
  `idPaciente` varchar(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `dui` varchar(11) NOT NULL,
  `telefono` varchar(12) NOT NULL,
  `direccion` varchar(500) NOT NULL,
  PRIMARY KEY (`idPaciente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`idPaciente`, `nombre`, `apellido`, `dui`, `telefono`, `direccion`) VALUES
('RG-1', 'Roberto ', 'Gonzalez', '02050507-9', '74785628', 'Vive por la casa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prediagnostico`
--

DROP TABLE IF EXISTS `prediagnostico`;
CREATE TABLE IF NOT EXISTS `prediagnostico` (
  `idPrediag` int(11) NOT NULL,
  `fechaPre` date NOT NULL,
  `idEstado` int(11) NOT NULL,
  `idPaciente` varchar(11) NOT NULL,
  PRIMARY KEY (`idPrediag`),
  KEY `fk_idEstadoooo` (`idEstado`),
  KEY `fk_paciente_prediag_idx` (`idPaciente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `prediagnostico`
--

INSERT INTO `prediagnostico` (`idPrediag`, `fechaPre`, `idEstado`, `idPaciente`) VALUES
(1, '2020-09-01', 1, 'RG-1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recetas`
--

DROP TABLE IF EXISTS `recetas`;
CREATE TABLE IF NOT EXISTS `recetas` (
  `idReceta` int(11) NOT NULL,
  `idMedico` varchar(11) NOT NULL,
  `idPaciente` varchar(11) NOT NULL,
  PRIMARY KEY (`idReceta`),
  KEY `fk_idMedicooo` (`idMedico`),
  KEY `fk_idPacienteeee` (`idPaciente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `recetas`
--

INSERT INTO `recetas` (`idReceta`, `idMedico`, `idPaciente`) VALUES
(1, 'MED-1', 'RG-1'),
(2, 'MED-1', 'RG-1'),
(3, 'MED-2', 'RG-1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sintomas`
--

DROP TABLE IF EXISTS `sintomas`;
CREATE TABLE IF NOT EXISTS `sintomas` (
  `idSintoma` int(11) NOT NULL,
  `idPrediag` int(11) NOT NULL,
  `sintoma` varchar(100) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `duracion` varchar(100) NOT NULL,
  PRIMARY KEY (`idSintoma`),
  KEY `fk_idPrediag` (`idPrediag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `sintomas`
--

INSERT INTO `sintomas` (`idSintoma`, `idPrediag`, `sintoma`, `descripcion`, `duracion`) VALUES
(1, 1, 'Dolor de cabeza', 'siento un dolor de cabeza cerca de la frenta', '50 Min');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoexamenes`
--

DROP TABLE IF EXISTS `tipoexamenes`;
CREATE TABLE IF NOT EXISTS `tipoexamenes` (
  `idTipo` int(11) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  PRIMARY KEY (`idTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `tipoexamenes`
--

INSERT INTO `tipoexamenes` (`idTipo`, `tipo`) VALUES
(1, 'Sangre'),
(2, 'Orina');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipousuario`
--

DROP TABLE IF EXISTS `tipousuario`;
CREATE TABLE IF NOT EXISTS `tipousuario` (
  `idTipo` int(11) NOT NULL AUTO_INCREMENT,
  `Tipo` varchar(25) NOT NULL,
  PRIMARY KEY (`idTipo`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `tipousuario`
--

INSERT INTO `tipousuario` (`idTipo`, `Tipo`) VALUES
(1, 'Paciente'),
(2, 'Medico'),
(3, 'Farmacia'),
(4, 'Laboratorio');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `usuario` varchar(25) NOT NULL,
  `Contrasena` varchar(40) NOT NULL,
  `correo` varchar(60) NOT NULL,
  `idTipo` int(11) NOT NULL,
  `Verificar` varchar(10) NOT NULL,
  PRIMARY KEY (`usuario`),
  KEY `fk_usuario_tipo` (`idTipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`usuario`, `Contrasena`, `correo`, `idTipo`, `Verificar`) VALUES
('rglz', 'hola12', 'algo@gmail.com', 1, '5554522211'),
('rglz-1', 'hola', 'algo@gmail.com', 2, 'Verificado');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `areas`
--
ALTER TABLE `areas`
  ADD CONSTRAINT `fk_idClinic` FOREIGN KEY (`idClinic`) REFERENCES `clinica` (`idClinic`);

--
-- Filtros para la tabla `citas`
--
ALTER TABLE `citas`
  ADD CONSTRAINT `fk_idMedico` FOREIGN KEY (`idMedico`) REFERENCES `medicos` (`idMedico`),
  ADD CONSTRAINT `fk_idPaciente` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`);

--
-- Filtros para la tabla `consulta`
--
ALTER TABLE `consulta`
  ADD CONSTRAINT `consulta_ibfk_1` FOREIGN KEY (`idExpe`) REFERENCES `expediente` (`idExpe`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `examenes`
--
ALTER TABLE `examenes`
  ADD CONSTRAINT `examenes_ibfk_1` FOREIGN KEY (`idTipo`) REFERENCES `tipoexamenes` (`idTipo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `examenes_ibfk_2` FOREIGN KEY (`idLab`) REFERENCES `laboratorio` (`idLab`);

--
-- Filtros para la tabla `expediente`
--
ALTER TABLE `expediente`
  ADD CONSTRAINT `expediente_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `medicamentos`
--
ALTER TABLE `medicamentos`
  ADD CONSTRAINT `medicamentos_ibfk_1` FOREIGN KEY (`idLabMed`) REFERENCES `labmedicinas` (`idLabMed`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `medicina`
--
ALTER TABLE `medicina`
  ADD CONSTRAINT `fk_idRecetaa` FOREIGN KEY (`idReceta`) REFERENCES `recetas` (`idReceta`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `medicos`
--
ALTER TABLE `medicos`
  ADD CONSTRAINT `fk_idArea` FOREIGN KEY (`idArea`) REFERENCES `areas` (`idArea`);

--
-- Filtros para la tabla `prediagnostico`
--
ALTER TABLE `prediagnostico`
  ADD CONSTRAINT `fk_idEstadoooo` FOREIGN KEY (`idEstado`) REFERENCES `estadopre` (`idEstado`),
  ADD CONSTRAINT `fk_prediag_paciente` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `recetas`
--
ALTER TABLE `recetas`
  ADD CONSTRAINT `fk_idMedicooo` FOREIGN KEY (`idMedico`) REFERENCES `medicos` (`idMedico`),
  ADD CONSTRAINT `fk_idPacienteeee` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`);

--
-- Filtros para la tabla `sintomas`
--
ALTER TABLE `sintomas`
  ADD CONSTRAINT `fk_idPrediag` FOREIGN KEY (`idPrediag`) REFERENCES `prediagnostico` (`idPrediag`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_tipo` FOREIGN KEY (`idTipo`) REFERENCES `tipousuario` (`idTipo`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
