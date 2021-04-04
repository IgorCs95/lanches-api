CREATE SEQUENCE pedido_id_seq START 1;

CREATE TABLE pedido(
	id INTEGER PRIMARY KEY,
	cliente_id INTEGER,
	create_at DATE,
	pagamento_at DATE,
	valor_total DECIMAL(10,2),
	status_pagamento  VARCHAR(50),
	FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);