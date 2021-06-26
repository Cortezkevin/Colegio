CREATE PROCEDURE sp_ManListarBimestre()
SELECT b.idBimestre, b.nombre from bimestre b;

DELIMITER $$
CREATE  PROCEDURE sp_MantRegistrarBimestre(IN idbimestre char(4))
BEGIN
	SET @idbimestre = (SELECT CONCAT('B',RIGHT(CONCAT('00',RIGHT(MAX(idBimestre),3) + 1),3)) FROM bimestre);	
	INSERT INTO grado (idBimestre, nombre, estado) VALUES (@idgrado,@nombre,'Activo');
END$$
 DELIMITER ;

DELIMITER $$
CREATE  PROCEDURE sp_MantActualizarBimestre(IN _idbimestre CHAR(4))
BEGIN
	UPDATE grado SET nombre = _nombre, estado = _estado WHERE idBimestre= _idbimestre;
END$$
 DELIMITER ;


DELIMITER $$
CREATE  PROCEDURE sp_MantEliminarBimestre(IN _idbimestre CHAR(4))
BEGIN
	UPDATE bimestre SET estado = "Eliminado" WHERE idBimestre = _idbimestre; 
END$$
 DELIMITER ;

