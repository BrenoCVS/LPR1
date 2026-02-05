/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio03;

/**
 *
 * @author Aluno
 */
public class CnhDAO {
    public boolean calcular(CnhDT dto){
        String msg = "";
        if(dto.getIdade() >= 18){
            return true;
        } else{
            return false;
        }
    }
}
