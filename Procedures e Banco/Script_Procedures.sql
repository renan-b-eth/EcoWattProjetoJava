-- Procedure para inserir registros na tabela Usuário
CREATE OR REPLACE PROCEDURE Inserir_Usuario (
    p_nome_usuario IN VARCHAR2,
    p_email_usuario IN VARCHAR2,
    p_senha_usuario IN VARCHAR2
) AS
BEGIN
    INSERT INTO ECOWATT_USUARIO (NOME_USUARIO, EMAIL_USUARIO, SENHA_USUARIO)
    VALUES (p_nome_usuario, p_email_usuario, p_senha_usuario);
END;
/

-- Procedure para inserir registros na tabela Endereço
CREATE OR REPLACE PROCEDURE Inserir_Endereco (
    p_rua_endereco IN VARCHAR2,
    p_numero_endereco IN VARCHAR2,
    p_bairro_endereco IN VARCHAR2,
    p_cidade_endereco IN VARCHAR2,
    p_estado_endereco IN VARCHAR2,
    p_cep_endereco IN VARCHAR2,
    p_id_usuario IN NUMBER
) AS
BEGIN
    INSERT INTO ECOWATT_ENDERECO (RUA_ENDERECO, NUMERO_ENDERECO, BAIRRO_ENDERECO, 
                                 CIDADE_ENDERECO, ESTADO_ENDERECO, CEP_ENDERECO, ID_USUARIO)
    VALUES (p_rua_endereco, p_numero_endereco, p_bairro_endereco, 
            p_cidade_endereco, p_estado_endereco, p_cep_endereco, p_id_usuario);
END;
/

-- Procedure para inserir registros na tabela Dispositivo
CREATE OR REPLACE PROCEDURE Inserir_Dispositivo (
    p_nome_dispositivo IN VARCHAR2,
    p_id_usuario IN NUMBER
) AS
BEGIN
    INSERT INTO ECOWATT_DISPOSITIVO (NOME_DISPOSITIVO, ID_USUARIO)
    VALUES (p_nome_dispositivo, p_id_usuario);
END;
/

-- Procedure para inserir registros na tabela Leitura de Consumo
CREATE OR REPLACE PROCEDURE Inserir_Leitura_Consumo (
    p_corrente_leitura IN NUMBER,
    p_tensao_leitura IN NUMBER,
    p_potencia_leitura IN NUMBER,
    p_id_dispositivo IN NUMBER
) IS
    v_corrente NUMBER(10,2);
    v_tensao NUMBER(10,2);
    v_potencia NUMBER(12,2);
BEGIN
    -- Validação e conversão explícita dos valores
    v_corrente := ROUND(p_corrente_leitura, 2);
    v_tensao := ROUND(p_tensao_leitura, 2);
    v_potencia := ROUND(p_potencia_leitura, 2);

    -- Validação dos dados
    IF p_id_dispositivo IS NULL THEN
        RAISE_APPLICATION_ERROR(-20001, 'ID do dispositivo não pode ser nulo');
    END IF;

    INSERT INTO ECOWATT_LEITURA_CONSUMO (
        CORRENTE_LEITURA,
        TENSAO_LEITURA,
        POTENCIA_LEITURA,
        ID_DISPOSITIVO
    ) VALUES (
        v_corrente,
        v_tensao,
        v_potencia,
        p_id_dispositivo
    );
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Leitura inserida com sucesso!');
EXCEPTION
    WHEN VALUE_ERROR THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Erro de conversão de dados: ' || 
            DBMS_UTILITY.FORMAT_ERROR_STACK || 
            DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Erro: ' || SQLERRM || 
            ' - ' || DBMS_UTILITY.FORMAT_ERROR_BACKTRACE);
END;
/

-- Procedure para inserir registros na tabela Histórico Mensal
CREATE OR REPLACE PROCEDURE Inserir_Historico_Mensal (
    p_mes_ano_historico IN VARCHAR2,
    p_consumo_total_mes_historico IN NUMBER,
    p_id_dispositivo IN NUMBER
) IS
    v_consumo NUMBER(12,2);
BEGIN
    -- Validação dos parâmetros
    IF p_mes_ano_historico IS NULL THEN
        RAISE_APPLICATION_ERROR(-20001, 'Mês/Ano não pode ser nulo');
    END IF;

    -- Conversão segura do consumo
    v_consumo := ROUND(p_consumo_total_mes_historico, 2);

    -- Inserção com valores validados
    INSERT INTO ECOWATT_HISTORICO_MENSAL (
        MES_ANO_HISTORICO,
        CONSUMO_TOTAL_MES_HISTORICO,
        ID_DISPOSITIVO
    ) VALUES (
        p_mes_ano_historico,
        v_consumo,
        p_id_dispositivo
    );
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Histórico mensal registrado com sucesso!');
EXCEPTION
    WHEN VALUE_ERROR THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Erro: Valor de consumo inválido. Use números com até 10 dígitos e 2 decimais.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Erro: ' || SQLERRM);
END;
/

-- Procedure para exportar os dados no formato JSON
CREATE OR REPLACE PROCEDURE Exportar_Dados_JSON AS 
   v_json CLOB;
BEGIN 
   SELECT JSON_OBJECT(
       'dispositivos' VALUE (
           SELECT JSON_ARRAYAGG(
               JSON_OBJECT('nome_dispositivo' VALUE NOME_DISPOSITIVO)
           )
           FROM ECOWATT_DISPOSITIVO)
   ) INTO v_json FROM dual;

   DBMS_OUTPUT.PUT_LINE(v_json);
END;
/
