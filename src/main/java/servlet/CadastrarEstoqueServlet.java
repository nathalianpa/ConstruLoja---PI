
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
        String nome = request.getParameter("nomeProduto");
        int quantidade = Integer.parseInt(request.getParameter("quantidadeProduto"));
        String categoria = request.getParameter("categoria");
        String imagem = request.getParameter("imagem");
        double valor = Double.parseDouble(request.getParameter("valor"));
        
        String dataForm = request.getParameter("dataCadastro");
        Date data = Date.valueOf(dataForm);
        
        Estoque produto = new Estoque(1, nome, quantidade, categoria, imagem, valor);
        produto.setDataCadastro(data);
        boolean ok = EstoqueDAO.cadastrar(produto);
        
        if(ok){
            response.sendRedirect("../sucesso.jsp");
        }else{
            response.sendRedirect("../erro.jsp");
        }
    }
}
