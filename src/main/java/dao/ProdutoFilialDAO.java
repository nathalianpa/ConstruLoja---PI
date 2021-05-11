
package dao;

import conexao.Conexao;
import entidade.ProdutoFilial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoFilialDAO {
    
    public static int cadastrar(ProdutoFilial produtoFilial){
        int id = 0;
        String query = "insert into Produto_filial(idProduto,idFilial) values (?,?)";
        Connection con;
        try {
            con = Conexao.getConexao();
            PreparedStatement ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, produtoFilial.getIdProduto());
            ps.setInt(2, produtoFilial.getIdFilial());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            id = Integer.parseInt(rs.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return id;
    }
}
