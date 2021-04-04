CREATE TABLE item_pedido(
	id SERIAL PRIMARY KEY,
	pedido_id INTEGER,
	produto_id INTEGER,
	valor DECIMAL(10,2) NOT NULL,
	valor_total DECIMAL(10,2) NOT NULL,
	quantidade DECIMAL(10,2) NOT NULL,
	FOREIGN KEY(produto_id) REFERENCES produto (id),
	FOREIGN KEY(pedido_id) REFERENCES pedido (id)	  
);

