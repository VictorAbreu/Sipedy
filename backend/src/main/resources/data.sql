INSERT INTO tb_user (first_name, last_name, email, celular, cpf, password) VALUES ('Alex', 'Brown', 'alex@gmail.com', '37-93551-3551', '834.493.240-80', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, celular, cpf, password) VALUES ('Maria', 'Green', 'maria@gmail.com', '37-93551-3551', '778.768.720-77', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, celular, cpf, password) VALUES ('Victor', 'Abreu', 'vlabreu@outlook.com', '37-93551-3551', '834.493.240-80', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, celular, cpf, password) VALUES ('Lucas', 'Victor', 'lucas@gmail.com', '37-93551-3551', '834.493.240-80', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, celular, cpf, password) VALUES ('Persia', 'Abreu', 'persia@gmail.com', '37-93551-3551', '834.493.240-80', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, celular, cpf, password) VALUES ('Joao', 'Silva', 'joao@gmail.com', '37-93551-3551', '834.493.240-80', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, celular, cpf, password) VALUES ('Alexandre', 'Jow', 'alexandre@gmail.com', '37-93551-3551', '834.493.240-80', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, celular, cpf, password) VALUES ('Jow', 'Jow', 'jow@gmail.com', '37-93551-3551', '834.493.240-80', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, celular, cpf, password) VALUES ('Marcos', 'Veiga', 'marcos@gmail.com', '37-93551-3551', '834.493.240-80', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, celular, cpf, password) VALUES ('Jose', 'Skin', 'jose@gmail.com', '37-93551-3551', '834.493.240-80', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, celular, cpf, password) VALUES ('Osvaldo', 'Silva', 'osvaldo@gmail.com', '37-93551-3551', '834.493.240-80', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, celular, cpf, password) VALUES ('Vicente', 'Brow', 'vicente@gmail.com', '37-93551-3551', '834.493.240-80', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, celular, cpf, password) VALUES ('Antônio', 'Geraldo', 'geraldo@gmail.com', '37-93551-3551', '834.493.240-80', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, celular, cpf, password) VALUES ('Silva', 'Pimenta', 'silvia@gmail.com', '37-93551-3551', '834.493.240-80', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, celular, cpf, password) VALUES ('Orlando', 'Jow', 'orlando@gmail.com', '37-93551-3551', '834.493.240-80', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, celular, cpf, password) VALUES ('Ana', 'Mara', 'ana@gmail.com', '37-93551-3551', '834.493.240-80', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');
INSERT INTO tb_user (first_name, last_name, email, celular, cpf, password) VALUES ('Joana', 'Marciana', 'joana@gmail.com', '37-93551-3551', '834.493.240-80', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG');

INSERT INTO tb_role (authority) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (4, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (5, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (6, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (7, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (8, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (9, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (10, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (11, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (12, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (13, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (14, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (15, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (16, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (17, 1);


INSERT INTO tb_empresa (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Bill', '17.702.376/0001-40', 'contato@vendetudo.com', 'Av. Francisco Campos, 82', 'MG', 'Vende Tudo Ltda', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_empresa (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9192', '35610-000', 'Dores do Indaiá', 'Marcos', '17.702.376/0001-40', 'contato@vendemelhor.com', 'Av. Francisco Campos, 89', 'MG', 'Vende Melhor Ltda', '058.576.151/8733', '37-3551-3552');

INSERT INTO tb_user_empresa (user_id, empresa_id) VALUES (1, 1);
INSERT INTO tb_user_empresa (user_id, empresa_id) VALUES (2, 2);
INSERT INTO tb_user_empresa (user_id, empresa_id) VALUES (3, 2);
INSERT INTO tb_user_empresa (user_id, empresa_id) VALUES (4, 1);
INSERT INTO tb_user_empresa (user_id, empresa_id) VALUES (5, 1);
INSERT INTO tb_user_empresa (user_id, empresa_id) VALUES (6, 1);
INSERT INTO tb_user_empresa (user_id, empresa_id) VALUES (7, 1);
INSERT INTO tb_user_empresa (user_id, empresa_id) VALUES (8, 1);
INSERT INTO tb_user_empresa (user_id, empresa_id) VALUES (9, 1);
INSERT INTO tb_user_empresa (user_id, empresa_id) VALUES (10, 1);
INSERT INTO tb_user_empresa (user_id, empresa_id) VALUES (11, 1);
INSERT INTO tb_user_empresa (user_id, empresa_id) VALUES (12, 1);
INSERT INTO tb_user_empresa (user_id, empresa_id) VALUES (13, 1);
INSERT INTO tb_user_empresa (user_id, empresa_id) VALUES (14, 1);
INSERT INTO tb_user_empresa (user_id, empresa_id) VALUES (15, 1);
INSERT INTO tb_user_empresa (user_id, empresa_id) VALUES (16, 1);
INSERT INTO tb_user_empresa (user_id, empresa_id) VALUES (17, 1);

INSERT INTO tb_cliente (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Bill', '17.702.376/0001-40', 'compratudo@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Compra tudo Ltda', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_cliente (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Bel', '17.702.376/0001-40', 'mappi@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Mappi Ltda', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_cliente (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Mara', '17.702.376/0001-40', 'marasuper@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Supermercados Mara', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_cliente (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Carlos', '17.702.376/0001-40', 'madeplan@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Madeira Madeplan', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_cliente (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'João', '17.702.376/0001-40', 'joao@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'João Rafael Lopes', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_cliente (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Fulano', '17.702.376/0001-40', 'fulano@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Fulano da Silva', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_cliente (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Beltrano', '17.702.376/0001-40', 'beltrano@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Beltrano Marcos', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_cliente (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Rubens', '17.702.376/0001-40', 'rb@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Frigorífico RB', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_cliente (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Lucas', '17.702.376/0001-40', 'lucas@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Lucas Abreu', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_cliente (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Silveira', '17.702.376/0001-40', 'ssilveira@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Mercado Silveira', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_cliente (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Mauro', '17.702.376/0001-40', 'mm@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Topa tudo MM', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_cliente (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Geralda', '17.702.376/0001-40', 'geralda@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Loja da Geralda', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_cliente (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Franco', '17.702.376/0001-40', 'pneumax@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Pneumax Ltda', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_cliente (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Cida', '17.702.376/0001-40', 'motobike@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Motobike', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_cliente (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Victor', '17.702.376/0001-40', 'victor@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Victor Abreu', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_cliente (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Persia', '17.702.376/0001-40', 'persia@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Persia Braga de O. Abreu', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_cliente (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Lopes', '17.702.376/0001-40', 'carrotop@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Auto peças carro top', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_cliente (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Gil', '17.702.376/0001-40', 'giraya@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Panificadora Giraya', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_cliente (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Carlos', '17.702.376/0001-40', 'cmaximo@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Carlos Máximo', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_cliente (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Leo', '17.702.376/0001-40', 'leo@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Leonardo Abravanel', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_cliente (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Silvano', '17.702.376/0001-40', 'autosilva@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Auto Silva', '058.576.151/8733', '37-3551-3551');

INSERT INTO tb_cliente_empresa (cliente_id, empresa_id) VALUES (1, 1);
INSERT INTO tb_cliente_empresa (cliente_id, empresa_id) VALUES (2, 2);
INSERT INTO tb_cliente_empresa (cliente_id, empresa_id) VALUES (3, 2);
INSERT INTO tb_cliente_empresa (cliente_id, empresa_id) VALUES (4, 1);
INSERT INTO tb_cliente_empresa (cliente_id, empresa_id) VALUES (5, 1);
INSERT INTO tb_cliente_empresa (cliente_id, empresa_id) VALUES (6, 2);
INSERT INTO tb_cliente_empresa (cliente_id, empresa_id) VALUES (7, 1);
INSERT INTO tb_cliente_empresa (cliente_id, empresa_id) VALUES (8, 1);
INSERT INTO tb_cliente_empresa (cliente_id, empresa_id) VALUES (9, 2);
INSERT INTO tb_cliente_empresa (cliente_id, empresa_id) VALUES (10, 2);
INSERT INTO tb_cliente_empresa (cliente_id, empresa_id) VALUES (11, 1);
INSERT INTO tb_cliente_empresa (cliente_id, empresa_id) VALUES (12, 2);
INSERT INTO tb_cliente_empresa (cliente_id, empresa_id) VALUES (13, 1);
INSERT INTO tb_cliente_empresa (cliente_id, empresa_id) VALUES (14, 2);
INSERT INTO tb_cliente_empresa (cliente_id, empresa_id) VALUES (15, 1);
INSERT INTO tb_cliente_empresa (cliente_id, empresa_id) VALUES (16, 2);
INSERT INTO tb_cliente_empresa (cliente_id, empresa_id) VALUES (17, 1);
INSERT INTO tb_cliente_empresa (cliente_id, empresa_id) VALUES (18, 2);
INSERT INTO tb_cliente_empresa (cliente_id, empresa_id) VALUES (19, 1);
INSERT INTO tb_cliente_empresa (cliente_id, empresa_id) VALUES (20, 1);
INSERT INTO tb_cliente_empresa (cliente_id, empresa_id) VALUES (21, 1);

INSERT INTO tb_fornecedor (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Bill', '17.702.376/0001-40', 'compratudo@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Compra tudo Ltda', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_fornecedor (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Bel', '17.702.376/0001-40', 'mappi@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Mappi Ltda', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_fornecedor (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Mara', '17.702.376/0001-40', 'marasuper@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Supermercados Mara', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_fornecedor (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Carlos', '17.702.376/0001-40', 'madeplan@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Madeira Madeplan', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_fornecedor (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'João', '17.702.376/0001-40', 'joao@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'João Rafael Lopes', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_fornecedor (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Fulano', '17.702.376/0001-40', 'fulano@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Fulano da Silva', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_fornecedor (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Beltrano', '17.702.376/0001-40', 'beltrano@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Beltrano Marcos', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_fornecedor (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Rubens', '17.702.376/0001-40', 'rb@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Frigorífico RB', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_fornecedor (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Lucas', '17.702.376/0001-40', 'lucas@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Lucas Abreu', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_fornecedor (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Silveira', '17.702.376/0001-40', 'ssilveira@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Mercado Silveira', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_fornecedor (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Mauro', '17.702.376/0001-40', 'mm@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Topa tudo MM', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_fornecedor (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Geralda', '17.702.376/0001-40', 'geralda@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Loja da Geralda', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_fornecedor (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Franco', '17.702.376/0001-40', 'pneumax@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Pneumax Ltda', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_fornecedor (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Cida', '17.702.376/0001-40', 'motobike@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Motobike', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_fornecedor (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Victor', '17.702.376/0001-40', 'victor@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Victor Abreu', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_fornecedor (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Persia', '17.702.376/0001-40', 'persia@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Persia Braga de O. Abreu', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_fornecedor (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Lopes', '17.702.376/0001-40', 'carrotop@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Auto peças carro top', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_fornecedor (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Gil', '17.702.376/0001-40', 'giraya@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Panificadora Giraya', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_fornecedor (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Carlos', '17.702.376/0001-40', 'cmaximo@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Carlos Máximo', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_fornecedor (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Leo', '17.702.376/0001-40', 'leo@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Leonardo Abravanel', '058.576.151/8733', '37-3551-3551');
INSERT INTO tb_fornecedor (celular, cep, cidade, contato, cpf_cnpj, email, endereco, estado, nome_razao, rg_ie, telefone) VALUES ('37-99191-9191', '35610-000', 'Dores do Indaiá', 'Silvano', '17.702.376/0001-40', 'autosilva@gmail.com', 'Av. Francisco Campos, 82', 'MG', 'Auto Silva', '058.576.151/8733', '37-3551-3551');

INSERT INTO tb_fornecedor_empresa (fornecedor_id, empresa_id) VALUES (1, 1);
INSERT INTO tb_fornecedor_empresa (fornecedor_id, empresa_id) VALUES (2, 2);
INSERT INTO tb_fornecedor_empresa (fornecedor_id, empresa_id) VALUES (3, 2);
INSERT INTO tb_fornecedor_empresa (fornecedor_id, empresa_id) VALUES (4, 1);
INSERT INTO tb_fornecedor_empresa (fornecedor_id, empresa_id) VALUES (5, 1);
INSERT INTO tb_fornecedor_empresa (fornecedor_id, empresa_id) VALUES (6, 2);
INSERT INTO tb_fornecedor_empresa (fornecedor_id, empresa_id) VALUES (7, 1);
INSERT INTO tb_fornecedor_empresa (fornecedor_id, empresa_id) VALUES (8, 1);
INSERT INTO tb_fornecedor_empresa (fornecedor_id, empresa_id) VALUES (9, 2);
INSERT INTO tb_fornecedor_empresa (fornecedor_id, empresa_id) VALUES (10, 2);
INSERT INTO tb_fornecedor_empresa (fornecedor_id, empresa_id) VALUES (11, 1);
INSERT INTO tb_fornecedor_empresa (fornecedor_id, empresa_id) VALUES (12, 2);
INSERT INTO tb_fornecedor_empresa (fornecedor_id, empresa_id) VALUES (13, 1);
INSERT INTO tb_fornecedor_empresa (fornecedor_id, empresa_id) VALUES (14, 2);
INSERT INTO tb_fornecedor_empresa (fornecedor_id, empresa_id) VALUES (15, 1);
INSERT INTO tb_fornecedor_empresa (fornecedor_id, empresa_id) VALUES (16, 2);
INSERT INTO tb_fornecedor_empresa (fornecedor_id, empresa_id) VALUES (17, 1);
INSERT INTO tb_fornecedor_empresa (fornecedor_id, empresa_id) VALUES (18, 2);
INSERT INTO tb_fornecedor_empresa (fornecedor_id, empresa_id) VALUES (19, 1);
INSERT INTO tb_fornecedor_empresa (fornecedor_id, empresa_id) VALUES (20, 1);
INSERT INTO tb_fornecedor_empresa (fornecedor_id, empresa_id) VALUES (21, 1);