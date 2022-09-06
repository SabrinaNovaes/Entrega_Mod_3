use bonvoyage;
 
CREATE TABLE Clientes (
id_cpf varchar(12) PRIMARY KEY,
Email varchar(30),
Senha varchar(10),
nome varchar(30),
Telefone varchar(12)
);

CREATE TABLE Pacotes (
id_pcts int PRIMARY KEY auto_increment not null,
destino varchar(30),
hospedagem varchar(30),
qntd_dias int,
qntd_passagem int,
precos decimal(5,2)
);

CREATE TABLE Endereco (
id_endereco int PRIMARY KEY auto_increment not null,
rua varchar(30),
numero int,
CEP int,
bairro varchar(30),
cidade varchar(30),
estado varchar(30)
);

CREATE TABLE Destinos (
id_destinos varchar(30) PRIMARY KEY auto_increment not null,
pct_familia varchar(30),
nacionais varchar(30),
internacionais varchar(30)
);

CREATE TABLE Compra (
id_compra int PRIMARY KEY auto_increment not null,
data date,
id_cpf varchar(12),
id_pcts int,
FOREIGN KEY(id_cpf) REFERENCES Clientes (id_cpf),
FOREIGN KEY(id_pcts) REFERENCES Pacotes (id_pcts)
);

ALTER TABLE tem ADD FOREIGN KEY(id_destinos) REFERENCES Destinos (id_destinos);
