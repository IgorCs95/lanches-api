CREATE TABLE produto(	
	id SERIAL PRIMARY KEY,
   	nome VARCHAR(50) NOT NULL,
   	valor DECIMAL(10,2) NOT NULL,
   	estoque INTEGER,
   	status BOOLEAN DEFAULT TRUE,
   	categoria VARCHAR(100) NOT NULL
);