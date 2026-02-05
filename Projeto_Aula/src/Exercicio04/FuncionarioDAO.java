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
public class FuncionarioDAO {
    public String mostrarDados(FuncionarioDTO dto){
        
        return "Os dados Gravados são:"
                + "\nnome: " + dto.getNome() 
                + "\nLogradouro: " + dto.getLogradouro()
                + "\nBairro: " + dto.getBairro()
                + "\nCidade: " + dto.getCidade()
                + "\nEstado: " + dto.getEstado()
                + "\nCEP: " + dto.getCep()
                + "\nNumero: " + dto.getNum()
                + "\nCPF " + dto.getCpf()
                + "\nRG: " + dto.getRg();
    }
}
