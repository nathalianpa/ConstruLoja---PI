
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

public class CarregarClientesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer idCliente = Integer.parseInt(request.getParameter("idCliente"));
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
        
        ProdutoFilial produtoFilial = new ProdutoFilial(4, 4);
        boolean okProdutoFilial = ProdutoFilialDAO.cadastrar(produtoFilial);
        
        Venda venda = new Venda(idCliente, 3);
        boolean okVenda = VendaDAO.cadastrar(venda);
        
        request.getRequestDispatcher("../sucesso.jsp").forward(request, response);
    }
}


 //List<Cliente> listaClientes = ClienteDAO.getClienteVenda(idCliente);
        //List<Produto> listaProdutos = ProdutoDAO.getFilial(filial);
        //request.setAttribute("cliente", listaClientes);
       // request.setAttribute("listaProdutos", listaProdutos);
        