-- data.sql

-- Inserindo Combustíveis (Respeitando a regra de Nome Texto e Preço)
INSERT INTO combustiveis (tipo_combustivel, preco_litro) VALUES ('Gasolina Comum', 5.89);
INSERT INTO combustiveis (tipo_combustivel, preco_litro) VALUES ('Gasolina Aditivada', 6.19);
INSERT INTO combustiveis (tipo_combustivel, preco_litro) VALUES ('Etanol', 3.99);
INSERT INTO combustiveis (tipo_combustivel, preco_litro) VALUES ('Diesel S10', 6.05);

-- Inserindo Bombas (Relacionadas a um tipo de combustível)
INSERT INTO bombas_combustivel (nome_da_bomba, tipo_combustivel_nome) VALUES ('Bomba 1 - Principal', 'Gasolina Comum');
INSERT INTO bombas_combustivel (nome_da_bomba, tipo_combustivel_nome) VALUES ('Bomba 2 - Lateral', 'Etanol');
INSERT INTO bombas_combustivel (nome_da_bomba, tipo_combustivel_nome) VALUES ('Bomba 3 - Caminhões', 'Diesel S10');

-- Inserindo Abastecimentos (Histórico)
-- Bomba 1 (Gasolina) - 20 litros * 5.89 = 117.80
INSERT INTO abastecimentos (data_abastecimento, volume_abastecido, valor_total, bomba_id)
VALUES ('2025-11-15', 20.000, 117.80, 1);

-- Bomba 1 (Gasolina) - 10 litros * 5.89 = 58.90
INSERT INTO abastecimentos (data_abastecimento, volume_abastecido, valor_total, bomba_id)
VALUES ('2025-11-16', 10.000, 58.90, 1);

-- Bomba 2 (Etanol) - 30 litros * 3.99 = 119.70
INSERT INTO abastecimentos (data_abastecimento, volume_abastecido, valor_total, bomba_id)
VALUES ('2025-11-17', 30.000, 119.70, 2);