
package servlet;

import dao.ClienteDAO;
import entidade.Cliente;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Redirect;

public class AlterarClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer idCliente = Integer.parseInt(request.getParameter("idCliente"));
        Cliente cliente = ClienteDAO.getCliente(idCliente);
        
        request.setAttribute("cliente", cliente);
        request.getRequestDispatcher("/clientes/cadastrar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String cep = request.getParameter("cep");
        String telefone = request.getParameter("telefone");
        String sexo = request.getParameter("sexo");
        String dataForm = request.getParameter("data");
        Integer idCliente = Integer.parseInt(request.getParameter("idCliente"));
        
        Date date = Date.valueOf(dataForm);
        
        Cliente cliente = new Cliente(idCliente, nome, email, cpf, cep, telefone, sexo);
        cliente.setDataCadastro(date);
        boolean ok = ClienteDAO.atualizar(cliente);
        Redirect.sendRedirect(ok, response);
    }
}
