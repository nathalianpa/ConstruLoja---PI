
package entidade;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoFilial {
    
    private int idProdutoFilial;
    private int idProduto;
    private int idFilial;

    public ProdutoFilial(int idProduto, int idFilial) {
        this.idProduto = idProduto;
        this.idFilial = idFilial;
    }
}
