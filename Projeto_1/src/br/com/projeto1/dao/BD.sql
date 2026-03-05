/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  gordoni
 * Created: Feb 19, 2026
 */

CREATE TABLE cliente
(
	id_cli SERIAL,
	nome_cli CHARACTER VARYING(50),
	logradouro_cli CHARACTER VARYING(50),
	numero_cli INTEGER,
	bairro_cli CHARACTER VARYING(50),
	cidade_cli CHARACTER VARYING(50),
	estado_cli CHARACTER VARYING(2),
	cep_cli CHARACTER VARYING(10),
	cpf_cli CHARACTER VARYING(14),
	rg_cli CHARACTER VARYING(15),
	
	CONSTRAINT cliente_pkey PRIMARY KEY (id_cli),
	CONSTRAINT cliente_cpf_key UNIQUE (cpf_cli)
);

select * from cliente;

drop table cliente;