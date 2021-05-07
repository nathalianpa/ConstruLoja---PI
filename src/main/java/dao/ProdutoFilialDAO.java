
package dao;

import conexao.Conexao;
import entidade.ProdutoFilial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoFilialDAO {
    public static boolean cadastrar(ProdutoFilial produtoFilial){
        boolean ok = true;
        
        String query = "insert into Produto_filial (idProduto, idFilial) values (?,?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, produto.getIdProduto());
            ps.setString(2, produto.getIdFilial());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            ok = false;
        }
       
        return ok;
    }
}
