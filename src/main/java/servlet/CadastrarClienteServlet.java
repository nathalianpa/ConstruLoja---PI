
package servlet;

import dao.ClienteDAO;
import entidade.Cliente;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarClienteServlet extends HttpServlet {

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
        Date date = Date.valueOf(dataForm);
        
        Cliente cliente = new Cliente(-1, nome, email, cpf, cep, telefone, sexo);
        boolean ok = ClienteDAO.cadastrar(cliente, date);
        
        if (ok) {
            response.sendRedirect(request.getContextPath() + "/sucesso.jsp");
        }else{
            response.sendRedirect(request.getContextPath() + "/erro.jsp");
        }
    }
}