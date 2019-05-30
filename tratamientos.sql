DROP DATABASE naturness;

CREATE DATABASE naturness;

USE naturness;

CREATE TABLE `clientes` (
  `nif` varchar(11) NOT NULL,
  `nombre` varchar(11) NOT NULL,
  `apellidos` varchar(11) NOT NULL,
  `cp` varchar(11),
  `teléfono` int(11),
  `fecha_nacimiento` date,
  `fecha_registro` datetime) 
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`nif`, `nombre`, `apellidos`, `cp`, `teléfono`, `fecha_nacimiento`, `fecha_registro`) VALUES
('0', 'Invitado', 'Invitado', '00000', 0, NULL, NULL),
('12345678F', 'Ana', 'Fernandez', '07003', 123345667, '1990-07-14', '2019-03-07 00:00:00'),
('12345678W', 'Pepe', 'Jimenez', '07001', 123456789, '1978-02-25', '2019-01-15 00:00:00'),
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
(1, '0', 1101, 1, 49, '2019-01-09 23:00:00'),
(2, '0', 1402, 2, 9.9, '2019-03-01 23:00:00'),
(3, '45778123B', 1302, 1, 19, '2019-04-29 22:00:00'),
(4, '12345678W', 1501, 3, 17.85, '2019-01-14 23:00:00'),
(5, '12345678F', 1303, 1, 34, '2019-05-20 18:30:32');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tratamiento`
--

CREATE TABLE `tratamiento` (
  `ean` int(14) NOT NULL,
  `nombre` varchar(11) DEFAULT NULL
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tratamiento`
--

INSERT INTO `tratamiento` (`ean`, `nombre`) VALUES
(1101, 'Hya'),
(1102, 'Hya Eyes'),
(1201, 'Rose'),
(1202, 'Rose Eyes'),
(1301, 'Coco balm'),
(1302, 'Aloe balm'),
(1303, 'Body oil'),
(1401, 'Handy'),
(1402, 'Handy'),
(1501, 'Refresh gel'),
(1502, 'La viellité');

CREATE TABLE hidratante (
  `id` int(10) NOT NULL,
  `id_tratamiento` int(10) NOT NULL,
  `descripcion` varchar(100),
  `zona_aplicacion` varchar(11),
  `stock` int(11),
  `precio_ud` float(5)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

 
 
INSERT INTO `hidratante`(`id`, `id_tratamiento`, `descripcion`, `zona_aplicacion`, `stock`, `precio_ud`) VALUES
  (1, 1201, 'Hidratante  con rosa mosqueta', 'rostro', 10, 39),
  (2, 1202, 'Contorno de ojos hidratante con rosa mosqueta', 'ojos', 10, 29),
  (3, 1301, 'Leche corporal de coco', 'cuerpo', 10, 19),
  (4, 1302, 'Leche corporal de aloe vera', 'cuerpo', 10, 19),
  (5, 1303, 'Aceite corporal de almendras y manteca de karité', 'cuerpo', 10, 23.95),
  (6, 1401, 'Emulsión de manos de coco', 'manos', 10, 4.95),
  (7, 1402, 'Crema hidratante de manos de aloe vera', 'manos', 10, 4.95);



CREATE TABLE antiedad (
  `id` int(10) NOT NULL,
  `id_tratamiento` int(10) NOT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `zona_aplicacion` varchar(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `precio_ud` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



INSERT INTO antiedad (id, id_tratamiento, descripcion, zona_aplicacion, stock, precio_ud) VALUES 
(1, 1101, 'Hidratante antiedad con ácido hyalurónico', 'rostro', 10, 49),
(2, 1102, 'Contorno de ojos hidratante antiedad con ácido hyalurónico', 'ojos', 10, 39),
(3, 1501, 'Gel hidratante y regenerante con menta y aloe', 'piernas ', 10, 5.95),
(4, 1502, 'Crema antiedad y regeneradora de piel con aceite de argán y aguacate', 'cuello', 10, 59);


ALTER TABLE `clientes`
  ADD PRIMARY KEY (`nif`);

ALTER TABLE `tratamiento`
  ADD PRIMARY KEY (`ean`);

ALTER TABLE `facturas`
  ADD PRIMARY KEY (`num_fact`);

ALTER TABLE `antiedad`
  ADD PRIMARY KEY (id);

ALTER TABLE `hidratante`
  ADD PRIMARY KEY (id);

ALTER TABLE `facturas`
ADD CONSTRAINT FOREIGN KEY (nif_cliente) REFERENCES clientes(nif),
ADD CONSTRAINT FOREIGN KEY (ean_tratamiento) REFERENCES tratamiento(ean);


-- ALTER TABLE facturas
-- ADD FOREIGN KEY (ean_tratamiento) REFERENCES tratamiento(ean);


ALTER TABLE hidratante
ADD CONSTRAINT FOREIGN KEY (id_tratamiento) REFERENCES tratamiento(ean);

ALTER TABLE antiedad
ADD CONSTRAINT FOREIGN KEY (id_tratamiento) REFERENCES tratamiento(ean);

ALTER TABLE `facturas`
  MODIFY `num_fact` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

ALTER TABLE hidratante
  MODIFY id int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

ALTER TABLE antiedad
  MODIFY id int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
