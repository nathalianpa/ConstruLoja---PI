
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
                int codigo = rs.getInt("codigo");
                String nomeProduto = rs.getString("nomeProduto");
                int quantidadeProduto = rs.getInt("quantidadeProduto");
                String categoria = rs.getString("categoria");
                double valor = rs.getDouble("valor");
                Date dataCadastro = rs.getDate("dataCadastro");
                String filial = rs.getString("filial");
                Produto produto = new Produto(id, codigo, nomeProduto, quantidadeProduto, categoria, valor, filial);
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
        
        String query = "insert into Produto (codigo, nomeProduto, quantidadeProduto, categoria, valor, dataCadastro, filial) values (?,?,?,?,?,?,?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, produto.getCodigo());
            ps.setString(2, produto.getNomeProduto());
            ps.setInt(3, produto.getQuantidadeProduto());
            ps.setString(4, produto.getCategoria());
            ps.setDouble(5, produto.getValor());
            ps.setDate(6, produto.getDataCadastro());
            ps.setString(7, produto.getFilial());
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
                int codigo = rs.getInt("codigo");
                String nomeProduto = rs.getString("nomeProduto");
                int quantidadeProduto = rs.getInt("quantidadeProduto");
                String categoria = rs.getString("categoria");
                double valor = rs.getDouble("valor");
                String filial = rs.getString("filial");
                produto = new Produto(idProduto, codigo, nomeProduto, quantidadeProduto, categoria, valor, filial);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return produto;
    }
    
    public static boolean atualizar(Produto produto){
        boolean ok = true;
        String query = "update Produto set codigo=?,nomeProduto=?,quantidadeProduto=?,categoria=?,valor=?,dataCadastro=?,filial=? where idProduto=?";
        Connection con;
        try {
            con = conexao.Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, produto.getCodigo());
            ps.setString(2, produto.getNomeProduto());
            ps.setInt(3, produto.getQuantidadeProduto());
            ps.setString(4, produto.getCategoria());
            ps.setDouble(5, produto.getValor());
            ps.setDate(6, produto.getDataCadastro());
            ps.setString(7, produto.getFilial());
            ps.setInt(8, produto.getIdProduto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
        
        return ok;
    }

    public static List<Produto> getFilial(String filial){
        List<Produto> produtos = new ArrayList<>();
        String query = "select * from Produto where filial=?";
        Connection con;
        try {
            con = conexao.Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, filial);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idProduto = rs.getInt("idProduto");
                int codigo = rs.getInt("codigo");
                String nomeProduto = rs.getString("nomeProduto");
                int quantidadeProduto = rs.getInt("quantidadeProduto");
                String categoria = rs.getString("categoria");
                double valor = rs.getDouble("valor");
                Date dataCadastro = rs.getDate("dataCadastro");
                Produto produto = new Produto(idProduto, codigo, nomeProduto, quantidadeProduto, categoria, valor, filial);
                produto.setDataCadastro(dataCadastro);
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return produtos;
    }
}
