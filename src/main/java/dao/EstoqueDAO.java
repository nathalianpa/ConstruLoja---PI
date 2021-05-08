
package dao;

import conexao.Conexao;
import entidade.Estoque;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EstoqueDAO {
    
    public static List<Estoque> getEstoques(){
        List<Estoque> produtos = new ArrayList<>();
        String query = "select * from Estoque";
        Connection con;
        try {
            con = conexao.Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("idProduto");
                String nomeFilial = rs.getString("nomeFilial");
                String nomeProduto = rs.getString("nomeProduto");
                int quantidadeProduto = rs.getInt("quantidadeProduto");
                String categoria = rs.getString("categoria");
                double valor = rs.getDouble("valor");
                Date dataCadastro = rs.getDate("dataCadastro");
                Estoque produto = new Estoque(id, nomeFilial, nomeProduto, quantidadeProduto, categoria, valor);
                produto.setDataCadastro(dataCadastro);
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return produtos;
    }
    
    public static boolean cadastrar(Estoque estoque){
        boolean ok = true;
        
        String query = "insert into Estoque (nomeFilial, nomeProduto, quantidadeProduto, categoria, valor, dataCadastro) values (?,?,?,?,?,?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, estoque.getNomeFilial());
            ps.setString(2, estoque.getNomeProduto());
            ps.setInt(3, estoque.getQuantidadeProduto());
            ps.setString(4, estoque.getCategoria());
            ps.setDouble(5, estoque.getValor());
            ps.setDate(6, estoque.getDataCadastro());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
       
        return ok;
    }
    
    public static boolean deletar(int id){
        boolean ok = true;
        String query = "delete from Estoque where idProduto=?";
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
    
    public static Estoque getEstoque(int idProduto){
        Estoque produto = null;
        String query = "select * from Estoque where idProduto=?";
        Connection con;
        try {
            con = conexao.Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idProduto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String nomeFilial = rs.getString("nomeFilial");
                String nomeProduto = rs.getString("nomeProduto");
                int quantidadeProduto = rs.getInt("quantidadeProduto");
                String categoria = rs.getString("categoria");
                double valor = rs.getDouble("valor");
                Date dataCadastro = rs.getDate("dataCadastro");
                produto = new Estoque(idProduto, nomeFilial, nomeProduto, quantidadeProduto, categoria, valor);
                produto.setDataCadastro(dataCadastro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return produto;
    }
    
    public static boolean atualizar(Estoque estoque){
        boolean ok = true;
        String query = "update Estoque set nomeFilial=?,nomeProduto=?,quantidadeProduto=?,categoria=?,valor=?,dataCadastro=? where idProduto=?";
        Connection con;
        try {
            con = conexao.Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, estoque.getNomeFilial());
            ps.setString(2, estoque.getNomeProduto());
            ps.setInt(3, estoque.getQuantidadeProduto());
            ps.setString(4, estoque.getCategoria());
            ps.setDouble(5, estoque.getValor());
            ps.setDate(6, estoque.getDataCadastro());
            ps.setInt(7, estoque.getIdProduto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        
        return ok;
    }

    public static List<Estoque> getFilial(int idFilial){
        List<Estoque> produtos = new ArrayList<>();
        String query = "select * from Estoque where idFilial=?";
        Connection con;
        try {
            con = conexao.Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idFilial);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idProduto = rs.getInt("idProduto");
                String nomeFilial = rs.getString("nomeFilial");
                String nomeProduto = rs.getString("nomeProduto");
                int quantidadeProduto = rs.getInt("quantidadeProduto");
                String categoria = rs.getString("categoria");
                double valor = rs.getDouble("valor");
                Date dataCadastro = rs.getDate("dataCadastro");
                Estoque produto = new Estoque(idProduto, nomeFilial, nomeProduto, quantidadeProduto, categoria, valor);
                produto.setDataCadastro(dataCadastro);
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return produtos;
    }
}
