
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
                String nomeProduto = rs.getString("nomeProduto");
                int quantidadeProduto = rs.getInt("quantidadeProduto");
                String categoria = rs.getString("categoria");
                String imagem = rs.getString("imagem");
                double valor = rs.getDouble("valor");
                Date dataCadastro = rs.getDate("dataCadastro");
                Produto produto = new Produto(id, nomeProduto, quantidadeProduto, categoria,imagem, valor);
                produto.setDataCadastro(dataCadastro);
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return produtos;
    }
    
    public static int cadastrar(Produto produto){
        int id = 0;
        String query = "insert into Produto (nomeProduto, quantidadeProduto, categoria, imagem,  valor, dataCadastro) values (?,?,?,?,?,?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, produto.getNomeProduto());
            ps.setInt(2, produto.getQuantidadeProduto());
            ps.setString(3, produto.getCategoria());
            ps.setString(4, produto.getImagem());
            ps.setDouble(5, produto.getValor());
            ps.setDate(6, produto.getDataCadastro());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            id = Integer.parseInt(rs.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return id;
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
                String nomeProduto = rs.getString("nomeProduto");
                int quantidadeProduto = rs.getInt("quantidadeProduto");
                String categoria = rs.getString("categoria");
                String imagem = rs.getString("imagem");
                double valor = rs.getDouble("valor");
                Date dataCadastro = rs.getDate("dataCadastro");
                produto = new Produto(idProduto, nomeProduto, quantidadeProduto, categoria, imagem, valor);
                produto.setDataCadastro(dataCadastro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return produto;
    }
    
    public static boolean atualizar(Produto produto){
        boolean ok = true;
        String query = "update Produto set nomeProduto=?,quantidadeProduto=?,categoria=?,imagem=?,valor=?,dataCadastro=? where idProduto=?";
        Connection con;
        try {
            con = conexao.Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            
            ps.setString(1, produto.getNomeProduto());
            ps.setInt(2, produto.getQuantidadeProduto());
            ps.setString(3, produto.getCategoria());
            ps.setString(4, produto.getImagem());
            ps.setDouble(5, produto.getValor());
            ps.setDate(6, produto.getDataCadastro());
            ps.setInt(7, produto.getIdProduto());
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
                
                String nomeProduto = rs.getString("nomeProduto");
                int quantidadeProduto = rs.getInt("quantidadeProduto");
                String categoria = rs.getString("categoria");
                String imagem = rs.getString("imagem");
                double valor = rs.getDouble("valor");
                Date dataCadastro = rs.getDate("dataCadastro");
                Produto produto = new Produto(idProduto, nomeProduto, quantidadeProduto, categoria,imagem, valor);
                produto.setDataCadastro(dataCadastro);
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return produtos;
    }
}
