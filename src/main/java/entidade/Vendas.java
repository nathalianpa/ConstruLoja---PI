
package entidade;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vendas {
    
    private int idCliente;
    private int idProdutoFilial;

    public Vendas(int idCliente, int idProdutoFilial) {
        this.idCliente = idCliente;
        this.idProdutoFilial = idProdutoFilial;
    }
}
