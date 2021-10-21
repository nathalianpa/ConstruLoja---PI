
package entidade;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {
    
    private int idProduto;
    private String nomeProduto;
    private int quantidadeProduto;
    private String categoria;
    private String imagem;
    private double valor;
    private Date dataCadastro;

    public Produto(int idProduto, String nomeProduto, int quantidadeProduto, String categoria, String imagem, double valor) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.categoria = categoria;
        this.imagem = imagem;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nomeProduto + ", quantidade=" + quantidadeProduto + ", categoria=" + categoria + ", imagem=" + imagem + ", valor=" + valor + '}';
    }
}
