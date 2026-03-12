/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto1.dao;

import java.sql.*;
import br.com.projeto1.dto.ClienteDTO;


/**
 *
 * @author gordoni
 */
public class ClienteDAO {
    
    public ClienteDAO(){
    }
    
   private ResultSet rs = null;
   private Statement stmt = null;
   
   public boolean inserirCliente(ClienteDTO clienteDTO){
       try{
           ConexaoDAO.ConectDB();
           
           stmt = ConexaoDAO.con.createStatement();
           
           String comando = "Insert into cliente (nome_cli, logradouro_cli, "
                + "numero_cli, bairro_cli, cidade_cli, estado_cli, cep_cli, "
                + "cpf_cli, rg_cli) values ("
                + "'" + clienteDTO.getNome_cli()+ "', "
                + "'" + clienteDTO.getLogradouro_cli() + "', "
                + clienteDTO.getNumero_cli() + ", "
                + "'" + clienteDTO.getBairro_cli() + "', "
                + "'" + clienteDTO.getCidade_cli() + "', "
                + "'" + clienteDTO.getEstado_cli() + "', "
                + "'" + clienteDTO.getCep_cli() + "', "
                + "'" + clienteDTO.getCpf_cli() + "', "
                + "'" + clienteDTO.getRg_cli() + "');";
           
           System.out.println(comando.toUpperCase());
           stmt.execute(comando.toUpperCase());           
           
           ConexaoDAO.con.commit();
           
           stmt.close();
           
           return true;
                  
       }catch(Exception e){
           System.out.println("Erro ao realizar a inserçao do cliente na base de dados."
                + "\nErro: " + e.getMessage());
           
           return false;
       }finally{           
           ConexaoDAO.CloseDB();
       }
   }    
   
   
   public ResultSet consultarCliente(int opc, ClienteDTO clienteDTO){
       try{
           ConexaoDAO.ConectDB();
           
           stmt = ConexaoDAO.con.createStatement();
           
           String comando = "";
           
           switch (opc) {
               case 1:
                    comando ="SELECT * FROM cliente "
                            + "WHERE nome_cli like '" + clienteDTO.getNome_cli() + "%'"
                            + "ORDER BY nome_cli";
               break;
               case 2:
                    comando = "SELECT * FROM cliente "
                            + "WHERE id_cli = " + clienteDTO.getId_cli();
               break;
               case 3:
                    comando = "SELECT id_cli, nome_cli"
                            + "FROM cliente";
           }
           rs = stmt.executeQuery(comando.toUpperCase());
           return rs;
           
        } catch(Exception e){
            System.out.println("Erro ao realizar a pesquisa do cliente na base de dados."
                + "\nErro: " + e.getMessage());
            return rs;
        }
   }
   
   public boolean alterarCliente(ClienteDTO clienteDTO){
       try{
           ConexaoDAO.ConectDB();
           
           stmt = ConexaoDAO.con.createStatement();
           
           String comando = "UPDATE cliente SET "
                   + "nome_cli = '" + clienteDTO.getNome_cli() + "',"
                   + "logradouro_cli = '" + clienteDTO.getLogradouro_cli() + "',"
                   + "numero_cli = " + clienteDTO.getNumero_cli() + ","
                   + "bairro_cli = '" + clienteDTO.getBairro_cli() + "',"
                   + "cidade_cli = '" + clienteDTO.getCidade_cli() + "',"
                   + "estado_cli = '" + clienteDTO.getEstado_cli() + "',"
                   + "cep_cli = '" + clienteDTO.getCep_cli() + "',"
                   + "cpf_cli = '" + clienteDTO.getCpf_cli() + "',"
                   + "rg_cli = '" + clienteDTO.getRg_cli() + "'"
                   + "WHERE id_cli = " + clienteDTO.getId_cli();
           
           System.out.println(comando.toUpperCase());
           stmt.execute(comando.toUpperCase());           
           
           ConexaoDAO.con.commit();
           
           stmt.close();
           
           return true;
                  
       }catch(Exception e){
           System.out.println("Erro ao alterar dados do cliente na base de dados."
                + "\nErro: " + e.getMessage());
           
           return false;
       }finally{           
           ConexaoDAO.CloseDB();
       }
   }
   
   public boolean excluirCliente(ClienteDTO clienteDTO){
       try{
           ConexaoDAO.ConectDB();
           
           stmt = ConexaoDAO.con.createStatement();
           
           String comando = "DELETE FROM cliente WHERE id_cli = " + clienteDTO.getId_cli();
           
           System.out.println(comando.toUpperCase());
           stmt.execute(comando.toUpperCase());           
           
           ConexaoDAO.con.commit();
           
           stmt.close();
           
           return true;
           
       } catch (Exception e){
           System.out.println("ERRO: " +e.getMessage());
           
           return false;
       } finally{
           ConexaoDAO.CloseDB();
       }
   }
}
