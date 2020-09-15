DROP FUNCTION IF EXISTS contapedidos;
DELIMITER $$
CREATE FUNCTION contapedidos (nomPedido varchar(50))
RETURNS INT DETERMINISTIC
BEGIN
	DECLARE contador INT;
    SELECT COUNT(idPedido)
    INTO contador
    FROM tribos_kombucha.Pedido tkp
    WHERE tkp.idPedido = nomPedido;
    RETURN contador;
END $$ 
DELIMITER ;

DROP TRIGGER IF EXISTS trg_contapedidos_insert;
DELIMITER $$
CREATE TRIGGER trg_contapedidos_insert
AFTER INSERT ON tribos_kombucha.Pedido
FOR EACH ROW
	BEGIN
	CALL contapedidos(Pedido);
	END;
$$ DELIMITER ;

DROP TRIGGER IF EXISTS trg_contapedidos_update;
DELIMITER $$
CREATE TRIGGER trg_contapedidos_update
AFTER UPDATE ON Pedido
FOR EACH ROW
	BEGIN
	CALL contapedidos(tribos_kombucha.Pedido.idPedido);
	END;
$$
DELIMITER ; 

DROP TRIGGER IF EXISTS trg_contapedidos_delete;
DELIMITER $$
CREATE TRIGGER trg_contapedidos_delete
AFTER DELETE ON Pedido
FOR EACH ROW
	BEGIN
	CALL contapedidos(tribos_kombucha.Pedido.idPedido);
	END;
$$ 
DELIMITER ;

DELIMITER $$
CREATE TRIGGER darBaixaEstoque
AFTER INSERT ON pedido
FOR EACH ROW 
    BEGIN
        UPDATE estoque 
        SET quantItem = quantItem - NEW.quantidadeProducao         
WHERE idItem = NEW.idPedido;
        END $$