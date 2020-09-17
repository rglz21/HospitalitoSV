-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-09-2020 a las 17:53:46
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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

CREATE TABLE `areas` (
  `idArea` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `idClinic` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `areas`
--

INSERT INTO `areas` (`idArea`, `nombre`, `idClinic`) VALUES
(1, 'General', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `idCita` int(11) NOT NULL,
  `idMedico` varchar(11) NOT NULL,
  `idPaciente` varchar(11) NOT NULL,
  `Fecha` date NOT NULL,
  `hora` varchar(10) NOT NULL,
  `examen` varchar(25) NOT NULL,
  `tipExamen` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `citas`
--

INSERT INTO `citas` (`idCita`, `idMedico`, `idPaciente`, `Fecha`, `hora`, `examen`, `tipExamen`) VALUES
(1, 'MED-1', 'RG-1', '2020-09-01', '1:00PM', 'Si', 'Examen de Sangre');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clinica`
--

CREATE TABLE `clinica` (
  `idClinic` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `direccion` varchar(500) NOT NULL,
  `telefono` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clinica`
--

INSERT INTO `clinica` (`idClinic`, `nombre`, `direccion`, `telefono`) VALUES
(1, 'Sucursal 1', 'esta por ahi', '2525-2525');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consulta`
--

CREATE TABLE `consulta` (
  `idConsulta` varchar(11) NOT NULL,
  `idExpe` varchar(11) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `fecha` date NOT NULL,
  `diagnostico` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `consulta`
--

INSERT INTO `consulta` (`idConsulta`, `idExpe`, `descripcion`, `fecha`, `diagnostico`) VALUES
('1', 'EXP-2020', 'Sele hicieron muchas pruebas y todo arroja que va morir', '2020-09-03', 'Covid');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estadopre`
--

CREATE TABLE `estadopre` (
  `idEstado` int(11) NOT NULL,
  `Estado` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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

CREATE TABLE `examenes` (
  `idExam` varchar(11) NOT NULL,
  `idTipo` int(11) NOT NULL,
  `idPaciente` varchar(11) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `fechaRealizado` date NOT NULL,
  `idLab` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `examenes`
--

INSERT INTO `examenes` (`idExam`, `idTipo`, `idPaciente`, `descripcion`, `fechaRealizado`, `idLab`) VALUES
('EXAM-1', 1, 'RG-1', 'nivel de plaquetas', '2020-09-02', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `expediente`
--

CREATE TABLE `expediente` (
  `idExpe` varchar(11) NOT NULL,
  `idPaciente` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `expediente`
--

INSERT INTO `expediente` (`idExpe`, `idPaciente`) VALUES
('EXP-2020', 'RG-1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `farmacia`
--

CREATE TABLE `farmacia` (
  `idFarma` int(11) NOT NULL,
  `horaA` varchar(10) NOT NULL,
  `horaC` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `farmacia`
--

INSERT INTO `farmacia` (`idFarma`, `horaA`, `horaC`) VALUES
(1, '7:00AM', '11:00AM');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `labmedicinas`
--

CREATE TABLE `labmedicinas` (
  `idLabMed` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `Contacto` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `labmedicinas`
--

INSERT INTO `labmedicinas` (`idLabMed`, `nombre`, `Contacto`) VALUES
(1, 'Laboratorio Lopez', '5555-5552');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `laboratorio`
--

CREATE TABLE `laboratorio` (
  `idLab` int(11) NOT NULL,
  `horaA` varchar(10) NOT NULL,
  `horaC` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `laboratorio`
--

INSERT INTO `laboratorio` (`idLab`, `horaA`, `horaC`) VALUES
(1, '10:00AM', '11:00AM');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicamentos`
--

CREATE TABLE `medicamentos` (
  `idMedicamento` varchar(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `mg` varchar(25) NOT NULL,
  `cantidadDisp` int(11) NOT NULL,
  `idLabMed` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `medicamentos`
--

INSERT INTO `medicamentos` (`idMedicamento`, `nombre`, `descripcion`, `mg`, `cantidadDisp`, `idLabMed`) VALUES
('1', 'Acetaminofen', 'Acetaminofen 500mg, de laboratorios lopez', '500', 10, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicina`
--

CREATE TABLE `medicina` (
  `idMedicina` varchar(11) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `dosis` varchar(100) NOT NULL,
  `mg` varchar(25) NOT NULL,
  `idReceta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `medicina`
--

INSERT INTO `medicina` (`idMedicina`, `nombre`, `cantidad`, `dosis`, `mg`, `idReceta`) VALUES
('1', 'Acetaminofen', 1, '1 cada 8 horas', '500', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicos`
--

CREATE TABLE `medicos` (
  `idMedico` varchar(11) NOT NULL,
  `JVPM` varchar(50) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `Apellido` varchar(50) NOT NULL,
  `horaIn` varchar(10) NOT NULL,
  `horaOut` varchar(10) NOT NULL,
  `idArea` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `medicos`
--

INSERT INTO `medicos` (`idMedico`, `JVPM`, `nombre`, `Apellido`, `horaIn`, `horaOut`, `idArea`) VALUES
('MED-1', '12121212121', 'Mario ', 'Hernandez', '1:00 PM', '12:00AM', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `idPaciente` varchar(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `dui` varchar(11) NOT NULL,
  `telefono` varchar(12) NOT NULL,
  `direccion` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`idPaciente`, `nombre`, `apellido`, `dui`, `telefono`, `direccion`) VALUES
('RG-1', 'Roberto ', 'Gonzalez', '02050507-9', '74785628', 'Vive por la casa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prediagnostico`
--

CREATE TABLE `prediagnostico` (
  `idPrediag` int(11) NOT NULL,
  `fechaPre` date NOT NULL,
  `idEstado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `prediagnostico`
--

INSERT INTO `prediagnostico` (`idPrediag`, `fechaPre`, `idEstado`) VALUES
(1, '2020-09-01', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recetas`
--

CREATE TABLE `recetas` (
  `idReceta` int(11) NOT NULL,
  `idMedico` varchar(11) NOT NULL,
  `idPaciente` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `recetas`
--

INSERT INTO `recetas` (`idReceta`, `idMedico`, `idPaciente`) VALUES
(1, 'MED-1', 'RG-1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sintomas`
--

CREATE TABLE `sintomas` (
  `idSintoma` int(11) NOT NULL,
  `idPrediag` int(11) NOT NULL,
  `sintoma` varchar(100) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `duracion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `sintomas`
--

INSERT INTO `sintomas` (`idSintoma`, `idPrediag`, `sintoma`, `descripcion`, `duracion`) VALUES
(1, 1, 'Dolor de cabeza', 'siento un dolor de cabeza cerca de la frenta', '50 Min');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipoexamenes`
--

CREATE TABLE `tipoexamenes` (
  `idTipo` int(11) NOT NULL,
  `tipo` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipoexamenes`
--

INSERT INTO `tipoexamenes` (`idTipo`, `tipo`) VALUES
(1, 'Sangre'),
(2, 'Orina');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `usuario` varchar(25) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellido` varchar(40) NOT NULL,
  `Contrasena` varchar(40) NOT NULL,
  `Verificar` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`usuario`, `nombre`, `apellido`, `Contrasena`, `Verificar`) VALUES
('rglz', 'Jose', 'Gonzalez', 'hola12', '5554522211'),
('rglz-1', 'Roberto', 'Gonzalez', 'hola', 'Verificado');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `areas`
--
ALTER TABLE `areas`
  ADD PRIMARY KEY (`idArea`),
  ADD KEY `fk_idClinic` (`idClinic`);

--
-- Indices de la tabla `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`idCita`),
  ADD KEY `fk_idMedico` (`idMedico`),
  ADD KEY `fk_idPaciente` (`idPaciente`);

--
-- Indices de la tabla `clinica`
--
ALTER TABLE `clinica`
  ADD PRIMARY KEY (`idClinic`);

--
-- Indices de la tabla `consulta`
--
ALTER TABLE `consulta`
  ADD PRIMARY KEY (`idConsulta`),
  ADD KEY `idExpe` (`idExpe`);

--
-- Indices de la tabla `estadopre`
--
ALTER TABLE `estadopre`
  ADD PRIMARY KEY (`idEstado`);

--
-- Indices de la tabla `examenes`
--
ALTER TABLE `examenes`
  ADD PRIMARY KEY (`idExam`),
  ADD KEY `idTipo` (`idTipo`),
  ADD KEY `idLab` (`idLab`);

--
-- Indices de la tabla `expediente`
--
ALTER TABLE `expediente`
  ADD PRIMARY KEY (`idExpe`),
  ADD KEY `idPaciente` (`idPaciente`);

--
-- Indices de la tabla `farmacia`
--
ALTER TABLE `farmacia`
  ADD PRIMARY KEY (`idFarma`);

--
-- Indices de la tabla `labmedicinas`
--
ALTER TABLE `labmedicinas`
  ADD PRIMARY KEY (`idLabMed`);

--
-- Indices de la tabla `laboratorio`
--
ALTER TABLE `laboratorio`
  ADD PRIMARY KEY (`idLab`);

--
-- Indices de la tabla `medicamentos`
--
ALTER TABLE `medicamentos`
  ADD PRIMARY KEY (`idMedicamento`),
  ADD KEY `idLabMed` (`idLabMed`);

--
-- Indices de la tabla `medicina`
--
ALTER TABLE `medicina`
  ADD PRIMARY KEY (`idMedicina`),
  ADD KEY `fk_idRecetaa` (`idReceta`);

--
-- Indices de la tabla `medicos`
--
ALTER TABLE `medicos`
  ADD PRIMARY KEY (`idMedico`),
  ADD KEY `fk_idArea` (`idArea`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`idPaciente`);

--
-- Indices de la tabla `prediagnostico`
--
ALTER TABLE `prediagnostico`
  ADD PRIMARY KEY (`idPrediag`),
  ADD KEY `fk_idEstadoooo` (`idEstado`);

--
-- Indices de la tabla `recetas`
--
ALTER TABLE `recetas`
  ADD PRIMARY KEY (`idReceta`),
  ADD KEY `fk_idMedicooo` (`idMedico`),
  ADD KEY `fk_idPacienteeee` (`idPaciente`);

--
-- Indices de la tabla `sintomas`
--
ALTER TABLE `sintomas`
  ADD PRIMARY KEY (`idSintoma`),
  ADD KEY `fk_idPrediag` (`idPrediag`);

--
-- Indices de la tabla `tipoexamenes`
--
ALTER TABLE `tipoexamenes`
  ADD PRIMARY KEY (`idTipo`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`usuario`);

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
  ADD CONSTRAINT `fk_idEstadoooo` FOREIGN KEY (`idEstado`) REFERENCES `estadopre` (`idEstado`);

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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
