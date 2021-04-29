
package entidade;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Produto {
    
    private int codigo;
    private String nomeProduto;
    private int quantidadeProduto;
    private String descricao;
    private double valor;

    public Produto(int codigo, String nomeProduto, int quantidadeProduto, String descricao, double valor) {
        this.codigo = codigo;
        this.nomeProduto = nomeProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.descricao = descricao;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" + "código=" + codigo + "nome=" + nomeProduto + ", quantidade=" + quantidadeProduto + ", descrição=" + descricao + ", valor=" + valor + '}';
    }
}
