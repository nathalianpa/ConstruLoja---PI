
package servlet;

import dao.FilialDAO;
import dao.ProdutoDAO;
import entidade.Filial;
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
        String nomeFilial = request.getParameter("nomeFilial");
        String nome = request.getParameter("nomeProduto");
        int quantidade = Integer.parseInt(request.getParameter("quantidadeProduto"));
        String categoria = request.getParameter("categoria");
        double valor = Double.parseDouble(request.getParameter("valor"));
        
        String dataForm = request.getParameter("dataCadastro");
        Date data = Date.valueOf(dataForm);

        Filial filial = new Filial(2, nomeFilial);
        boolean okFilial = FilialDAO.cadastrar(filial);
        
        Produto produto = new Produto(2, nomeFilial, nome, quantidade, categoria, valor);
        produto.setDataCadastro(data);
        boolean ok = ProdutoDAO.cadastrar(produto);

        if(ok && okFilial){
            RedirectProduto.sendRedirect(okFilial, response);
        }
    }
}
