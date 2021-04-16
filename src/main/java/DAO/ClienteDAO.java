package DAO;

import Conexao.Conexao;
import Model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {

    public static List <Cliente> getClientes(){
        List<Cliente> clientes = new ArrayList<>();
        String query = "select * from cliente";
        Connection con;
        
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                String cep = rs.getString("cep");
                String telefone = rs.getString("telefone");
                String sexo = rs.getString("sexo");
                Cliente cliente = new Cliente(nome, email, cpf, cep, telefone, sexo);
                clientes.add(cliente);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return clientes;
    }
}
