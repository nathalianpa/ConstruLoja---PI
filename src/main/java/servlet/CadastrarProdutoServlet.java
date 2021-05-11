
package servlet;

import dao.FilialDAO;
import dao.ProdutoDAO;
import dao.ProdutoFilialDAO;
import dao.VendaDAO;
import entidade.Filial;
import entidade.Produto;
import entidade.ProdutoFilial;
import entidade.Venda;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastrarProdutoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer idProduto = Integer.parseInt(request.getParameter("idProduto"));
        Integer idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nomeFilial = request.getParameter("nomeFilial");
        String nome = request.getParameter("nomeProduto");
        int quantidade = Integer.parseInt(request.getParameter("quantidadeProduto"));
        String categoria = request.getParameter("categoria");
        double valor = Double.parseDouble(request.getParameter("valor"));
        
        String dataForm = request.getParameter("dataCadastro");
        Date data = Date.valueOf(dataForm);
        
        Filial filial = new Filial(idProduto, nomeFilial);
        boolean okFilial = FilialDAO.cadastrar(filial);
        
        double valorTotal = valor * quantidade;
        
        Produto produto = new Produto(idProduto, nomeFilial, nome, quantidade, categoria, valorTotal);
        produto.setDataCadastro(data);
        boolean ok = ProdutoDAO.cadastrar(produto);
        
        ProdutoFilial produtoFilial = new ProdutoFilial(idProduto, idProduto);
        boolean okProdutoFilial = ProdutoFilialDAO.cadastrar(produtoFilial);
        
        Venda venda = new Venda(idCliente, 1);
        boolean okVenda = VendaDAO.cadastrar(venda);
        
        if(okFilial && ok && okProdutoFilial && okVenda){
            request.getRequestDispatcher("../sucesso.jsp").forward(request, response);
        }
    }
}