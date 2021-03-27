CREATE SEQUENCE cliente_id_seq START 1;

CREATE TABLE cliente(	
	id INTEGER PRIMARY KEY,
   	nome VARCHAR(50) NOT NULL,
   	limite DECIMAL NOT NULL,
   	telefone DECIMAL
);