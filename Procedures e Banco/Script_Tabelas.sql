-- Cria��o da tabela ECOWATT_USUARIO
CREATE TABLE ECOWATT_USUARIO (
    ID_USUARIO NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    NOME_USUARIO VARCHAR2(100) NOT NULL,
    EMAIL_USUARIO VARCHAR2(100) NOT NULL,
    SENHA_USUARIO VARCHAR2(100) NOT NULL
);

-- Cria��o da tabela ECOWATT_ENDERECO
CREATE TABLE ECOWATT_ENDERECO (
    ID_ENDERECO NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    RUA_ENDERECO VARCHAR2(100) NOT NULL,
    NUMERO_ENDERECO VARCHAR2(10) NOT NULL,
    BAIRRO_ENDERECO VARCHAR2(50),
    CIDADE_ENDERECO VARCHAR2(50),
    ESTADO_ENDERECO VARCHAR2(2) NOT NULL,
    CEP_ENDERECO VARCHAR2(10) NOT NULL,
    ID_USUARIO NUMBER,
    CONSTRAINT FK_ECOWATT_USUARIO_ENDERECO FOREIGN KEY (ID_USUARIO)
        REFERENCES ECOWATT_USUARIO(ID_USUARIO)
);

-- Cria��o da tabela ECOWATT_DISPOSITIVO
CREATE TABLE ECOWATT_DISPOSITIVO (
    ID_DISPOSITIVO NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    NOME_DISPOSITIVO VARCHAR2(100) NOT NULL,
    ID_USUARIO NUMBER,
    CONSTRAINT FK_ECOWATT_USUARIO_DISPOSITIVO FOREIGN KEY (ID_USUARIO)
        REFERENCES ECOWATT_USUARIO(ID_USUARIO)
);

-- Cria��o da tabela ECOWATT_LEITURA_CONSUMO
CREATE TABLE ECOWATT_LEITURA_CONSUMO (
    ID_LEITURA NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    CORRENTE_LEITURA NUMBER(10,2) NOT NULL,
    TENSAO_LEITURA NUMBER(10,2) NOT NULL,
    POTENCIA_LEITURA NUMBER(12,2) NOT NULL,
    DATA_HORA TIMESTAMP DEFAULT SYSTIMESTAMP NOT NULL, -- YYYY-MM-DD HH24:MI:SS
    ID_DISPOSITIVO NUMBER,
    CONSTRAINT FK_ECOWATT_DISPOSITIVO_LEITURA 
        FOREIGN KEY (ID_DISPOSITIVO) 
        REFERENCES ECOWATT_DISPOSITIVO(ID_DISPOSITIVO)
);

-- Cria��o da tabela ECOWATT_HISTORICO_MENSAL
CREATE TABLE ECOWATT_HISTORICO_MENSAL (
    ID_HISTORICO NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    MES_ANO_HISTORICO VARCHAR2(7) NOT NULL,
    CONSUMO_TOTAL_MES_HISTORICO NUMBER(12,2) DEFAULT 0 NOT NULL,
    ID_DISPOSITIVO NUMBER,
    CONSTRAINT FK_ECOWATT_DISPOSITIVO_HISTORICO 
        FOREIGN KEY (ID_DISPOSITIVO) 
        REFERENCES ECOWATT_DISPOSITIVO(ID_DISPOSITIVO)
);
