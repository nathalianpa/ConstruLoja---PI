
package entidade;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Estoque {
    
    private int idProduto;
    private String nomeProduto;
    private int quantidadeProduto;
    private String categoria;
    private String imagem;
    private double valor;
    private Date dataCadastro;

    public Estoque(int idProduto, String nomeProduto, int quantidadeProduto, String categoria, String imagem, double valor) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.categoria = categoria;
        this.imagem = imagem;
        this.valor = valor;
    }
}
