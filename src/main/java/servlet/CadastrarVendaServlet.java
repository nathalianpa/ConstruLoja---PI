
package servlet;

import dao.EstoqueDAO;
import entidade.Estoque;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarVendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Estoque> listaProdutos = EstoqueDAO.getEstoques();
        
        request.setAttribute("listaProdutos", listaProdutos);
        
        request.getRequestDispatcher("/produtos/cadastrar.jsp").forward(request, response);
    }
}
