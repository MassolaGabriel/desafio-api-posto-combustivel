-- schema.sql

-- 1. Tabela de Combustíveis
-- No seu Java, o ID é o próprio nome (String)
CREATE TABLE IF NOT EXISTS combustiveis (
                                            tipo_combustivel VARCHAR(50) NOT NULL,
    preco_litro DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (tipo_combustivel)
    );

-- 2. Tabela de Bombas de Combustível
-- O nome da tabela padrão do Hibernate para BombasCombustivel geralmente vira snake_case
CREATE TABLE IF NOT EXISTS bombas_combustivel (
                                                  id INTEGER AUTO_INCREMENT NOT NULL,
                                                  nome_da_bomba VARCHAR(100) NOT NULL,
    tipo_combustivel_nome VARCHAR(50),
    PRIMARY KEY (id),
    UNIQUE (nome_da_bomba),
    CONSTRAINT fk_bomba_combustivel FOREIGN KEY (tipo_combustivel_nome)
    REFERENCES combustiveis(tipo_combustivel)
    );

-- 3. Tabela de Abastecimentos
CREATE TABLE IF NOT EXISTS abastecimentos (
                                              id INTEGER AUTO_INCREMENT NOT NULL,
                                              data_abastecimento DATE,
                                              volume_abastecido DECIMAL(10, 3),
    valor_total DECIMAL(10, 2),
    bomba_id INTEGER,
    PRIMARY KEY (id),
    CONSTRAINT fk_abastecimento_bomba FOREIGN KEY (bomba_id)
    REFERENCES bombas_combustivel(id)
    );