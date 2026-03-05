/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto1.dao;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author gordoni
 */
public class TesteConexaoDAO {

    public static void main(String[] args) {

        try {
            ConexaoDAO.ConectDB();
            Connection con = ConexaoDAO.con;

            if (con != null && !con.isClosed()) {

                String sql = "SELECT tablename FROM pg_tables WHERE schemaname = 'public'";

                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);

                StringBuilder tabelas = new StringBuilder();
                boolean encontrouTabela = false;

                while (rs.next()) {
                    encontrouTabela = true;
                    tabelas.append(rs.getString("tablename")).append("\n");
                }

                if (encontrouTabela) {
                    JOptionPane.showMessageDialog(null,
                            "Conectado com sucesso!\n\nTabelas encontradas:\n" + tabelas);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Conectado com sucesso!\n\nNenhuma tabela encontrada no schema public.");
                }

                rs.close();
                stmt.close();

            } else {
                JOptionPane.showMessageDialog(null, "Falha ao estabelecer conexão.");
            }

            ConexaoDAO.CloseDB();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao testar conexão: " + e.getMessage());
        }
    }

}
