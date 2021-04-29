
package dao;

import conexao.Conexao;
import entidade.Produto;
import java.sql.Connection;
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
        String query = "select * from produto";
        Connection con;
        try {
            con = conexao.Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int codigo = rs.getInt("codigo");
                String nomeProduto = rs.getString("nomeProduto");
                int quantidadeProduto = rs.getInt("quantidadeProduto");
                String descricao = rs.getString("descricao");
                double valor = rs.getDouble("valor");
                Produto produto = new Produto(codigo, nomeProduto, quantidadeProduto, descricao, valor);
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return produtos;
    }
    
    public static boolean cadastrar(Produto produto){
        boolean ok = true;
        
        String query = "insert into produto (codigo, nomeProduto, quantidadeProduto, descricao, valor) values (?,?,?,?,?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, produto.getCodigo());
            ps.setString(2, produto.getNomeProduto());
            ps.setInt(3, produto.getQuantidadeProduto());
            ps.setString(4, produto.getDescricao());
            ps.setDouble(5, produto.getValor());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
       
        return ok;
    }
    
    public static boolean deletar(int codigo){
        boolean ok = true;
        String query = "delete from produto where codigo=?";
        Connection con;
        try {
            con = conexao.Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        
        return ok;
    }
    
    public static Produto getProduto(int idProduto){
        Produto produto = null;
        String query = "select * from produto where codigo=?";
        Connection con;
        try {
            con = conexao.Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idProduto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nomeProduto = rs.getString("nomeProduto");
                int quantidadeProduto = rs.getInt("quantidadeProduto");
                String descricao = rs.getString("descricao");
                double valor = rs.getDouble("valor");
                produto = new Produto(codigo, nomeProduto, quantidadeProduto, descricao, valor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return produto;
    }
    
    public static boolean atualizar(Produto produto){
        boolean ok = true;
        String query = "update Produto set nomeProduto=?,quantidadeProduto=?,descricao=?,valor=? where codigo=?";
        Connection con;
        try {
            con = conexao.Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, produto.getNomeProduto());
            ps.setInt(2, produto.getQuantidadeProduto());
            ps.setString(3, produto.getDescricao());
            ps.setDouble(4, produto.getValor());
            ps.setDouble(5, produto.getCodigo());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        
        return ok;
    }
}
