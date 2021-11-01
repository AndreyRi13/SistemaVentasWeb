-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-11-2021 a las 05:07:08
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_ventas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calzado`
--

CREATE TABLE `calzado` (
  `idCalzado` int(11) NOT NULL,
  `referencia` int(11) NOT NULL,
  `nombres` varchar(100) NOT NULL,
  `descripcion` varchar(150) NOT NULL,
  `marca` varchar(100) NOT NULL,
  `color` varchar(100) NOT NULL,
  `colorSuela` varchar(150) NOT NULL,
  `talla` int(11) NOT NULL,
  `precio` double NOT NULL,
  `stock` int(11) NOT NULL,
  `estado` varchar(100) NOT NULL,
  `foto` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `calzado`
--

INSERT INTO `calzado` (`idCalzado`, `referencia`, `nombres`, `descripcion`, `marca`, `color`, `colorSuela`, `talla`, `precio`, `stock`, `estado`, `foto`) VALUES
(1, 72002, 'Calzado AirMax', 'Calzado unisex', 'Nike', 'azul y negro', 'negro', 35, 35000, 30, '1', 'Zapatos-Hombre-Tenis-Nike-720-100-Garantizados-Zapatillas-20191216104302.8837240015.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprador`
--

CREATE TABLE `comprador` (
  `idComprador` int(11) NOT NULL,
  `cedula` varchar(50) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `numeroCelular` varchar(50) NOT NULL,
  `correoElectronico` varchar(50) NOT NULL,
  `estado` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `comprador`
--

INSERT INTO `comprador` (`idComprador`, `cedula`, `nombres`, `apellidos`, `username`, `password`, `direccion`, `numeroCelular`, `correoElectronico`, `estado`) VALUES
(1, '1223465', 'Jose', 'Antonio', 'comp', 'comp', 'av 25#59-56', '+5731666656', 'contacto@gmail.com', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

CREATE TABLE `compras` (
  `idCompras` int(11) NOT NULL,
  `fechaCompras` varchar(50) NOT NULL,
  `monto` double NOT NULL,
  `estado` varchar(11) NOT NULL,
  `idPago` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_compras`
--

CREATE TABLE `detalle_compras` (
  `idDetalle` int(11) NOT NULL,
  `cantidad` int(50) NOT NULL,
  `precioCompra` double NOT NULL,
  `idCalzado` int(11) NOT NULL,
  `idCompras` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `idEmpleado` int(11) NOT NULL,
  `cedula` varchar(50) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `numeroCelular` varchar(50) NOT NULL,
  `correoElectronico` varchar(50) NOT NULL,
  `estado` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`idEmpleado`, `cedula`, `nombres`, `apellidos`, `username`, `password`, `direccion`, `numeroCelular`, `correoElectronico`, `estado`) VALUES
(1, '1223465', 'Jose', 'Antonio', 'emp', 'emp', 'av 25#59-56', '+5731666656', 'contacto@gmail.com', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `empresa` (
  `idEmpresa` int(11) NOT NULL,
  `rut` int(11) NOT NULL,
  `saludo` text NOT NULL,
  `nosotros` varchar(100) NOT NULL,
  `ofrecemos` text NOT NULL,
  `porque_elegirnos` text NOT NULL,
  `nuestros_clientes` text NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefonos` varchar(50) NOT NULL,
  `correoElectronico` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`idEmpresa`, `rut`, `saludo`, `nosotros`, `ofrecemos`, `porque_elegirnos`, `nuestros_clientes`, `direccion`, `telefonos`, `correoElectronico`) VALUES
(1, 60363249, 'Bienvenido a tu tienda virtual favorita', 'Somos una empresa donde se labora con eficiencia y eficacia en la administración y fabricación de nu', 'calzado formal, colegial y deportivo para hombre y mujer desde hace 5 años.', 'Elegirnos por nuestra eficiencia en la elaboración de nuestros productos y buena calidad en productos.', 'Jose: Es feliz con nuestro calzado deportivo', 'Avenida 22 #2487 Barrio San Jose', '+57315565456 +5735554560', 'Caysam@gmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `idPago` int(11) NOT NULL,
  `monto` double NOT NULL,
  `estado` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `calzado`
--
ALTER TABLE `calzado`
  ADD PRIMARY KEY (`idCalzado`);

--
-- Indices de la tabla `comprador`
--
ALTER TABLE `comprador`
  ADD PRIMARY KEY (`idComprador`);

--
-- Indices de la tabla `compras`
--
ALTER TABLE `compras`
  ADD PRIMARY KEY (`idCompras`),
  ADD KEY `idPago_Fk` (`idPago`),
  ADD KEY `idCliente_Fk` (`idCliente`);

--
-- Indices de la tabla `detalle_compras`
--
ALTER TABLE `detalle_compras`
  ADD PRIMARY KEY (`idDetalle`),
  ADD KEY `Calzado_Fk` (`idCalzado`),
  ADD KEY `Compra_Fk` (`idCompras`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`idEmpleado`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`idEmpresa`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`idPago`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `calzado`
--
ALTER TABLE `calzado`
  MODIFY `idCalzado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `compras`
--
ALTER TABLE `compras`
  MODIFY `idCompras` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalle_compras`
--
ALTER TABLE `detalle_compras`
  MODIFY `idDetalle` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `idEmpleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `pago`
--
ALTER TABLE `pago`
  MODIFY `idPago` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `idCliente_Fk` FOREIGN KEY (`idCliente`) REFERENCES `comprador` (`idComprador`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `idPago_Fk` FOREIGN KEY (`idPago`) REFERENCES `pago` (`idPago`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `detalle_compras`
--
ALTER TABLE `detalle_compras`
  ADD CONSTRAINT `Calzado_Fk` FOREIGN KEY (`idCalzado`) REFERENCES `calzado` (`idCalzado`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Compra_Fk` FOREIGN KEY (`idCompras`) REFERENCES `compras` (`idCompras`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
