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
public class CnhCTR {
    CnhDAO dao = new CnhDAO();
    
    public boolean calcular(CnhDT dto){
        return dao.calcular(dto);
    }
}
