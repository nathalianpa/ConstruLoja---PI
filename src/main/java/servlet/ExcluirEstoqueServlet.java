
package servlet;

import dao.EstoqueDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcluirEstoqueServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idProduto"));
        boolean ok = EstoqueDAO.deletar(id);
        response.setStatus(ok? 200:500);
    }
}
