/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_2.dao;

import java.sql.*;
import br.com.projeto_2.dto.FornecedorDTO;
import java.text.SimpleDateFormat;
import org.postgresql.jdbc2.optional.SimpleDataSource;
/**
 *
 * @author brenocvs
 */
public class FornecedorDAO {

    public FornecedorDAO(){
    
    }

    SimpleDateFormat data_format = new SimpleDateFormat("dd/mm/yyy");
    private ResultSet rs = null;
    private Statement stmt = null;
    
    public boolean inserir(FornecedorDTO fdto){
        try{
            ConexaoDAO.ConectDB();
            
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "INSERT INTO FORNECEDOR (NOME_FOR, CNPJ_FOR,"
                    + "TEL_FOR, DATA_CAD_FOR) VALUES ("
                    + "'" + fdto.getNome_for() + "',"
                    + "'" + fdto.getCnpj_for() + "',"
                    + "'" + fdto.getTel_for() + "',"
                    + "TO_DATE('" + data_format.format(fdto.getData_cad_for()) + "','DD/MM/YYYY'))";
            
            System.out.println(comando);

            stmt.execute(comando.toUpperCase());
            
            ConexaoDAO.con.commit();
            
            stmt.close();
            return true;
            
        } catch (Exception e){
            System.out.println("Erro ao inserir no bando de dados"
                    + "\n" + e.getMessage());
            return false;
        } finally{
            ConexaoDAO.CloseDB();
        }
    }
    
    public boolean alterar(FornecedorDTO fdto){
        try{
            ConexaoDAO.ConectDB();
        
            stmt = ConexaoDAO.con.createStatement();
        
            String comando = "UPDATE FORNECEDOR SET "
                    + "NOME_FOR = '" + fdto.getNome_for() + "',"
                    + "CNPJ_FOR = '" + fdto.getCnpj_for() + "',"
                    + "TEL_FOR = '" + fdto.getTel_for() + "',"
                    + "DATA_CAD_FOR = to_date('" + data_format.format(fdto.getData_cad_for()) + "','DD/MM/YYYY') "
                    + "WHERE ID_FOR = " + fdto.getId_for();
            
            stmt.execute(comando.toUpperCase());
            
            ConexaoDAO.con.commit();
            
            stmt.close();
            return true;
            
        } catch (Exception e){
            System.out.println("Erro ao atualizar cadastro"
                    + "\n" + e.getMessage());
            return false;
        } finally{
            ConexaoDAO.CloseDB();
        }
    }
    
    public boolean excluir(FornecedorDTO fdto){
        try{
            ConexaoDAO.ConectDB();
        
            stmt = ConexaoDAO.con.createStatement();
        
            String comando = "DELETE FROM FORNECEDOR WHERE ID_FOR = " + fdto.getId_for();
        
            stmt.execute(comando.toUpperCase());
            
            ConexaoDAO.con.commit();
            stmt.close();
            
            return true;
        } catch (Exception e){
            System.out.println("Erro ao excluir cadastro"
                    + "\n" + e.getMessage());
            return false;
        } finally{
            ConexaoDAO.CloseDB();
        }   
    }
    
    public ResultSet consultar(FornecedorDTO fdto, int op){
        try{
            ConexaoDAO.ConectDB();
            
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "";
            
            switch (op) {
                case 2:
                    comando = "SELECT F.NOME_FOR, F.CNPJ_FOR, F.TEL_FOR,"
                            + "TO_CHAR(F.DATA_CAD_FOR, 'DD/MM/YYYY') AS DATA_CAD_FOR "
                            + "FROM FORNECEDOR F "
                            + "WHERE F.ID_FOR = " + fdto.getId_for();
                    break;
                case 1:
                    comando = "SELECT F.ID_FOR, F.NOME_FOR "
                            + "FROM FORNECEDOR F "
                            + "WHERE F.NOME_FOR LIKE '" + fdto.getNome_for() + "%' "
                            + "ORDER BY F.NOME_FOR";
                    break;
                default:
                    System.out.println("ERRO");
            }
            
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        } catch(Exception e){
            System.out.println("ERRO NA CONSULTA"
                    + "\n" + e.getMessage());
            return rs;
        }
    }
}

