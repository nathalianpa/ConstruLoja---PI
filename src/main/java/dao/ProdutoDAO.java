
package dao;

import conexao.Conexao;
import entidade.Produto;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO {
    
    public static List<Produto> getProdutos(){
        List<Produto> produtos = new ArrayList<>();
        String query = "select * from Produto";
        Connection con;
        try {
            con = conexao.Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("idProduto");
                int idFilial = rs.getInt("idFilial");
                String nomeFilial = rs.getString("nomeFilial");
                String nomeProduto = rs.getString("nomeProduto");
                int quantidadeProduto = rs.getInt("quantidadeProduto");
                String categoria = rs.getString("categoria");
                double valor = rs.getDouble("valor");
                Date dataCadastro = rs.getDate("dataCadastro");
                Produto produto = new Produto(id, idFilial, nomeFilial, nomeProduto, quantidadeProduto, categoria, valor);
                produto.setDataCadastro(dataCadastro);
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return produtos;
    }
    
    public static boolean cadastrar(Produto produto){
        boolean ok = true;
        
        String query = "insert into Produto (idFilial, nomeFilial, nomeProduto, quantidadeProduto, categoria, valor, dataCadastro) values (?,?,?,?,?,?,?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, produto.getIdFilial());
            ps.setString(2, produto.getNomeFilial());
            ps.setString(3, produto.getNomeProduto());
            ps.setInt(4, produto.getQuantidadeProduto());
            ps.setString(5, produto.getCategoria());
            ps.setDouble(6, produto.getValor());
            ps.setDate(7, produto.getDataCadastro());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
       
        return ok;
    }
    
    public static boolean deletar(int id){
        boolean ok = true;
        String query = "delete from Produto where idProduto=?";
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
    
    public static Produto getProduto(int idProduto){
        Produto produto = null;
        String query = "select * from Produto where idProduto=?";
        Connection con;
        try {
            con = conexao.Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idProduto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idFilial = rs.getInt("idFilial");
                String nomeFilial = rs.getString("nomeFilial");
                String nomeProduto = rs.getString("nomeProduto");
                int quantidadeProduto = rs.getInt("quantidadeProduto");
                String categoria = rs.getString("categoria");
                double valor = rs.getDouble("valor");
                Date dataCadastro = rs.getDate("dataCadastro");
                produto = new Produto(idProduto, idFilial, nomeFilial, nomeProduto, quantidadeProduto, categoria, valor);
                produto.setDataCadastro(dataCadastro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return produto;
    }
    
    public static boolean atualizar(Produto produto){
        boolean ok = true;
        String query = "update Produto set idFilial=?,nomeFilial=?,nomeProduto=?,quantidadeProduto=?,categoria=?,valor=?,dataCadastro=? where idProduto=?";
        Connection con;
        try {
            con = conexao.Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, produto.getIdFilial());
            ps.setString(2, produto.getNomeFilial());
            ps.setString(3, produto.getNomeProduto());
            ps.setInt(4, produto.getQuantidadeProduto());
            ps.setString(5, produto.getCategoria());
            ps.setDouble(6, produto.getValor());
            ps.setDate(7, produto.getDataCadastro());
            ps.setInt(8, produto.getIdProduto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        
        return ok;
    }

    public static List<Produto> getFilial(int idFilial){
        List<Produto> produtos = new ArrayList<>();
        String query = "select * from Produto where idFilial=?";
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
                Produto produto = new Produto(idProduto, idFilial, nomeFilial, nomeProduto, quantidadeProduto, categoria, valor);
                produto.setDataCadastro(dataCadastro);
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return produtos;
    }
}
