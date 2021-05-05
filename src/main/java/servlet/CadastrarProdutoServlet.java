
package servlet;

import dao.ProdutoDAO;
import entidade.Produto;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.RedirectProduto;

public class CadastrarProdutoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        String nome = request.getParameter("nome");
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        String categoria = request.getParameter("categoria");
        double valor = Double.parseDouble(request.getParameter("valor"));
        
        String dataForm = request.getParameter("data");
        Date data = Date.valueOf(dataForm);

        String filial = request.getParameter("filial");

        Produto produto = new Produto(-1, codigo, nome, quantidade, categoria, valor, filial);
        produto.setDataCadastro(data);
        boolean ok = ProdutoDAO.cadastrar(produto);
        RedirectProduto.sendRedirect(ok, response);
    }
}
