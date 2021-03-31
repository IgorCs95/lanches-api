CREATE TABLE item_pedido(
	pedido_id INTEGER,
	produto_id INTEGER,
	valor DECIMAL(10,2) NOT NULL,
	quantidade DECIMAL(10,2) NOT NULL,
	PRIMARY KEY(produto_id,pedido_id),
	FOREIGN KEY(produto_id) REFERENCES produto (id),
	FOREIGN KEY(pedido_id) REFERENCES pedido (id)	  
);

