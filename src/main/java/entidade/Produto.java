
package entidade;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {
    
    private int idProduto;
    private int codigo;
    private String nomeProduto;
    private int quantidadeProduto;
    private String categoria;
    private double valor;
    private Date dataCadastro;
    private String filial;

    public Produto(int idProduto, int codigo, String nomeProduto, int quantidadeProduto, String categoria, double valor, String filial) {
        this.idProduto = idProduto;
        this.codigo = codigo;
        this.nomeProduto = nomeProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.categoria = categoria;
        this.valor = valor;
        this.filial = filial;
    }

    @Override
    public String toString() {
        return "Produto{" + "código=" + codigo + "nome=" + nomeProduto + ", quantidade=" + quantidadeProduto + ", categoria=" + categoria + ", valor=" + valor + '}';
    }
}
