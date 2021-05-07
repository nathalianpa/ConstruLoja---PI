
package servlet;

import dao.VendaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RelatorioClienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        
        int quantidade = VendaDAO.getCliente(idCliente);
        
        request.setAttribute("quantidade", quantidade);
        
        request.getRequestDispatcher("/listarVendas.jsp").forward(request, response);
    }
}
