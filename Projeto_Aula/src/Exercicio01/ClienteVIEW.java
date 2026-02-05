/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercicio01;

import javax.swing.JOptionPane;
/**
 *
 * @author Aluno
 */
public class ClienteVIEW {
    public static void main(String[] args) {
        try{
            ClienteCTR cctr = new ClienteCTR();
            ClienteDTo cdto = new ClienteDTo();
            
            cdto.setNome(JOptionPane.showInputDialog("Informe o seu nome"));
            cdto.setRg(JOptionPane.showInputDialog("Informe o seu RG"));
            cdto.setIdade(Integer.parseInt(JOptionPane.showInputDialog("IUnforme a sua idade")));
            
            JOptionPane.showMessageDialog(null, cctr.mostrarNomeRg(cdto));
            JOptionPane.showMessageDialog(null, cctr.mostrarNomeIdade(cdto));

        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERro: " + e.getMessage());
        }
    }
}
