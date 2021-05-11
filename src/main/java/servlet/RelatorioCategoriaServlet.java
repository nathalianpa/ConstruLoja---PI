
package servlet;

import dao.VendaDAO;
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
        
        double quantidade = VendaDAO.getCategoria(categoria);
        
        request.setAttribute("quantidade", quantidade);
        
        request.getRequestDispatcher("/listarVendas.jsp").forward(request, response);
    }
}
