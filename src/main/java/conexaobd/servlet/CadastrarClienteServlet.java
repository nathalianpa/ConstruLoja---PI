
package conexaobd.servlet;

import conexaobd.dao.ClienteDAO;
import conexaobd.entidade.Cliente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarClienteServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //PASSO 1 - RECUPERAR OS PARAMETROS
        
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String cep = request.getParameter("cep");
        String telefone = request.getParameter("telefone");
        String sexo = request.getParameter("sexo");
        
        //PASSO 2 - INSERIR O CLIENTE NO BD
        Cliente cliente = new Cliente(nome, email, cpf, cep, telefone, sexo);
        boolean ok  = ClienteDAO.cadastrar(cliente);
        
        // PASSO 3 - REDIRECIONAR PARA TELA DE SUCESSO/ERRO
        if (ok) {
            response.sendRedirect(request.getContextPath()+ "/sucesso.jsp");
        } else {
            String msg = "Não foi possível cadastrar o cliente";
            request.setAttribute("msgErro", msg);
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }
    }
}