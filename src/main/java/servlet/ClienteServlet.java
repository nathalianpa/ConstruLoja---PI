
package servlet;

import dao.ClienteDAO;
import entidade.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Cliente> listaClientes = ClienteDAO.getClientes();
        
        request.setAttribute("listaClientes", listaClientes);
        
        request.getRequestDispatcher("/listaClientes.jsp").forward(request, response);
    }
}
