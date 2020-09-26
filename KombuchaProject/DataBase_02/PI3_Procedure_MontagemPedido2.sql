DROP PROCEDURE IF EXISTS montaPedidoPreparo;
DELIMITER $$
	CREATE PROCEDURE montaPedidoPreparo (IN idFuncionario VARCHAR(100),
										 IN nomeKombucha_aux VARCHAR(50), 
										 IN quantidadeDeProducao DOUBLE)
										 
	BEGIN 
        DECLARE quantidadeDeProducao_aux INT;
        DECLARE idPedido_aux INT;
        DECLARE prePreparoQuantCha_aux DOUBLE;
        -- DECLARE quantEmEstoqueCha DOUBLE; -- NÃO IMPLEMENTADO
        DECLARE prePreparoQuantAgua_aux DOUBLE;
        DECLARE dataEntradaPedido DATETIME;
        DECLARE quantEmbalagem INT;
        DECLARE volumeProducao DOUBLE;
        DECLARE idKombucha_aux INT;
        DECLARE nomeSabor_aux VARCHAR(50);
        
        
        SET nomeKombucha_aux = 'Anis';
        SELECT idKombucha INTO idKombucha_aux FROM SaborKombucha
			WHERE nomeKombucha LIKE nomeKombucha_aux;
            
		SELECT NOW() INTO dataEntradaPedido;
        
        -- FUNÇÃO DE DECREMENTO DE SKOOBY
              
		-- SET idSabor_aux = idKombucha;
        
        SELECT quantidadeDeProducao INTO quantidadeDeProducao_aux;
        SET prePreparoQuantCha_aux = montagemCha(idKombucha_aux, quantidadeDeProducao);
        -- select prePreparoQuantCha_aux;
        
        SET quantEmbalagem = montagemEmbalagem (idKombucha_aux, quantidadeDeProducao);
        
        
        SET prePreparoQuantAgua_aux = montagemAgua(idKombucha_aux, quantidadeDeProducao);
        -- select dataEntradaPedido, prePreparoQuantAgua_aux;
        
        SET volumeProducao = prePreparoQuantAgua_aux + prePreparoQuantCha_aux;
     
		SELECT idPedido INTO idPedido_aux FROM tribos_kombucha.pedido
			ORDER BY idPedido DESC LIMIT 1;
		SET idPedido_aux = idPedido_aux + 1;
		/*
        SELECT nomeKombucha INTO nomeSabor_aux FROM tribos_kombucha.saborkombucha
			WHERE idKombucha = idSabor_aux;
        */
        INSERT INTO pedido( 
							idSabor,
                            nomeSabor,
                            quantidadeProducao,
                            idFermentador,
                            idFuncionario,
                            quantidadeCha,
                            quantidadeAgua,
                            quantidadeEmbalagem,
                            dataEntradaPedido)
		VALUES(
			idKombucha_aux,
            nomeKombucha_aux,
            quantidadeDeProducao_aux,
            0,
            idFuncionario,
            prePreparoQuantCha_aux,
            prePreparoQuantAgua_aux,
            quantEmbalagem,
            dataEntradaPedido
			);
            
            CALL escolheFermentador(idPedido_aux, volumeProducao);
            
            -- inserção dos fermentadores no pedido
	END;
$$
DELIMITER ;
-- select * from saborkombucha;

SET @quantidadeDeProducao = 2;
CALL montaPedidoPreparo('1', 'Anis', @quantidadeDeProducao);
SELECT @quantidadeDeProducao;



SELECT * FROM pedido;
SELECT * FROM fermentador;