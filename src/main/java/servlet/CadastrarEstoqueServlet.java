
package servlet;

import dao.EstoqueDAO;
import entidade.Estoque;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarEstoqueServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nomeFilial = request.getParameter("nomeFilial");
        String nome = request.getParameter("nomeProduto");
        int quantidade = Integer.parseInt(request.getParameter("quantidadeProduto"));
        String categoria = request.getParameter("categoria");
        double valor = Double.parseDouble(request.getParameter("valor"));
        
        String dataForm = request.getParameter("dataCadastro");
        Date data = Date.valueOf(dataForm);
        
        Estoque produto = new Estoque(1, nomeFilial, nome, quantidade, categoria, valor);
        produto.setDataCadastro(data);
        boolean ok = EstoqueDAO.cadastrar(produto);
        
        if(ok){
            request.getRequestDispatcher("../sucesso.jsp").forward(request, response);
        }
    }
}
