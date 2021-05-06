
package servlet;

import dao.ClienteDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcluirClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer idCliente = Integer.parseInt(request.getParameter("idCliente"));
        boolean ok = ClienteDAO.deletar(idCliente);
        response.setStatus(ok? 200:500);
    }
}