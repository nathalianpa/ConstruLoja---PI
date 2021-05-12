
package dao;

import conexao.Conexao;
import entidade.Vendas;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendasDAO {
    
    public static boolean cadastrar(Vendas venda){
        boolean ok = true;
        
        String query = "insert into Venda(idCliente, idProdutoFilial) values (?,?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, venda.getIdCliente());
            ps.setInt(2, venda.getIdProdutoFilial());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
       
        return ok;
    }
    
    public static double getFilial(Date dataInicial, Date dataFinal, String filial){
        double valor = 0;
        String query = "select sum(Produto.valor) from Produto inner JOIN Filial ON Filial.idFilial = Produto.idProduto where Produto.dataCadastro between ? and ? and Produto.nomeFilial like ?";
        Connection con;
        try {
            con = conexao.Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDate(1, dataInicial);
            ps.setDate(2, dataFinal);
            ps.setString(3, filial);
            ResultSet rs = ps.executeQuery();
            rs.next();
            if(rs.getString(1) == null){
                valor = 0;
            }else{
                valor = Double.parseDouble(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return valor;
    }
    
    public static int getCliente(int idCliente){
        int quantidade = 0;
        String query = "select count(Cliente.nome) from Cliente INNER JOIN Venda ON Venda.idCliente = Cliente.idCliente where Cliente.idCliente like ?";
        Connection con;
        try {
            con = conexao.Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            rs.next();
            quantidade = Integer.parseInt(rs.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return quantidade;
    }
    
    public static double getCategoria(String categoria){
        double valor = 0;
        String query = "select sum(Produto.valor) from Produto inner JOIN Venda ON Venda.idVenda = Produto.idProduto where Produto.categoria like ?";
        Connection con;
        try {
            con = conexao.Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, categoria);
            ResultSet rs = ps.executeQuery();
            rs.next();
            if(rs.getString(1) == null){
                valor = 0;
            }else{
                valor = Double.parseDouble(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return valor;
    }
}
