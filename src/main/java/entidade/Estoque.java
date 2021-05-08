
package entidade;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Estoque {
    
    private int idProduto;
    private String nomeFilial;
    private String nomeProduto;
    private int quantidadeProduto;
    private String categoria;
    private double valor;
    private Date dataCadastro;

    public Estoque(int idProduto, String nomeFilial, String nomeProduto, int quantidadeProduto, String categoria, double valor) {
        this.idProduto = idProduto;
        this.nomeFilial = nomeFilial;
        this.nomeProduto = nomeProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.categoria = categoria;
        this.valor = valor;
    }
}
