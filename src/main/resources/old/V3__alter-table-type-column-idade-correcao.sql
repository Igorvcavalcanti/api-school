ALTER TABLE alunos
ALTER COLUMN idade TYPE integer
USING nota2sem::integer;