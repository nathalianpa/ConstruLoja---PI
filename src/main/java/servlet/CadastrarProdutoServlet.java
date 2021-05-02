
package servlet;

import dao.ProdutoDAO;
import entidade.Produto;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarProdutoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String nome = request.getParameter("nome");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        String descricao = request.getParameter("descricao");
        double valor = Double.parseDouble(request.getParameter("valor"));
        
        String dataForm = request.getParameter("data");
        Date data = Date.valueOf(dataForm);
        
        Produto produto = new Produto(-1, codigo, nome, quantidade, descricao, valor);
        produto.setDataProduto(data);
        boolean ok = ProdutoDAO.cadastrar(produto);
        
        if (ok) {
            response.sendRedirect(request.getContextPath() + "/sucesso.jsp");
        }else{
            response.sendRedirect(request.getContextPath() + "/erro.jsp");
        }
    }
}
