DROP PROCEDURE IF EXISTS CURUltimosPedidos; 
DELIMITER $$
CREATE PROCEDURE CURUltimosPedidos()
BEGIN
	DECLARE idPedido INT;
	DECLARE	idSabor INT;
	DECLARE	quantidadeProducao INT;
	DECLARE	idFuncionario INT;

	DECLARE curs_UltimosPedidos
    CURSOR FOR SELECT idPedido, idSabor, quantidadeProducao, idFuncionario
	FROM tribos_kombucha.Pedido;

	OPEN curs_UltimosPedidos;

	FETCH NEXT FROM curs_UltimosPedidos
	INTO idPedido, idSabor, quantidadeProducao, idFuncionario;

	SELECT idPedido, idSabor, quantidadeProducao, idFuncionario;

	CLOSE curs_UltimosPedidos;

END $$
DELIMITER ;

CALL CURUltimosPedidos();
