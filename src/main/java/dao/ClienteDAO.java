
package dao;

import conexao.Conexao;
import entidade.Cliente;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {
    
    public static List<Cliente> getClientes(){
        List<Cliente> clientes = new ArrayList<>();
        String query = "select * from cliente";
        Connection con;
        try {
            con = conexao.Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Integer id = rs.getInt("id");
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                String cep = rs.getString("cep");
                String telefone = rs.getString("telefone");
                String sexo = rs.getString("sexo");
                Date dataCadastro = rs.getDate("dataCadastro");
                Cliente cliente = new Cliente(id, nome, email, cpf, cep, telefone, sexo);
                cliente.setDataCadastro(dataCadastro);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clientes;
    }
    
    public static boolean cadastrar(Cliente cliente, Date dataCadastro){
        boolean ok = true;
        
        String query = "insert into cliente (nome, email, cpf, cep, telefone, sexo, dataCadastro) values (?,?,?,?,?,?,?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getCep());
            ps.setString(5, cliente.getTelefone());
            ps.setString(6, cliente.getSexo());
            ps.setDate(7, dataCadastro);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
       
        return ok;
    }
    
    public static boolean deletar(Integer id){
        boolean ok = true;
        String query = "delete from cliente where id=?";
        Connection con;
        try {
            con = conexao.Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        
        return ok;
    }
    
    public static Cliente getCliente(Integer id){
        Cliente cliente = null;
        String query = "select * from cliente where id=?";
        Connection con;
        try {
            con = conexao.Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                String cep = rs.getString("cep");
                String telefone = rs.getString("telefone");
                String sexo = rs.getString("sexo");
                cliente = new Cliente(id, nome, email, cpf, cep, telefone, sexo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cliente;
    }
    
    public static boolean atualizar(Cliente cliente){
        boolean ok = true;
        String query = "update cliente set nome=?,email=?,cpf=?,cep=?,telefone=?,sexo=?,dataCadastro=? where id=?";
        Connection con;
        try {
            con = conexao.Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getCep());
            ps.setString(5, cliente.getTelefone());
            ps.setString(6, cliente.getSexo());
            ps.setDate(7, cliente.getDataCadastro());
            ps.setInt(8, cliente.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        
        return ok;
    }
    
    public static List<Cliente> getClienteVenda(Integer id){
        List<Cliente> clientes = new ArrayList<>();
        String query = "select * from cliente where id=?";
        Connection con;
        try {
            con = conexao.Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nome = rs.getString("nome");
                String email = rs.getString("email");
                String cpf = rs.getString("cpf");
                String cep = rs.getString("cep");
                String telefone = rs.getString("telefone");
                String sexo = rs.getString("sexo");
                Date dataCadastro = rs.getDate("dataCadastro");
                Cliente cliente = new Cliente(id, nome, email, cpf, cep, telefone, sexo);
                cliente.setDataCadastro(dataCadastro);
                clientes.add(cliente);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clientes;
    }
}
