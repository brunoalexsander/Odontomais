CREATE DATABASE odontomais;

USE odontomais;

CREATE TABLE pessoa (
	codPessoa INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	cpf VARCHAR(11) NOT NULL,
	rg VARCHAR(12) NOT NULL,
	nascimento DATE NOT NULL,
	genero CHAR(1) NOT NULL,
	email VARCHAR(100) NOT NULL,
	telefone VARCHAR(14) NOT NULL,
	celular VARCHAR(15) NOT NULL,
	CONSTRAINT PK_PESSOA PRIMARY KEY (codPessoa)
);

CREATE TABLE endereco (
	endereco VARCHAR(100) NOT NULL,
	complemento VARCHAR(20) NOT NULL,
	uf CHAR(2) NOT NULL,
	cep VARCHAR(9) NOT NULL,
	municipio VARCHAR(30) NOT NULL,
	codPessoa INT NOT NULL,
	CONSTRAINT PK_ENDERECO PRIMARY KEY (codPessoa),
	CONSTRAINT FK_ENDERECO_PESSOA FOREIGN KEY (codPessoa) REFERENCES pessoa (codPessoa) ON DELETE CASCADE
);

CREATE TABLE paciente (
	codPaciente INT NOT NULL AUTO_INCREMENT,
	codPessoa INT NOT NULL,
	codConvenio VARCHAR(10)
	CONSTRAINT PK_PACIENTE PRIMARY KEY (codPaciente, codPessoa)
	CONSTRAINT FK_PACIENTE_PESSOA FOREIGN KEY (codPessoa) REFERENCES pessoa (codPessoa) ON DELETE CASCADE
);

CREATE TABLE funcionario (
	codFuncionario INT NOT NULL AUTO_INCREMENT,
	codPessoa INT NOT NULL,
	permissao ENUM('0', '1', '2') NOT NULL DEFAULT '0',
	senha VARCHAR(100) NOT NULL,
	CONSTRAINT PK_FUNCIONARIO PRIMARY KEY (codFuncionario, codPessoa),
	CONSTRAINT FK_FUNCIONARIO_PESSOA FOREIGN KEY (codPessoa) REFERENCES pessoa (codPessoa) ON DELETE CASCADE
);

CREATE TABLE tratamento (
	codTratamento INT NOT NULL AUTO_INCREMENT,
	codPaciente INT NOT NULL,
	nome VARCHAR(100) NOT NULL,
	descricao TEXT,
	valor FLOAT(10,2) NOT NULL,
	CONSTRAINT PK_TRATAMENTO PRIMARY KEY (codTratamento, codPaciente),
	CONSTRAINT FK_TRATAMENTO_PACIENTE FOREIGN KEY (codPaciente) REFERENCES paciente (codPaciente)
);

/* LOGIN */

SELECT f.* FROM funcionario f
	INNER JOIN pessoa p ON f.codPessoa = p.codPessoa
	WHERE p.email = 'bruno@bruno.com' AND f.senha = '123456';