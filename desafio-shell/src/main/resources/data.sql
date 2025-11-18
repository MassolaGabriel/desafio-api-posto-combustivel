-- Combustíveis
INSERT INTO combustiveis (nome, preco_litro) VALUES ('Gasolina Comum', 5.89);
INSERT INTO combustiveis (nome, preco_litro) VALUES ('Etanol', 3.99);
INSERT INTO combustiveis (nome, preco_litro) VALUES ('Diesel S10', 6.05);

-- Bombas
INSERT INTO bombas (nome, combustivel_id) VALUES ('Bomba 1', 1);
INSERT INTO bombas (nome, combustivel_id) VALUES ('Bomba 2', 2);

-- Abastecimentos
INSERT INTO abastecimentos (data_hora, volume_litros, valor_total, bomba_id)
VALUES ('2025-11-18 10:30:00', 20.000, 117.80, 1);

INSERT INTO abastecimentos (data_hora, volume_litros, valor_total, bomba_id)
VALUES ('2025-11-18 11:00:00', 40.000, 159.60, 2);