
package entidade;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Filial {
    
    private int idFilial;
    private String nomeFilial;

    public Filial(int idFilial, String nomeFilial) {
        this.idFilial = idFilial;
        this.nomeFilial = nomeFilial;
    }
}
