
package entidade;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {
    
    private int idProduto;
    private String nomeFilial;
    private String nomeProduto;
    private int quantidadeProduto;
    private String categoria;
    private double valor;
    private Date dataCadastro;

    public Produto(int idProduto, String nomeFilial, String nomeProduto, int quantidadeProduto, String categoria, double valor) {
        this.idProduto = idProduto;
        this.nomeFilial = nomeFilial;
        this.nomeProduto = nomeProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.categoria = categoria;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nomeProduto + ", quantidade=" + quantidadeProduto + ", categoria=" + categoria + ", valor=" + valor + '}';
    }
}
