
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
        String filial = request.getParameter("filial");
        
        List<Produto> listaProdutos = ProdutoDAO.getFilial(filial);
        System.out.println(listaProdutos);
        request.setAttribute("listaProdutos", listaProdutos);
        
        request.getRequestDispatcher("../produtosFilial.jsp").forward(request, response);
    }
}
