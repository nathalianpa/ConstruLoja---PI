
package servlet;

import dao.ProdutoDAO;
import entidade.Produto;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.Redirect;

public class AlterarProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer idProduto = Integer.parseInt(request.getParameter("idProduto"));
        Produto produto = ProdutoDAO.getProduto(idProduto);
        
        request.setAttribute("produto", produto);
        request.getRequestDispatcher("/produtos/cadastrar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idProduto"));
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String nome = request.getParameter("nome");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        String categoria = request.getParameter("categoria");
        double valor = Double.parseDouble(request.getParameter("valor"));
        
        String dataForm = request.getParameter("dataCadastro");
        Date data = Date.valueOf(dataForm);

        String filial = request.getParameter("filial");
        
        Produto produto = new Produto(id, codigo, nome, quantidade, categoria, valor, filial);
        produto.setDataCadastro(data);
        boolean ok = ProdutoDAO.atualizar(produto);
        Redirect.sendRedirect(ok, response);
    }
}
