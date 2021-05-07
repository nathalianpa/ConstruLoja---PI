
package entidade;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Filial {
    
    private String nomeFilial;

    public Filial(String nomeFilial) {
        this.nomeFilial = nomeFilial;
    }
}
