
package servlet;


import dao.ProdutoDAO;

import dao.VendasDAO;

import entidade.Produto;

import entidade.Vendas;
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
        String nome = request.getParameter("nomeProduto");
        int quantidade = Integer.parseInt(request.getParameter("quantidadeProduto"));
        String categoria = request.getParameter("categoria");
        String imagem = request.getParameter("imagem");
        double valor = Double.parseDouble(request.getParameter("valor"));
        
        String dataForm = request.getParameter("dataCadastro");
        Date data = Date.valueOf(dataForm);
        
        
        
        double valorTotal = valor * quantidade;
        
        Produto produto = new Produto(idProduto, nome, quantidade, categoria, imagem, valorTotal);
        produto.setDataCadastro(data);
        int IdProduto = ProdutoDAO.cadastrar(produto);
        
        
        
        Vendas venda = new Vendas(idCliente, idProduto);
        boolean okVenda = VendasDAO.cadastrar(venda);
        
        if(okVenda){
            request.getRequestDispatcher("../sucesso.jsp").forward(request, response);
        }
    }
}