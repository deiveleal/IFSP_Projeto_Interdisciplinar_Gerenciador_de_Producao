-- População inicial do banco

INSERT INTO Funcionario(
    idFuncionario,
    nomeFuncionario,
    cargo, 
    senha)
VALUES
    (1, 'Daniel', 'Teste', '1111');
    
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
    (4, 1, 'Chá de Anis', 'Chá de Anis');
 
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
        (1, 'Anis', 'Chá de Anis', 4, 0.025, 0.3, 0.045, 1);
        
 INSERT INTO Estoque(
    idItem,
	idItemEstoque,
    nomeItem,
    quantItem)
VALUES
        (1, 1, 'Água', 20),
        (2, 1, 'Açucar', 10),
        (3, 1, 'Scoby', 32),
        (4, 1, 'Chá de Anis', 2),
        (1, 2, 'Embalagem Anis', 32),
        (2, 2, 'Embalagem Abacaxi', 32),
        (3, 2, 'Embalagem Hibisco', 32),
        (4, 2, 'Embalagem Gengibre', 32),
        (1, 4, 'Kombucha Pronto Anis', 8),
        (2, 4, 'Kombucha Pronto Abacaxi', 8),
        (3, 4, 'Kombucha Pronto Hibisco', 8),
        (4, 4, 'Kombucha Pronto Gengibre', 8);
        
        
INSERT INTO pedido( 
					idSabor, 
                    quantidadeProducao, 
                    idFermentador,
                    idFermentadorExtra,
                    idFuncionario,
                    quantidadeCha,
                    quantidadeAgua,
                    quantidadeEmbalagem,
                    dataEntradaPedido)
	VALUES ( 1, 1, 0, NULL, 1, 1, 1, 1, NOW());
 