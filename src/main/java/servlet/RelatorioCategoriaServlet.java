
package servlet;

import dao.VendasDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RelatorioCategoriaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String categoria = request.getParameter("categoria");
        
        double valor = VendasDAO.getCategoria(categoria);
        int quantidade = VendasDAO.getCategoriaQuantidade(categoria);
        
        request.setAttribute("valor", valor);
        request.setAttribute("quantidade", quantidade);
        
        request.getRequestDispatcher("/listarVendas.jsp").forward(request, response);
    }
}
