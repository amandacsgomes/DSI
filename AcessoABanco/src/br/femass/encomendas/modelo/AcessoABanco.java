/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.femass.encomendas.modelo;

import br.femass.encomendas.dao.ClienteDAO;
import java.sql.SQLException;

/**
 *
 * @author Amanda
 */
public class AcessoABanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        ClienteDAO clienteDAO = new ClienteDAO();
        
        Cliente cli = new Cliente("11223467212", "João");
        clienteDAO.adicionarCliente(cli);
        
        cli = new Cliente("12345676500", "123321", "Marta", "email@email.com", "2670-7070", "99999-9889", "Brasilia", "45", "Centro", "", "12345123", "Capital", "BR");
        clienteDAO.adicionarCliente(cli);
    }
    
}
