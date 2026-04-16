/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  brenocvs
 * Created: 9 de abr. de 2026
 */

CREATE TABLE fornecedor(
id_for serial,
nome_for character varying(50),
cnpj_for character varying(15),
tel_for character varying(13),
data_cad_for date,
CONSTRAINT pk_for PRIMARY KEY (id_for)
);

SELECT * FROM fornecedor;