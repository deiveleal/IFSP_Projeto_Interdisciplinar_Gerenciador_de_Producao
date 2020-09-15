DROP PROCEDURE IF EXISTS NumeroPedidoPorData;
DELIMITER $$
CREATE PROCEDURE NumeroPedidoPorData()
BEGIN
    SELECT count(idPedido) FROM Pedido
        WHERE date(dataEntradaPedido) LIKE '%2020-09-14%';
END
$$
DELIMITER ;

