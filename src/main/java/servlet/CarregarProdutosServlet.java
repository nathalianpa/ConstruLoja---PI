
package servlet;

import dao.ProdutoDAO;
import entidade.Produto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarregarProdutosServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idFilial = Integer.parseInt(request.getParameter("idFilial"));
        
        List<Produto> listaProdutos = ProdutoDAO.getFilial(idFilial);
        
        request.setAttribute("listaProdutos", listaProdutos);
        
        request.getRequestDispatcher("cadastrar.jsp").forward(request, response);
    }
}
