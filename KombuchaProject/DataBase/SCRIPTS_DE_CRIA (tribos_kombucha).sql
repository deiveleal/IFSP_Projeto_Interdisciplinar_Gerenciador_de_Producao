-- GRUPO 1 - "Controle de estoque customizado de insumos".
-- por Bianca Viana, Carolina Zanotto e Deive Leal.


CREATE SCHEMA tribos_kombucha;
USE  tribos_kombucha;

-- CRIAÇÃO 

CREATE TABLE Funcionario(
	idFuncionario INT PRIMARY KEY,
	nomeFuncionario CHAR(60) NOT NULL,
	cargo VARCHAR(40)
);

CREATE TABLE ItemDeEstoque (
    idItem INT PRIMARY KEY,
	tipoItem VARCHAR(20) NOT NULL
);

CREATE TABLE Estoque(
    idItem INT,
    idItemEstoque INT,
	nomeItem VARCHAR(20),
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
	corEmbalagem VARCHAR(20),
	nomeEmbalagem VARCHAR(20),
    
	FOREIGN KEY (idItemEstoque) references ItemDeEstoque(idItem)
);

CREATE TABLE SaborKombucha(
	idKombucha  INT PRIMARY KEY,
	nomeKombucha VARCHAR(50) NOT NULL,
	chaBase VARCHAR(50) NOT NULL,
	idChaBase INT,
	prePreparoQuantCha DOUBLE NOT NULL,
    	prePreparoQuantAgua DOUBLE NOT NULL,
	idEmbalagem INT,

	FOREIGN KEY (idEmbalagem) references EmbalagemKombucha (idEmbalagem),
	FOREIGN KEY (idChaBase) references Insumo(idInsumo)
);

CREATE TABLE Pedido(
	idPedido INT PRIMARY KEY,
	idSabor INT,
	quantidadeProducao INT,
	idFermentador INT NOT NULL,
	idFuncionario INT,
	dataEntradaPedido DATETIME,
    quantidadeCha  DOUBLE,
    quantidadeAgua  DOUBLE,
    quantidadeEmbalagem  INT,
    
	FOREIGN KEY (idSabor) REFERENCES SaborKombucha(idKombucha),
	FOREIGN KEY (idFermentador) REFERENCES Fermentador(idFermentador),
	FOREIGN KEY (idFuncionario) references Funcionario(idFuncionario)
);

CREATE TABLE KombuchaPronto(
	idKombuchaPronto INT PRIMARY KEY ,
	idItemEstoque INT,
	idSabor INT,
    nomeProduto VARCHAR(20),
	dataFabricacao DATE,

    FOREIGN KEY (idItemEstoque) references ItemDeEstoque(idItem),
    FOREIGN KEY (idSabor) references SaborKombucha (idKombucha)
);


-- POPULAÇÃO

INSERT INTO Funcionario(
    idFuncionario,
    nomeFuncionario,
    cargo)
VALUES
    (1, 'Daniel', 'Proprietário'),
    (2, 'Deive', 'Funcionário'),
    (3, 'Eder', 'Proprietário');
    
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
    (1, 1, 'Água', ''),
	(2, 1, 'Açucar', 'Organico'),
	(3, 1, 'Scoby', ''),
	(4, 1, 'Chá de Anis', '');
 
 INSERT INTO Fermentador(
    idFermentador,
    idItemEstoque,
	estadoProducao,
	volume)
VALUES
    (1, 3, true, 3.5),
	(2, 3, true, 3.0),
	(3, 3, false, 3.0),
	(4, 3, true, 3.0),
	(5, 3, false, 3.0),
	(6, 3, true, 3.0),
	(7, 3, true, 3.0),
	(8, 3, false, 3.0);
    

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
	idEmbalagem)
VALUES
    (1, 'Anis', 'Chá de Anis', 4, 0.5, 1.1, 1);

