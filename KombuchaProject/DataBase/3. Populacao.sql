-- POPULAÇÃO

-- Funcionário 
INSERT INTO Funcionario (        idFuncionario, 
nomeFuncionario,
cargo)
VALUES
(1, "Daniel", "Proprietário"),
(2, "Deive", "Funcionário"),
(3, "Eder", "Proprietário");

-- FlagItem
INSERT INTO FlagItem(        flagItem,
                    tipoItem)
VALUES
(1, "Insumo"),
(2, "Fermentador"),
(3, "Embalagem"),
(4, "Kombucha Pronto");

-- EmbalagemKombucha
INSERT INTO EmbalagemKombucha(idEmbalagem,
                            corEmbalagem,
                            nomeEmbalagem,
                            flagItem)
VALUES
(1, 'Branco', 'Embalagem Anis', 3),
(2, 'Amarelo', 'Embalagem Abacaxi', 3),
(3, 'Verde', 'Embalagem Hibisco', 3),
(4, 'Laranja', 'Embalagem Gengibre', 3);

-- Insumo
INSERT INTO  Insumo(        idInsumo ,
                    nomeInsumo,
                    quantidadeInsumo,     
                    flagItem)
VALUES
-- (1, "Chá de Anis", 3, 1),
(2, "Chá de Gengibre", 2, 1),
(3, "Chá de Hibisco", 4, 1),
(4, "Chá de Abacaxi", 1,1);

-- SaborKombucha
INSERT INTO  SaborKombucha (    idKombucha,
                    nomeKombucha,
                    chaBase,
                    idChaBase,
                    prePreparoQuantCha,
prePreparoQuantAgua,
                    idEmbalagem)
VALUES
(1, 'Anis-Estrelado', 'Anis', 1, 1.2, 1.7, 1),
(2, 'Hibisco com Uva', 'Hibisco-Uva', 2, 2.3, 1.9, 2),
(3, 'Abacaxi com Hortelã', 'Abacaxi-Hortelã', 3, 1.2, 2.6, 3),
(4, 'Capim Santo', 'Capim-Gengibre-Limão', 4, 2.5, 1.3, 4); 


-- Fermentador
INSERT INTO Fermentador (	idFermentador,
							estadoProducao,
							volume,
							flagItem)
VALUES
(1, TRUE, 3.00, 3),
(2, FALSE, 2.00, 3),
(3, TRUE, 5.00, 4),
(4, FALSE, 1.50, 2);

SELECT * FROM Fermentador