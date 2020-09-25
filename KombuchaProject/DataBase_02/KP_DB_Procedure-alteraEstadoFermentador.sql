DROP PROCEDURE IF EXISTS alteraEstadoFermentador;
DELIMITER $$
	CREATE PROCEDURE alteraEstadoFermentador (IN idFermentador_aux INT)
	BEGIN 
        UPDATE fermentador SET estadoProducao = 1 WHERE idFermentador = idFermentador_aux ;
	END;
$$
DELIMITER ;

SELECT * FROM FERMENTADOR;

CALL alteraEstadoFermentador (8);