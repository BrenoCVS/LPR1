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
public class ClienteCTR {
    ClienteDAO cdao = new ClienteDAO();
    
    public String mostrarNomeRg(ClienteDTo cdTo){
        return cdao.mostraNomeRg(cdTo);
    }
    
    public String mostrarNomeIdade(ClienteDTo cdTo){
        return cdao.mostrarNomeIdade(cdTo);
    }

}
