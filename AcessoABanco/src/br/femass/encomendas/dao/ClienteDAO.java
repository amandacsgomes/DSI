/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.femass.encomendas.dao;

import br.femass.encomendas.modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Amanda
 */
public class ClienteDAO {
// a conexão com o banco de dados

    private Connection conexao;

    public ClienteDAO() {
        this.conexao = new FabricaConexao().getConexao();
    }

    public void adicionarCliente(Cliente c) throws SQLException {
// conectando
// cria um preparedStatement 
        String sql = "insert into cliente(cpf,nome,rg,email,telefone,celular,logradouro,"
                + "numero,bairro,complemento,cidade,uf) values( ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
// preenche os valores
        stmt.setString(1, c.getCpf());
        stmt.setString(2, c.getNome());
        stmt.setString(3, c.getRg());
        stmt.setString(4, c.getEmail());
        stmt.setString(5, c.getTelefone());
        stmt.setString(6, c.getCelular());
        stmt.setString(7, c.getLogradouro());
        stmt.setString(8, c.getNumero());
        stmt.setString(9, c.getBairro());
        stmt.setString(10, c.getComplemento());
        stmt.setString(11, c.getCidade());
        stmt.setString(12, c.getUf());
        
        stmt.execute();
    }
}
