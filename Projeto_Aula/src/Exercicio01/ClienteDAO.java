/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio01;

/**
 *
 * @author Aluno
 */
public class ClienteDAO {
    public String mostraNomeRg(ClienteDTo cdto){
        return "O nome informado foi: "
                + cdto.getNome() + "\nO RG informado foi? " + 
                cdto.getRg();
    }
    
    public String mostrarNomeIdade(ClienteDTo cdto){
        return "O nome informado foi: "
                + cdto.getNome() + "\nA Idade informada foi? " + 
                cdto.getIdade();
    }
}
