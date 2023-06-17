CREATE TABLE material (

    id serial PRIMARY KEY NOT NULL,
    nome TEXT NOT NULL,
    quantidade INTEGER NOT NULL,
    valor numeric(8,2) NOT NULL
);
