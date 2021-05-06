
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

public class CarregarClientesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String filial = request.getParameter("filial");
        
        List<Cliente> listaClientes = ClienteDAO.getClienteVenda(idCliente);
        List<Produto> listaProdutos = ProdutoDAO.getFilial(filial);
        
        request.setAttribute("cliente", listaClientes);
        request.setAttribute("listaProdutos", listaProdutos);
        
        request.getRequestDispatcher("cadastrar.jsp").forward(request, response);
    }
}
