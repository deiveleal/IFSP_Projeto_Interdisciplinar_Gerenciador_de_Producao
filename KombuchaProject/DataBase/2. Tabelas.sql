-- TABELAS
CREATE TABLE Estoque 
(
    idItem INT PRIMARY KEY,
    flagItem INT NOT NULL,
    nomeItem VARCHAR(20) NOT NULL,
    quantItem DOUBLE
);

CREATE TABLE Funcionario
(
    idFuncionario INT PRIMARY KEY,
    nomeFuncionario CHAR(60) NOT NULL,
    cargo VARCHAR(40)
);

CREATE TABLE FlagItem
(
    flagItem INT PRIMARY KEY,
    tipoItem CHAR(20) NOT NULL
);

CREATE TABLE Insumo
(
    idInsumo INT PRIMARY KEY,
    nomeInsumo VARCHAR (20),
    quantidadeInsumo DOUBLE,     
    flagItem INT,

    FOREIGN KEY (flagItem) references FlagItem (flagItem)
);

CREATE TABLE Fermentador
(
    idFermentador INT PRIMARY KEY,
    estadoProducao BOOL,
    volume DOUBLE,
    flagItem INT,

    FOREIGN KEY (flagItem) references FlagItem (flagItem)
);

CREATE TABLE Pedido
(
    idPedido INTEGER NOT NULL,
    quantidadeProducao INT,
    idFermentador INT NOT NULL,
    idFuncionario INT,
    
    FOREIGN KEY (idFermentador) REFERENCES Fermentador(idFermentador),
    FOREIGN KEY (idFuncionario ) references Funcionario(idFuncionario)
);



CREATE TABLE EmbalagemKombucha 
(
    idEmbalagem INT PRIMARY KEY,
    corEmbalagem VARCHAR(20),
    nomeEmbalagem VARCHAR(20),
    flagItem INT NOT NULL,

    FOREIGN KEY (flagItem) references FlagItem (flagItem)
);

CREATE TABLE Lote 
(
    idLote INT PRIMARY KEY,
    idFuncionario INT NOT NULL,
    idEmbalagem INT NOT NULL,
	dataLote DATE NOT NULL,
	perdaLote DOUBLE NOT NULL, 
	quantidadeLote INT NOT NULL,

FOREIGN KEY (idEmbalagem ) references EmbalagemKombucha (idEmbalagem)
);

CREATE TABLE SaborKombucha 
(
    idKombucha  INT PRIMARY KEY,
    nomeKombucha VARCHAR(20) NOT NULL,
    chaBase VARCHAR(20) NOT NULL,
    idChaBase INT,
    prePreparoQuantCha DOUBLE NOT NULL,
	prePreparoQuantAgua DOUBLE NOT NULL,
    idEmbalagem INT,

    FOREIGN KEY (idEmbalagem) references EmbalagemKombucha (idEmbalagem),
    FOREIGN KEY (idChaBase) references Insumo(idInsumo)   
);

CREATE TABLE KombuchaPronto
(
    idKombuchaPronto INT,
	nomeProduto VARCHAR (20),

FOREIGN KEY (idKombuchaPronto) references SaborKombucha (idKombucha)
);
