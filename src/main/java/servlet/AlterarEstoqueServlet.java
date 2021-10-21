
package servlet;

import dao.EstoqueDAO;
import entidade.Estoque;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Redirect;

public class AlterarEstoqueServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer idProduto = Integer.parseInt(request.getParameter("idProduto"));
        Estoque produto = EstoqueDAO.getEstoque(idProduto);
        
        request.setAttribute("produto", produto);
        request.getRequestDispatcher("/estoque/cadastrar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idProduto"));
        String nome = request.getParameter("nomeProduto");
        int quantidade = Integer.parseInt(request.getParameter("quantidadeProduto"));
        String categoria = request.getParameter("categoria");
        String imagem = request.getParameter("imagem");
        double valor = Double.parseDouble(request.getParameter("valor"));
        
        String dataForm = request.getParameter("dataCadastro");
        Date data = Date.valueOf(dataForm);

        Estoque produto = new Estoque(id, nome, quantidade, categoria, imagem ,valor);
        produto.setDataCadastro(data);
        boolean ok = EstoqueDAO.atualizar(produto);
        Redirect.sendRedirect(ok, response);
    }
}
