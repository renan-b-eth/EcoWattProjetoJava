-- Utiliza��o procedure de insert tabela usu�rio
BEGIN
    Inserir_Usuario(
        p_nome_usuario => 'Roberto Silva',
        p_email_usuario => 'roberto.silva@gmail.com',
        p_senha_usuario => 'Senha@123'
    );
    DBMS_OUTPUT.PUT_LINE('Usu�rio cadastrado com sucesso!');
END;
/

-- Utiliza��o da procedure cadastrando o endere�o do Roberto
BEGIN
    Inserir_Endereco(
        p_rua_endereco => 'Rua das Flores',
        p_numero_endereco => '157',
        p_bairro_endereco => 'Jardim Am�rica',
        p_cidade_endereco => 'S�o Paulo',
        p_estado_endereco => 'SP',
        p_cep_endereco => '01426-000',
        p_id_usuario => 1
    );
    DBMS_OUTPUT.PUT_LINE('Endere�o cadastrado com sucesso!');
END;
/

-- Utiliza��o da procedure cadastrando o dispositivo instalado na casa do Roberto
BEGIN
    Inserir_Dispositivo(
        p_nome_dispositivo => 'Medidor Principal',
        p_id_usuario => 1
    );
    DBMS_OUTPUT.PUT_LINE('Dispositivo cadastrado com sucesso!');
END;
/

-- Utiliza��o da procedure registrando uma leitura do dispositivo do Roberto
BEGIN
    Inserir_Leitura_Consumo(
        p_corrente_leitura => 10,
        p_tensao_leitura => 127,
        p_potencia_leitura => 1270,
        p_id_dispositivo => 1
    );
END;
/

-- Utiliza��o da procedure registrando no hist�rico mensal do Roberto
BEGIN
    Inserir_Historico_Mensal(
        p_mes_ano_historico => '11-2024',
        p_consumo_total_mes_historico => 285,
        p_id_dispositivo => 1
    );
END;

-- Visualiza��o dos inserts
SELECT * FROM ECOWATT_USUARIO, ECOWATT_ENDERECO, ECOWATT_DISPOSITIVO, ECOWATT_LEITURA_CONSUMO, ECOWATT_HISTORICO_MENSAL