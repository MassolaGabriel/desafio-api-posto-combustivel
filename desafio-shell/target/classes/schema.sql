-- Tabela Combustiveis
CREATE TABLE IF NOT EXISTS combustiveis (
                                            id INTEGER NOT NULL AUTO_INCREMENT,
                                            nome VARCHAR(50) NOT NULL,
    preco_litro DECIMAL(10, 2) NOT NULL, -- DECIMAL para dinheiro
    PRIMARY KEY (id),
    UNIQUE(nome)
    );

-- Tabela Bombas
CREATE TABLE IF NOT EXISTS bombas (
                                      id INTEGER NOT NULL AUTO_INCREMENT,
                                      nome VARCHAR(100) NOT NULL,
    combustivel_id INTEGER NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (nome),
    CONSTRAINT fk_bomba_combustivel FOREIGN KEY (combustivel_id)
    REFERENCES combustiveis(id)
    );

-- Tabela Abastecimentos
CREATE TABLE IF NOT EXISTS abastecimentos (
                                              id INTEGER NOT NULL AUTO_INCREMENT,
                                              data_hora DATETIME, -- Guarda data e hora
                                              volume_litros DECIMAL(10, 3), -- 3 casas decimais para litros (padrão ANP)
    valor_total DECIMAL(10, 2),   -- 2 casas para dinheiro
    bomba_id INTEGER NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_abastecimento_bomba FOREIGN KEY (bomba_id)
    REFERENCES bombas(id)
    );