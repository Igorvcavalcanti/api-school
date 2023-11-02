CREATE TABLE alunos (
    id VARCHAR(255) PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    idade INT NOT NULL,
    nota1_sem DOUBLE PRECISION,
    nota2_sem DOUBLE PRECISION,
    professor VARCHAR(255),
    num_sala VARCHAR(255),
    ativo BOOLEAN DEFAULT TRUE
);
