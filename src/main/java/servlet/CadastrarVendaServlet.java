
package servlet;

import dao.EstoqueDAO;
import entidade.Estoque;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarVendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer idCliente = Integer.parseInt(request.getParameter("idCliente"));
        Integer idProduto = Integer.parseInt(request.getParameter("idProduto"));
        Estoque produto = EstoqueDAO.getEstoque(idProduto);
        
        request.setAttribute("produto", produto);
        request.setAttribute("cliente", idCliente);
        request.getRequestDispatcher("/produtos/cadastrar.jsp").forward(request, response);
    }
}
