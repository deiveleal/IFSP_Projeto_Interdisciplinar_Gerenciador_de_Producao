DROP PROCEDURE IF EXISTS montaPedidoPreparo;
DELIMITER $$
	CREATE PROCEDURE montaPedidoPreparo (
										 IN idKombucha INT, 
										 INOUT quantidadeDeProducao DOUBLE)
										 -- IN idChaBase INT, 
										 -- IN prePreparoQuantCha DOUBLE,
                                         -- IN prePreparoQuantAgua DOUBLE,
                                         -- IN idEmbalagem INT)
	BEGIN 
		-- DECLARE idChaBase_aux INT;
        DECLARE idPedido_aux INT;
        DECLARE prePreparoQuantCha_aux DOUBLE;
        DECLARE quantEmEstoqueCha DOUBLE;
        DECLARE  prePreparoQuantAgua_aux DOUBLE;
        DECLARE dataEntradaPedido DATETIME;
        
		SELECT NOW() INTO dataEntradaPedido;
        
        SET prePreparoQuantCha_aux = montagemCha(idKombucha, quantidadeDeProducao);
        -- select prePreparoQuantCha_aux;
        
        SET prePreparoQuantAgua_aux = montagemAgua(idKombucha, quantidadeDeProducao);
        select dataEntradaPedido, prePreparoQuantAgua_aux;
        
        SELECT idPedido INTO idPedido_aux FROM tribos_kombucha.pedido
			ORDER BY idPedido DESC LIMIT 1;
		
        SET idPedido_aux = idPedido_aux + 1;
        
        INSERT INTO pedido( idPedido,
							idSabor,
                            quantidadeProducao,
                            idFermentador,
                            idFuncionario,
                            quantidadeCha,
                            quantidadeAgua,
                            dataEntradaPedido)
		VALUES(
			idPedido_aux,
            idSabor,
            quantidadeDeProducao,
            1,
            1,
            prePreparoQuantCha_aux,
            prePreparoQuantAgua_aux,
            dataEntradaPedido
			);
	END;
$$
DELIMITER ;