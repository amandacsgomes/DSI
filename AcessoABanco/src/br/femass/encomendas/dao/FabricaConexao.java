/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.femass.encomendas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Amanda
 */
public class FabricaConexao {

    public Connection getConexao() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/DSI","postgres","postgresql");
} catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}