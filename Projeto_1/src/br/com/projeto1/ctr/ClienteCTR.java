/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto1.ctr;

import br.com.projeto1.dao.ClienteDAO;
import br.com.projeto1.dao.ConexaoDAO;
import br.com.projeto1.dto.ClienteDTO;
import java.sql.ResultSet;

/**
 *
 * @author gordoni
 */
public class ClienteCTR {

//    ClienteDTO clienteDTO = new ClienteDTO();
    ClienteDAO clienteDAO = new ClienteDAO();

    public ClienteCTR() {
    }

    public String inserirCliente(ClienteDTO clienteDTO) {
        try {
            if (clienteDAO.inserirCliente(clienteDTO)) {
                return "Cliente cadastrado com sucesso!";
            } else {
                return "Cliente NAO cadastrado!";
            }
        }catch(Exception e){
            System.err.println("Erro: " + e.getMessage());
            return "Cliente NAO cadastrado!";
        }
    }

    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opc){
        ResultSet rs = null;
        
        rs = clienteDAO.consultarCliente(opc, clienteDTO);
        
        return rs;
    }
    
    public void CloseDB(){
        ConexaoDAO.CloseDB();
    }
}
