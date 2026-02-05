/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio04;

/**
 *
 * @author Aluno
 */
public class FuncionarioCTR {
    FuncionarioDAO dao = new FuncionarioDAO();
    
    public String mostrarDados(FuncionarioDTO dto){
        return dao.mostrarDados(dto);
    }
}
