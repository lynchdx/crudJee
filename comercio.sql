/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : comercio

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-11-26 20:32:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for productos
-- ----------------------------
DROP TABLE IF EXISTS `productos`;
CREATE TABLE `productos` (
  `id_producto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` varchar(1000) NOT NULL,
  `precio` int(11) NOT NULL,
  `categoria` varchar(20) NOT NULL,
  `detalles` varchar(500) NOT NULL,
  `reviews` varchar(1000) NOT NULL,
  `size` int(11) NOT NULL,
  `color` varchar(20) NOT NULL,
  `imagen_1` varchar(100) NOT NULL,
  `imagen_2` varchar(100) NOT NULL,
  `imagen_3` varchar(100) NOT NULL,
  `imagen_4` varchar(100) NOT NULL,
  `imagen_5` varchar(100) NOT NULL,
  PRIMARY KEY (`id_producto`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Procedure structure for deleteProducto
-- ----------------------------
DROP PROCEDURE IF EXISTS `deleteProducto`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteProducto`(
	in _id_producto int
)
begin
	delete from productos where id_producto = _id_producto;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for insertProducto
-- ----------------------------
DROP PROCEDURE IF EXISTS `insertProducto`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `insertProducto`(
	in _nombre varchar(100),
		_descripcion varchar(1000),
		_precio int,
		_categoria varchar(20),
		_detalles varchar(500),
		_reviews varchar(1000),
		_size int,
		_color varchar(20),
		_imagen_1 varchar(100),
		_imagen_2 varchar(100),
		_imagen_3 varchar(100),
		_imagen_4 varchar(100),
		_imagen_5 varchar(100)
)
begin
insert into productos(nombre, descripcion, precio, categoria, detalles, reviews, size, color, imagen_1, imagen_2, imagen_3, imagen_4, imagen_5)values(_nombre, _descripcion, _precio, _categoria, _detalles, _reviews, _size, _color, _imagen_1, _imagen_2, _imagen_3, _imagen_4, _imagen_5);
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for selectAllProductos
-- ----------------------------
DROP PROCEDURE IF EXISTS `selectAllProductos`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `selectAllProductos`()
begin
select * from productos;
end
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for updateProducto
-- ----------------------------
DROP PROCEDURE IF EXISTS `updateProducto`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateProducto`(
in  _id_producto int,
		_nombre varchar(100),
		_descripcion varchar(1000),
		_precio int,
		_categoria varchar(20),
		_detalles varchar(500),
		_reviews varchar(1000)
)
begin
	update productos set nombre = _nombre, descripcion = _descripcion, precio = _precio, categoria = _categoria, 
	detalles = _detalles, reviews = _reviews where id_producto = _id_producto;
end
;;
DELIMITER ;
