/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_2.ctr;
import br.com.projeto_2.dao.FornecedorDAO;
import java.sql.ResultSet;
import br.com.projeto_2.dto.FornecedorDTO;
import br.com.projeto_2.dao.ConexaoDAO;
/**
 *
 * @author brenocvs
 */
public class FornecedorCTR {
    FornecedorDAO fdao = new FornecedorDAO();
    
    public FornecedorCTR(){
        
    }
    
    public String inserir(FornecedorDTO fdto){
        try{
            if(fdao.inserir(fdto)){
                return "Fornecedor cadastrado com sucesso!";
            } else {
                return "Erro ao cadastrar Fornecedor";
            }
        } catch(Exception e){
            System.out.println("ERRO NA CTR DO INSERIR"
                    + "\n" + e.getMessage());
            return "Erro ao cadastrar Fornecedor";
        }
    }
    
    public String alterar(FornecedorDTO fdto){
        try{
            if(fdao.alterar(fdto)){
                return "Fornecedor alterado com sucesso!";
            } else {
                return "Erro ao alterar Fornecedor";
            }
        } catch(Exception e){
            System.out.println("ERRO NA CTR DO ALTERAR"
                    + "\n" + e.getMessage());
            return "Erro ao alterar Fornecedor";
        }
    }
    
    public String excluir(FornecedorDTO fdto){
        try{
            if(fdao.excluir(fdto)){
                return "Fornecedor excluido com sucesso!";
            } else {
                return "Erro ao excluir Fornecedor";
            }
        } catch(Exception e){
            System.out.println("ERRO NA CTR DO EXCLUIR"
                    + "\n" + e.getMessage());
            return "Erro ao excluir Fornecedor";
        }
    }
    
    public ResultSet consultar(FornecedorDTO fdto, int op){
        ResultSet rs = null;
        
        rs = fdao.consultar(fdto, op);
        return rs;
    }
    
    public void closeDB(){
        ConexaoDAO.CloseDB();
    }
}
