/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto1.dao;

import java.sql.*;

/**
 *
 * @author gordoni
 */
public class ConexaoDAO {

    public static Connection con = null;

    /**
     * Método construtor da classe
     *
     * @param Não recebe nenhum parametro
     */
    public ConexaoDAO() {
    }

    /**
     * Método que abre a conexão com o banco de dados é do tipo static para que
     * não seja necessário instanciar um objeto da classe, chamando os metodos
     * de forma direta. Ex: classe.nome_do_metodo
     */
    public static void ConectDB() {

        try {
            // Dados para conectar com o banco de dados

            String dsn = "projeto_1"; // nome do banco de dados (igual ao criado no Postgres)
            String user = "postgres"; // nome do usuário utilizado para se conectar
            String senha = "postdba"; // senha do usuário acima informado
            String porta = "5432"; // porta para acessar o serviço do banco

            DriverManager.registerDriver(new org.postgresql.Driver());
            // DriverManager.registerDriver(new com.msql.cj.jdbc.Driver());

            String url = "jdbc:postgresql://localhost:" + porta + "/" + dsn;
            //String url = "jdbc:mysql://localhost:3306/" + dsn;

            con = DriverManager.getConnection(url, user, senha);

            con.setAutoCommit(false);

            if (con == null) {
                System.out.println("Erro ao abrir o banco de dados " + dsn);
            }

        } // fecha o try
        // Caso ocorra problemas para abrir o banco de dados é emitido a mensagem no console.
        catch (Exception e) {
            System.out.println("Problema ao abrir a base de dados! "
                    + e.getMessage());
        } // fecha o catch
    } // Fecha o método ConectDB

    /**
     * Método que fecha a conexão com o banco de dados é do tipo static para que
     * não seja necessário instanciar um objeto da classe, chamando os metodos
     * de forma direta.Ex: classe.nome_do_metodo
     */
    public static void CloseDB() {
        try {
            con.close();
        } // fecha o try
        // Caso ocorra problemas para fechar o banco de dados é emitido a mensagem no console.
        catch (Exception e) {
            System.out.println("Problema ao fechar a base de dados! "
                    + e.getMessage());
        } // fecha o catch
    } //Fecha o método CloseDB

}
