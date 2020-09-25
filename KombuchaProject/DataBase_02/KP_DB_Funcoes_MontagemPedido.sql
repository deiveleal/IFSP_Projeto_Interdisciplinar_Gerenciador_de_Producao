-- Monta chá para pedido
DROP FUNCTION IF EXISTS montagemCha;
DELIMITER $$
CREATE FUNCTION montagemCha (idKombucha INT, qtdPedido INT)
RETURNS DOUBLE DETERMINISTIC
BEGIN
	DECLARE prePreparoQuantCha_aux DOUBLE;
    DECLARE quantidadeDeProducao DOUBLE;
	SELECT prePreparoQuantCha INTO prePreparoQuantCha_aux FROM tribos_kombucha.SaborKombucha WHERE idKombucha = idKombucha;
        SET quantidadeDeProducao = prePreparoQuantCha_aux * qtdPedido;

RETURN quantidadeDeProducao;
END;
$$
DELIMITER ;

-- Monta água para pedido
DROP FUNCTION IF EXISTS montagemAgua;
DELIMITER $$
CREATE FUNCTION montagemAgua (idKombucha INT, qtdPedido INT)
RETURNS DOUBLE DETERMINISTIC
BEGIN
	DECLARE prePreparoQuantAgua_aux DOUBLE;
    DECLARE quantidadeDeProducao DOUBLE;
	SELECT prePreparoQuantAgua INTO prePreparoQuantAgua_aux FROM tribos_kombucha.SaborKombucha WHERE idKombucha = idKombucha;
        SET quantidadeDeProducao = prePreparoQuantAgua_aux * qtdPedido;

RETURN quantidadeDeProducao;
END;
$$
DELIMITER ;
/* 
SELECT prePreparoQuantCha INTO prePreparoQuantCha_aux FROM tribos_kombucha.SaborKombucha WHERE idKombucha = idKombucha;
        SET quantidadeDeProducao = prePreparoQuantCha_aux * quantidadeDeProducao;
*/

-- Monta numero de embalagens para pedido
DROP FUNCTION IF EXISTS montagemEmbalagem;
DELIMITER $$
CREATE FUNCTION montagemEmbalagem (idKombucha INT, qtdPedido INT)
RETURNS DOUBLE DETERMINISTIC
BEGIN
	DECLARE quantEmbalagem_aux INT;

    SET quantEmbalagem_aux = 1 * qtdPedido;
	
RETURN quantEmbalagem_aux;
END;
$$
DELIMITER ;



-- Seta fermentador para pedido
DROP PROCEDURE IF EXISTS escolheFermentador;
DELIMITER $$
CREATE PROCEDURE escolheFermentador (idPedido_aux INT, volumeProducao DOUBLE)
BEGIN
	DECLARE estadoProducao_aux BOOL;
	DECLARE idFermentador_aux INT;
    DECLARE idFermentador_aux2 INT;
    DECLARE volumeProducao_aux DOUBLE;
	
    IF volumeProducao <= 4.0 THEN
 
      SELECT idFermentador INTO idFermentador_aux FROM tribos_kombucha.fermentador
		WHERE estadoProducao = 0
        ORDER BY idFermentador LIMIT 1;
		CALL alteraEstadoFermentador(idFermentador_aux);
        UPDATE pedido SET idFermentador = idFermentador_aux WHERE idPedido = idPedido_aux;
        /*
        INSERT INTO pedido(idFermentador) 
				VALUES(idFermentador_aux)
                WHERE idPedido = idPedido_aux;
        */
   ELSEIF volumeProducao > 4.0 AND volumeProducao < 8.0 THEN
		-- SET volumeProducao_aux = volumeProducao - 4;
		SELECT idFermentador INTO idFermentador_aux FROM tribos_kombucha.fermentador
			WHERE estadoProducao = 0
            ORDER BY idFermentador LIMIT 1;
            CALL alteraEstadoFermentador(idFermentador_aux);
            UPDATE pedido SET idFermentador = idFermentador_aux WHERE idPedido = idPedido_aux;
            /*
            INSERT INTO pedido( idFermentador)
				VALUES(idFermentador_aux);
             */   
		SELECT idFermentador INTO idFermentador_aux2 FROM tribos_kombucha.fermentador
			WHERE estadoProducao = 0
            ORDER BY idFermentador LIMIT 1;
            CALL alteraEstadoFermentador(idFermentador_aux2);
            UPDATE pedido SET idFermentadorExtra = idFermentador_aux2 WHERE idPedido = idPedido_aux;
            /*
            INSERT INTO pedido( idFermentador, idFermentadorExtra)
				VALUES(idFermentador_aux, idFermentador_aux2);
			*/
	END IF;
   
END;
$$
DELIMITER ;