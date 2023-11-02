ALTER TABLE alunos
ALTER COLUMN nota1sem TYPE DOUBLE PRECISION
USING nota1sem::double precision;

ALTER TABLE alunos
ALTER COLUMN nota2sem TYPE DOUBLE PRECISION
USING nota2sem::double precision;

