-- phpMyAdmin SQL Dump
-- version 4.6.6deb4
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 02-06-2019 a las 00:47:17
-- Versión del servidor: 10.1.38-MariaDB-0+deb9u1
-- Versión de PHP: 7.0.33-0+deb9u3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `naturness`
--
CREATE DATABASE IF NOT EXISTS `naturness` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `naturness`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `antiedad`
--

CREATE TABLE `antiedad` (
  `id` int(10) NOT NULL,
  `id_tratamiento` int(10) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `zona_aplicacion` varchar(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `precio_ud` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `antiedad`
--

INSERT INTO `antiedad` (`id`, `id_tratamiento`, `descripcion`, `zona_aplicacion`, `stock`, `precio_ud`) VALUES
(1, 1101, 'Hidratante antiedad con ácido hyalurónico', 'rostro', 10, 49),
(2, 1102, 'Contorno de ojos hidratante antiedad con ácido hyalurónico', 'ojos', 10, 39),
(3, 1501, 'Gel hidratante y regenerante con menta y aloe', 'piernas ', 10, 5.95),
(4, 1502, 'Crema antiedad y regeneradora de piel con aceite de argán y aguacate', 'cuello', 10, 59);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `nif` varchar(11) NOT NULL,
  `nombre` varchar(11) NOT NULL,
  `apellidos` varchar(11) NOT NULL,
  `cp` varchar(11) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `fecha_registro` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`nif`, `nombre`, `apellidos`, `cp`, `telefono`, `fecha_nacimiento`, `fecha_registro`) VALUES
('0', 'Invitado', 'Invitado', '00000', 0, NULL, NULL),
('12345678F', 'Ana', 'Fernandez', '07003', 123345667, '1990-07-14', '2019-03-07 00:00:00'),
('12345678W', 'Pepe', 'Jimenez', '07001', 123456789, '1978-02-25', '2019-01-15 00:00:00'),
('43153848Y', 'Jose', 'Martin', '07008', 617390788, '1984-02-04', '2019-06-01 19:03:13'),
('45678123X', 'Antonio', 'Lopez', '07012', 987654321, '1986-04-12', '2019-02-20 00:00:00'),
('45778123B', 'Isabel', 'García', '28080', 234156789, '1977-11-27', '2019-04-30 00:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas`
--

CREATE TABLE `facturas` (
  `num_fact` int(11) NOT NULL,
  `nif_cliente` varchar(11) NOT NULL,
  `ean_tratamiento` int(11) NOT NULL DEFAULT '0',
  `cantidad` int(11) NOT NULL DEFAULT '1',
  `precio` float DEFAULT NULL,
  `fecha_compra` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `facturas`
--

INSERT INTO `facturas` (`num_fact`, `nif_cliente`, `ean_tratamiento`, `cantidad`, `precio`, `fecha_compra`) VALUES
(1, '0', 1101, 1, 49, '2019-01-09 22:00:00'),
(2, '0', 1402, 2, 9.9, '2019-03-01 22:00:00'),
(3, '45778123B', 1302, 1, 19, '2019-04-29 20:00:00'),
(4, '12345678W', 1501, 3, 17.85, '2019-01-14 22:00:00'),
(5, '12345678F', 1303, 1, 34, '2019-05-20 16:30:32');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hidratante`
--

CREATE TABLE `hidratante` (
  `id` int(10) NOT NULL,
  `id_tratamiento` int(10) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `zona_aplicacion` varchar(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `precio_ud` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `hidratante`
--

INSERT INTO `hidratante` (`id`, `id_tratamiento`, `descripcion`, `zona_aplicacion`, `stock`, `precio_ud`) VALUES
(1, 1201, 'Hidratante  con rosa mosqueta', 'rostro', 10, 39),
(2, 1202, 'Contorno de ojos hidratante con rosa mosqueta', 'ojos', 10, 29),
(3, 1301, 'Leche corporal de coco', 'cuerpo', 10, 19),
(4, 1302, 'Leche corporal de aloe vera', 'cuerpo', 10, 19),
(5, 1303, 'Aceite corporal de almendras y manteca de karité', 'cuerpo', 10, 23.95),
(6, 1401, 'Emulsión de manos de coco', 'manos', 10, 4.95),
(7, 1402, 'Crema hidratante de manos de aloe vera', 'manos', 10, 4.95);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tratamiento`
--

CREATE TABLE `tratamiento` (
  `ean` int(5) NOT NULL,
  `marca` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tratamiento`
--

INSERT INTO `tratamiento` (`ean`, `marca`) VALUES
(1101, 'Hya'),
(1102, 'Hya Eyes'),
(1201, 'Rose'),
(1202, 'Rose Eyes'),
(1234, 'Marca'),
(1301, 'Coco balm'),
(1302, 'Aloe balm'),
(1303, 'Body oil'),
(1401, 'Handy'),
(1402, 'Handy'),
(1501, 'Refresh gel'),
(1502, 'La viellité');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `antiedad`
--
ALTER TABLE `antiedad`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_tratamiento` (`id_tratamiento`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`nif`);

--
-- Indices de la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD PRIMARY KEY (`num_fact`),
  ADD KEY `nif_cliente` (`nif_cliente`),
  ADD KEY `ean_tratamiento` (`ean_tratamiento`);

--
-- Indices de la tabla `hidratante`
--
ALTER TABLE `hidratante`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_tratamiento` (`id_tratamiento`);

--
-- Indices de la tabla `tratamiento`
--
ALTER TABLE `tratamiento`
  ADD PRIMARY KEY (`ean`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `antiedad`
--
ALTER TABLE `antiedad`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `facturas`
--
ALTER TABLE `facturas`
  MODIFY `num_fact` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `hidratante`
--
ALTER TABLE `hidratante`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `antiedad`
--
ALTER TABLE `antiedad`
  ADD CONSTRAINT `antiedad_ibfk_1` FOREIGN KEY (`id_tratamiento`) REFERENCES `tratamiento` (`ean`);

--
-- Filtros para la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD CONSTRAINT `facturas_ibfk_1` FOREIGN KEY (`nif_cliente`) REFERENCES `clientes` (`nif`),
  ADD CONSTRAINT `facturas_ibfk_2` FOREIGN KEY (`ean_tratamiento`) REFERENCES `tratamiento` (`ean`);

--
-- Filtros para la tabla `hidratante`
--
ALTER TABLE `hidratante`
  ADD CONSTRAINT `hidratante_ibfk_1` FOREIGN KEY (`id_tratamiento`) REFERENCES `tratamiento` (`ean`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
