-- CREATE SCHEMA tribos_kombucha;
USE  tribos_kombucha;

-- Criação das tabelas

CREATE TABLE Funcionario(
	idFuncionario VARCHAR (15) PRIMARY KEY,
    nomeFuncionario CHAR(60) NOT NULL,
    cargo VARCHAR(40),
    senha VARCHAR(20)
);

CREATE TABLE ItemDeEstoque (
	idItem INT PRIMARY KEY,
    tipoItem VARCHAR(20) NOT NULL
);

CREATE TABLE Estoque(
	idItem INT,
	idItemEstoque INT,
    nomeItem VARCHAR(60),
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
    quantidadeAcucar DOUBLE NOT NULL,
    idEmbalagem INT,

    FOREIGN KEY (idEmbalagem) references EmbalagemKombucha (idEmbalagem),
    FOREIGN KEY (idChaBase) references Insumo(idInsumo)
);

CREATE TABLE Pedido(
    idPedido INT PRIMARY KEY,
    idSabor INT,
    quantidadeProducao INT,
    idFermentador INT NOT NULL,
    idFuncionario VARCHAR (15),
	quantidadeCha  DOUBLE,
	quantidadeAgua  DOUBLE,
    quantidadeEmbalagem  INT,
    dataEntradaPedido DATETIME,
    
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
