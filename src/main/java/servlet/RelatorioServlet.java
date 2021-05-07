
package servlet;

import dao.VendaDAO;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RelatorioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dataInicio = request.getParameter("dataInicio");
        String dataFim = request.getParameter("dataFim");
        Date dataInicial = Date.valueOf(dataInicio);
        Date dataFinal = Date.valueOf(dataFim);
        
        int quantidade = VendaDAO.getFilial(dataInicial, dataFinal);
        
        request.setAttribute("quantidade", quantidade);
        
        request.getRequestDispatcher("/listarVendas.jsp").forward(request, response);
    }
}
