
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
        String descricao = request.getParameter("descricao");
        double valor = Double.parseDouble(request.getParameter("valor"));
        
        String dataForm = request.getParameter("dataProduto");
        Date data = Date.valueOf(dataForm);

        String filial = request.getParameter("filial");
        
        Produto produto = new Produto(id, codigo, nome, quantidade, descricao, valor, filial);
        produto.setDataProduto(data);
        boolean ok = ProdutoDAO.atualizar(produto);
        Redirect.sendRedirect(ok, response);
    }
}
