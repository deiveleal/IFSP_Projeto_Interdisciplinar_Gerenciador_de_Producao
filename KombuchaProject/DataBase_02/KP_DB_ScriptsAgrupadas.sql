-- SCRIPTS AGRUPADOS
CREATE SCHEMA tribos_kombucha;
USE  tribos_kombucha;

-- Criação das tabelas

CREATE TABLE Funcionario(
	idFuncionario VARCHAR(11) PRIMARY KEY,
    nomeFuncionario CHAR(100) NOT NULL,
    cargo VARCHAR(40),
    senha VARCHAR(20)
);

CREATE TABLE ItemDeEstoque (
	idItem INT PRIMARY KEY,
    tipoItem VARCHAR(50) NOT NULL
);

CREATE TABLE Estoque(
	idItem INT,
	idItemEstoque INT,
    nomeItem VARCHAR(50),
    quantItem DOUBLE,
    
    FOREIGN KEY (idItemEstoque) references ItemDeEstoque(idItem),
    PRIMARY KEY(idItem , idItemEstoque)
);

CREATE TABLE Insumo(
    idInsumo INT PRIMARY KEY,
    idItemEstoque INT,
    nomeInsumo VARCHAR (50),
	descInsumo VARCHAR (100),
    
    FOREIGN KEY (idItemEstoque) references ItemDeEstoque(idItem)
);

CREATE TABLE Fermentador(
    idFermentador INT PRIMARY KEY,
    idItemEstoque INT,
    estadoProducao BOOL,
    volume DOUBLE,
    
    FOREIGN KEY (idItemEstoque) references ItemDeEstoque(idItem)
);


CREATE TABLE EmbalagemKombucha(
    idEmbalagem INT PRIMARY KEY,
    idItemEstoque INT,
    corEmbalagem VARCHAR(50),
    nomeEmbalagem VARCHAR(50),
    
    FOREIGN KEY (idItemEstoque) references ItemDeEstoque(idItem)
);

CREATE TABLE SaborKombucha(
    idKombucha  INT AUTO_INCREMENT PRIMARY KEY,
    nomeKombucha VARCHAR(100) NOT NULL,
    chaBase VARCHAR(100) NOT NULL,
    idChaBase INT,
    prePreparoQuantCha DOUBLE NOT NULL,
	prePreparoQuantAgua DOUBLE NOT NULL,
    quantidadeAcucar DOUBLE NOT NULL,
    idEmbalagem INT,

    FOREIGN KEY (idEmbalagem) references EmbalagemKombucha (idEmbalagem),
    FOREIGN KEY (idChaBase) references Insumo(idInsumo)
);

CREATE TABLE Pedido(
    idPedido INT AUTO_INCREMENT PRIMARY KEY,
    idSabor INT,
    nomeSabor VARCHAR(100),
    quantidadeProducao INT,
    idFermentador INT NOT NULL,
    idFermentadorExtra INT,
    idFuncionario VARCHAR(11),
	quantidadeCha  DOUBLE,
	quantidadeAgua  DOUBLE,
    quantidadeAcucar DOUBLE,
    quantidadeEmbalagem  INT,
    dataEntradaPedido DATETIME,
    
    FOREIGN KEY (idSabor) REFERENCES SaborKombucha(idKombucha),
    FOREIGN KEY (idFermentador) REFERENCES Fermentador(idFermentador),
	FOREIGN KEY (idFermentadorExtra) REFERENCES Fermentador(idFermentador),
    FOREIGN KEY (idFuncionario) references Funcionario(idFuncionario)
);


CREATE TABLE KombuchaPronto(
    idKombuchaPronto INT PRIMARY KEY ,
    idItemEstoque INT,
    idSabor INT,
	nomeProduto VARCHAR(50),
    dataFabricacao DATE,

    FOREIGN KEY (idItemEstoque) references ItemDeEstoque(idItem),
    FOREIGN KEY (idSabor) references SaborKombucha (idKombucha)
);

-- População inicial do banco

INSERT INTO Funcionario(
    idFuncionario,
    nomeFuncionario,
    cargo, 
    senha)
VALUES

    (1, 'Daniel', 'Teste', '1111'),
    ('06146045675', 'Deive', 'Dev', '123');

    
INSERT INTO ItemDeEstoque(
    idItem,
    tipoItem)
VALUES
    (1, 'Insumo'),
    (2, 'Embalagem'),
    (3, 'Fermentador'),
    (4, 'Kombucha Pronto');
    

INSERT INTO Insumo(
    idInsumo,
    idItemEstoque,
    nomeInsumo,
    descInsumo)
VALUES
    (1, 1, 'Água', 'Água Mineral'),
    (2, 1, 'Açucar', 'Organico'),
    (3, 1, 'Scoby', 'Colonia para fermentação'),
    (4, 1, 'Extrato de Anis', 20),
	(5, 1, 'Extrato de Abacaxi com Hortelã', 20),
	(6, 1, 'Extrato de Hibisco-Uva', 20),
	(7, 1, 'Extrato de Capim-Santo Gengibre-Limão', 20);
 
 INSERT INTO Fermentador(
	idFermentador,
    idItemEstoque,
    estadoProducao,
    volume)
VALUES
	(0, 3, true, 4),
    (1, 3, false, 4.0),
    (2, 3, false, 4.0),
    (3, 3, false, 4.0),
    (4, 3, false, 4.0),
    (5, 3, false, 4.0),
    (6, 3, false, 4.0),
    (7, 3, false, 4.0),
    (8, 3, false, 4.0);


 INSERT INTO EmbalagemKombucha(
        idEmbalagem,
        idItemEstoque,
		corEmbalagem,
		nomeEmbalagem)
VALUES
	(1, 2, 'Branco', 'Embalagem Anis'),
	(2, 2, 'Amarelo', 'Embalagem Abacaxi'),
    (3, 2, 'Verde', 'Embalagem Hibisco'),
    (4, 2, 'Laranja', 'Embalagem Gengibre');
     
 INSERT INTO Estoque(
    idItem,
	idItemEstoque,
    nomeItem,
    quantItem)
VALUES
        (1, 1, 'Água', 20),
        (2, 1, 'Açucar', 10),
        (3, 1, 'Scoby', 32),
        (4, 1, 'Extrato de Anis', 20),
        (5, 1, 'Extrato de Abacaxi com Hortelã', 20),
        (6, 1, 'Extrato de Hibisco-Uva', 20),
        (7, 1, 'Extrato de Capim-Santo Gengibre-Limão', 20),
        (1, 2, 'Embalagem Anis', 32),
        (2, 2, 'Embalagem Abacaxi', 32),
        (3, 2, 'Embalagem Hibisco', 32),
        (4, 2, 'Embalagem Gengibre', 32),
        (1, 4, 'Kombucha Pronto Anis', 48),
        (2, 4, 'Kombucha Pronto Abacaxi', 48),
        (3, 4, 'Kombucha Pronto Hibisco', 48),
        (4, 4, 'Kombucha Pronto Gengibre', 48);

 INSERT INTO SaborKombucha(
    idKombucha,
	nomeKombucha,
    chaBase,
    idChaBase,
    prePreparoQuantCha,
    prePreparoQuantAgua,
    quantidadeAcucar,
    idEmbalagem)
VALUES
        (1, 'Anis', 'Extrato de Anis', 4, 0.025, 0.3, 0.045, 1),
        (2, 'Abacaxi com Hortelã', 'Extrato de Abacaxi com Hortelã', 5, 0.025, 0.3, 0.045, 1),
        (3, 'Hibisco-Uva', 'Extrato de Hibisco-Uva', 6, 0.025, 0.3, 0.045, 1),
        (4, 'Capim-Santo Gengibre-Limão', 'Extrato de Capim-Santo Gengibre-Limão', 7, 0.025, 0.3, 0.045, 1);
        
        



INSERT INTO Pedido( idSabor, 
					nomeSabor,
                    quantidadeProducao, 
                    idFermentador,
                    idFermentadorExtra,
                    idFuncionario,
                    quantidadeCha,
                    quantidadeAgua,
                    quantidadeAcucar,
                    quantidadeEmbalagem,
                    dataEntradaPedido)
	VALUES ( 1, 'teste', 1, 0, NULL, 1, 1, 1, 1, 1, NOW());
    
-- Criação de Usuarios e Controle de Acesso

CREATE USER IF NOT EXISTS 'desenvolvedor'@'localhost'
	IDENTIFIED BY 'dev12345'
	PASSWORD EXPIRE INTERVAL 90 DAY;
    
CREATE USER IF NOT EXISTS 'admdb'@'localhost'
	IDENTIFIED BY 'mandb123'
    PASSWORD EXPIRE INTERVAL 365 DAY;
    
CREATE USER IF NOT EXISTS 'userdb'@'localhost'
	IDENTIFIED BY 'user1234'
    PASSWORD EXPIRE INTERVAL 365 DAY;
    
GRANT ALTER, DELETE, INSERT, SELECT, UPDATE
	ON tribos_kombucha.*
    TO 'desenvolvedor'@'localhost' WITH GRANT OPTION;
    
GRANT ALL
	ON tribos_kombucha.*
    TO 'admdb'@'localhost' WITH GRANT OPTION;
    
GRANT DELETE, INSERT, SELECT, UPDATE
	ON tribos_kombucha.*
    TO 'userdb'@'localhost';
    
FLUSH PRIVILEGES;
    
-- Função de Agregação
DROP PROCEDURE IF EXISTS NumeroPedidoPorData;
DELIMITER $$
CREATE PROCEDURE NumeroPedidoPorData(IN dataDeEntradaIN DATE)
BEGIN
    SELECT count(idPedido) AS 'Total de Pedidos' FROM Pedido
        WHERE date(dataEntradaPedido) LIKE dataDeEntradaIN;
END
$$
DELIMITER ;

 
 -- SUB PROCEDURES MONTAGEM DE PEDIDOS
 
 -- Monta chá para pedido
DROP FUNCTION IF EXISTS montagemCha;
DELIMITER $$
CREATE FUNCTION montagemCha (idKombuchaIN INT, qtdPedido INT)
RETURNS DOUBLE DETERMINISTIC
BEGIN
	DECLARE prePreparoQuantCha_aux DOUBLE;
    DECLARE quantidadeDeProducao DOUBLE;
	SELECT prePreparoQuantCha INTO prePreparoQuantCha_aux FROM tribos_kombucha.SaborKombucha 
		WHERE idKombucha = idKombuchaIN;
        SET quantidadeDeProducao = prePreparoQuantCha_aux * qtdPedido;

RETURN quantidadeDeProducao;
END;
$$
DELIMITER ;

-- Monta água para pedido
DROP FUNCTION IF EXISTS montagemAgua;
DELIMITER $$
CREATE FUNCTION montagemAgua (idKombuchaIN INT, qtdPedido INT)
RETURNS DOUBLE DETERMINISTIC
BEGIN
	DECLARE prePreparoQuantAgua_aux DOUBLE;
    DECLARE quantidadeDeProducao DOUBLE;
	SELECT prePreparoQuantAgua INTO prePreparoQuantAgua_aux FROM tribos_kombucha.SaborKombucha 
		WHERE idKombucha = idKombuchaIN;
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

-- Monta quantidade de acucar por pedido
DROP FUNCTION IF EXISTS montagemAcucar;
DELIMITER $$
CREATE FUNCTION montagemAcucar (idKombuchaIN INT, qtdPedido INT)
RETURNS DOUBLE DETERMINISTIC
BEGIN
	DECLARE quantAcucar_aux DOUBLE;
    DECLARE acucarReceita_aux DOUBLE;
    
    SELECT quantidadeAcucar INTO acucarReceita_aux FROM SaborKombucha
		WHERE idKombucha = idKombuchaIN;

    SET quantAcucar_aux = acucarReceita_aux * qtdPedido;
	
RETURN quantAcucar_aux;
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

-- 

DROP PROCEDURE IF EXISTS alteraEstadoFermentador;
DELIMITER $$
	CREATE PROCEDURE alteraEstadoFermentador (IN idFermentador_aux INT)
	BEGIN 
        UPDATE fermentador SET estadoProducao = 1 WHERE idFermentador = idFermentador_aux ;
	END;
$$
DELIMITER ;

-- 

DROP PROCEDURE IF EXISTS reposicaoEstoque;
DELIMITER $$
CREATE PROCEDURE reposicaoEstoque(IN idItemIN INT, IN idItemEstoqueIN INT, IN quantIncrementoIN DOUBLE) 
    BEGIN
		DECLARE quantItem_aux DOUBLE;
        
		SELECT quantItem INTO quantItem_aux FROM Estoque
			WHERE idItem = idItemIN AND idItemEstoque = idItemEstoqueIN;
            
		IF quantItem_aux IS NULL THEN
			UPDATE Estoque SET quantItem = 0
				WHERE idItem = idItemIN AND idItemEstoque = idItemEstoqueIN;
        END IF;
		
        UPDATE Estoque SET quantItem = quantItem + quantIncrementoIN
			WHERE idItem = idItemIN AND idItemEstoque = idItemEstoqueIN;
        
    END
$$
DELIMITER ;


DROP PROCEDURE IF EXISTS montaPedidoPreparo;
DELIMITER $$

	CREATE PROCEDURE montaPedidoPreparo (IN idFuncionario VARCHAR(11),
                                         in saborKombuchaIN VARCHAR(52), -- nova entrada
										 IN quantidadeDeProducao DOUBLE)
									 
	BEGIN 
        DECLARE quantidadeDeProducao_aux INT;
        DECLARE idPedido_aux INT;
        DECLARE prePreparoQuantCha_aux DOUBLE;
        DECLARE quantEmEstoqueCha DOUBLE;
        DECLARE prePreparoQuantAgua_aux DOUBLE;
        DECLARE dataEntradaPedido DATETIME;
        DECLARE quantEmbalagem INT;
        DECLARE volumeProducao DOUBLE;
        DECLARE idSabor_aux INT;
        DECLARE nomeSabor_aux VARCHAR(100);
        DECLARE quantidadeAcucar_aux DOUBLE;
        
        
		SELECT idKombucha INTO idSabor_aux FROM SaborKombucha 
			WHERE nomeKombucha = saborKombuchaIN; -- novo select     

		SELECT NOW() INTO dataEntradaPedido;
        
        -- FUNÇÃO DE DECREMENTO DE SKOOBY
	
        SELECT quantidadeDeProducao INTO quantidadeDeProducao_aux;
        SET prePreparoQuantCha_aux = montagemCha(idSabor_aux, quantidadeDeProducao);
                
        SET quantEmbalagem = montagemEmbalagem (idSabor_aux, quantidadeDeProducao);
        
		SET prePreparoQuantAgua_aux = montagemAgua(idSabor_aux, quantidadeDeProducao);
        
        SET quantidadeAcucar_aux = montagemAcucar(idSabor_aux, quantidadeDeProducao);
                
        SET volumeProducao = prePreparoQuantAgua_aux + prePreparoQuantCha_aux;
	
		SELECT idPedido INTO idPedido_aux FROM tribos_kombucha.Pedido
			ORDER BY idPedido DESC LIMIT 1;
		SET idPedido_aux = idPedido_aux + 1;
		
        
        INSERT INTO Pedido( 
							idSabor,
                            nomeSabor,
                            quantidadeProducao,
                            idFermentador,
                            idFuncionario,
                            quantidadeCha,
                            quantidadeAgua,
                            quantidadeAcucar,
                            quantidadeEmbalagem,
                            dataEntradaPedido)
		VALUES(
			idSabor_aux,
            saborKombuchaIN,
            quantidadeDeProducao_aux,
            0,
            idFuncionario,
            prePreparoQuantCha_aux,
            prePreparoQuantAgua_aux,
            quantidadeAcucar_aux,
            quantEmbalagem,
            dataEntradaPedido
			);
            
            CALL escolheFermentador(idPedido_aux, volumeProducao);
            
            -- inserção dos fermentadores no pedido
	END;
$$
DELIMITER ;

/*
-- EXEMPLO TESTE DE INSERÇÃO DE PEDIDO

SET @quantidadeDeProducao = 3;
CALL montaPedidoPreparo('1', 'Anis', @quantidadeDeProducao);

SELECT @quantidadeDeProducao;



SELECT * FROM pedido;
SELECT * FROM fermentador;
*/

-- Procedure dar baixa no estoque
DROP PROCEDURE IF EXISTS darBaixaPedido;
DELIMITER $$
CREATE PROCEDURE darBaixaPedido (IN idPedidoIN INT)
	BEGIN
    DECLARE idSabor_aux INT;
	DECLARE idCha_aux INT;    
    DECLARE idEmbalagem_aux INT; 
    DECLARE quantidadeAcucar_aux DOUBLE;
    DECLARE quantidadeCha_aux DOUBLE;
    DECLARE quantidadeAgua_aux DOUBLE;
    DECLARE quantidadeEmbalagem_aux INT;
    
    
    -- pega idSabor do pedido
    SELECT idSabor INTO idSabor_aux FROM Pedido 
		WHERE idPedido = idPedidoIN;
	-- pega quantidade de chá do pedido
    SELECT quantidadeCha INTO quantidadeCha_aux FROM pedido 
		WHERE idPedido = idPedidoIN;
	-- pega idChaBase do pedido
	SELECT idChaBase INTO idCha_aux FROM SaborKombucha 
		WHERE idKombucha = idSabor_aux;
     -- pega quantidade de agua do pedido   
	SELECT quantidadeAgua INTO quantidadeAgua_aux FROM Pedido
		WHERE idPedido = idPedidoIN;
	-- pega quantidade de embalagem
    SELECT quantidadeEmbalagem INTO quantidadeEmbalagem_aux FROM Pedido
		WHERE idPedido = idPedidoIN;
	SELECT idEmbalagem INTO idEmbalagem_aux FROM SaborKombucha
		WHERE idKombucha = idSabor_aux;
	-- pega quantidade açucar
	SELECT quantidadeAcucar INTO quantidadeAcucar_aux FROM Pedido
		WHERE idPedido = idPedidoIN;
        
	-- retira valores do estoque
	UPDATE Estoque SET quantItem = quantItem - quantidadeCha_aux
		WHERE idItem = idCha_aux AND idItemEstoque = 1;
	UPDATE Estoque SET quantItem = quantItem - quantidadeAgua_aux
		WHERE idItem = 1 AND idItemEstoque = 1;
	UPDATE Estoque SET quantItem = quantItem - quantidadeEmbalagem_aux
		WHERE idItem = idEmbalagem_aux AND idItemEstoque = 2;
	UPDATE Estoque SET quantItem = quantItem - quantidadeAcucar_aux
		WHERE idItem = 2 AND idItemEstoque = 1;
        
    END
$$
DELIMITER ;
/*
SELECT * FROM estoque;
CALL darBaixaPedido (2);
SELECT * FROM PEDIDO;
SELECT * FROM itemdeestoque;
SELECT * FROM estoque;
*/

-- TRIGGER 
DROP TRIGGER IF EXISTS darBaixaEstoque;
DELIMITER $$
CREATE TRIGGER darBaixaEstoque
AFTER INSERT ON pedido
FOR EACH ROW 
    BEGIN
		DECLARE ultimoPedido INT;
        
        SELECT idPedido INTO ultimoPedido FROM pedido
			order by idPedido DESC LIMIT 1;
        
         CALL darBaixaPedido (ultimoPedido);
    END 
$$
DELIMITER ;

-- VIEWS
-- SELECT * FROM saborkombucha

/*
FALTA IMPLEMENTAR:
	- VIEWS
    - BACKUP    
*/