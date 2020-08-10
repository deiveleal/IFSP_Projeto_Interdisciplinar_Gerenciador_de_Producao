#CREATE SCHEMA BD_CENTRO_POPI;
USE BD_CENTRO_POPI;

CREATE TABLE SERVICO
(
    ID_SERVICO INT AUTO_INCREMENT,
    NOME_DO_SERVICO VARCHAR(60) NOT NULL,
    ENDERECO VARCHAR(60),
    TELEFONE VARCHAR(15),
    E_MAIL_DE_CONTATO VARCHAR(40),

    PRIMARY KEY (ID_SERVICO)
);

CREATE TABLE ATENDIMENTO
(
    ID_ATENDIMENTO INT AUTO_INCREMENT,
    ID_USUARIO INT NOT NULL,
    ID_FUNCIONARIO INT NOT NULL,
    DATA_ATENDIMENTO DATE NOT NULL,
    COMENTARIOS VARCHAR(500),

    PRIMARY KEY (ID_ATENDIMENTO)
);

CREATE TABLE FUNCIONARIOS(
	ID_FUNCIONARIO INT AUTO_INCREMENT,
	MATRICULA INT NOT NULL,
	NOME VARCHAR(50) NOT NULL,
	CARGO VARCHAR(50),
	CONTATO_TELEFONE VARCHAR(15),
	E_MAIL VARCHAR(70),
    ID_SERVICO INT,
    
    PRIMARY KEY (ID_FUNCIONARIO),
	FOREIGN KEY SERVICO_ALOCADO_FK(ID_SERVICO)
    REFERENCES SERVICO(ID_SERVICO)
);

CREATE TABLE USUARIOS(
	ID_USUARIO INT AUTO_INCREMENT,
	PRONTUARIO INT UNIQUE,

	NOME VARCHAR(50) NOT NULL,
	NOMESOCIAL VARCHAR(50),
	APELIDO VARCHAR (20),
	NOMEMAE VARCHAR(50),
	NOMEPAI VARCHAR(50),
	DATANASCIMENTO DATE,
	CPF NUMERIC(11),
	NIS NUMERIC(15),
	RG VARCHAR(15),
	ID_SERVICO INT,
    ID_FUNCIONARIO INT,
    
    PRIMARY KEY (ID_USUARIO),
    FOREIGN KEY TECNICO_RESPONSAVEL_FK (ID_FUNCIONARIO)
    REFERENCES FUNCIONARIOS(ID_FUNCIONARIO),
	FOREIGN KEY SERVICO_VINCULADO_FK(ID_SERVICO)
    REFERENCES SERVICO(ID_SERVICO)
);

ALTER TABLE ATENDIMENTO
    ADD FOREIGN KEY ID_FUNCIONARIO_FK (ID_FUNCIONARIO)
    REFERENCES FUNCIONARIOS(ID_FUNCIONARIO);
ALTER TABLE ATENDIMENTO
    ADD FOREIGN KEY ID_USUARIO_FK (ID_USUARIO)
    REFERENCES USUARIOS(ID_USUARIO);

INSERT INTO SERVICO (NOME_DO_SERVICO, TELEFONE, E_MAIL_DE_CONTATO)
	VALUES('Centro Pop SARES Unidade I','19 999401975', 'centropopsaresum@gmail.com');
    
select * from funcionarios;

insert into funcionarios (matricula, nome, cargo, contato_telefone, e_mail, id_servico)
	values(1324101, 'Deive Audieres Leal', 'Ag. Admin', 19999401975, 'deive.leal@gmail.com', 1);
    
select NOME, E_MAIL, NOME_DO_SERVICO 
from funcionarios natural join servico;

select * from usuarios;

insert into usuarios (prontuario,nome,nomesocial,apelido,nomemae,nomepai,datanascimento,cpf,nis,rg,id_servico,id_funcionario)
	values(228, 'Daniel de Oliveira', null ,null, 'Maria Aparecida de Oliveira', 'José Aparecido de Oliveira','2000-07-06',06245685273, 13517513588, 28798556, 1, 1);
    
select u.prontuario 'Prontuário', u.nome 'Nome', u.nomesocial 'Nome Social', u.apelido 'Apelido', u.nomemae 'Nome da Mãe', u.datanascimento 'Data de Nascimento', s.nome_do_servico 'Serviço Cadastrado', f.nome 'Referência'
	from usuarios u
    inner join servico s
    inner join funcionarios f
    where u.id_servico = s.id_servico and u.id_funcionario = f.id_funcionario;
    
insert into atendimento (id_usuario,id_funcionario,data_atendimento,comentarios)
values (1,1,'2020/04/02','O usuário solicitou passagem de recâmbio. Não foi atendido pois não se encontra dentro dos critérios de atendimento da solicitação');

select u.prontuario 'Prontuário', u.nome 'Nome', u.nomesocial 'Nome Social', f.nome 'Técnico do Atendimento', a.data_atendimento 'Data do Atendimento'
	FROM usuarios u 
    inner join funcionarios f
    inner join atendimento a
    where u.id_usuario = a.id_usuario and u.id_funcionario = f.id_funcionario;








