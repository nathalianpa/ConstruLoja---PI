
package servlet;

import dao.ClienteDAO;
import dao.ProdutoDAO;
import entidade.Cliente;
import entidade.Produto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarregarDadosServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Produto> listaProdutos = ProdutoDAO.getProdutos();
        List<Cliente> listaClientes = ClienteDAO.getClientes();
        
        request.setAttribute("listaProdutos", listaProdutos);
        request.setAttribute("cliente", listaClientes);
        
        request.getRequestDispatcher("cadastrar.jsp").forward(request, response);
    }
}
