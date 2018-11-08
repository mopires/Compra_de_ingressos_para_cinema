CREATE TABLE Cliente (

    cpf INT NOT NULL,
    nome VARCHAR(150),
    estudante NUMERIC(1),
    PRIMARY key(cpf)

);

CREATE TABLE Sala (

    numero_sala INT NOT NULL,
    numero_cadeiras int,
    PRIMARY key(numero_sala)

);

CREATE TABLE Sessao (

    id_sessao INT NOT NULL,
    id_filme int,
    numero_sala int,
    horario date,
    quantidadeIngressosComprados int,
    PRIMARY key(id_sessao),
    FOREIGN key(id_filme) REFERENCES Filme(id_filme),
    FOREIGN key(numero_sala) REFERENCES Sala(numero_sala)

);

CREATE TABLE Filme(

    id_filme INT NOT NULL,
    titulo VARCHAR(200),
    genero VARCHAR(50),
    faixa_etaria NUMERIC(2),
    PRIMARY KEY(id_filme)
    
);

CREATE table Ingressos(

    id_ingresso int not null,
    id_sessao int,
    preco float,
    PRIMARY key(id_ingresso),
    FOREIGN KEY(id_sessao) REFERENCES Sessao(id_sessao)
    
);

CREATE table IngressosVendidos(

    id int not null,
    id_ingresso int,
    cpf int,
    PRIMARY key(id),
    FOREIGN key(id_ingresso) REFERENCES Ingressos(id_ingresso),
    FOREIGN key(cpf) REFERENCES Cliente(cpf)

);