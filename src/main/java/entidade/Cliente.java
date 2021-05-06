
package entidade;

import java.sql.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {
    
    private Integer idCliente;
    private String nome;
    private String email;
    private String cpf;
    private String cep;
    private String telefone;
    private String sexo;
    private Date dataCadastro;

    public Cliente(Integer idCliente, String nome, String email, String cpf, String cep, String telefone, String sexo) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.cep = cep;
        this.telefone = telefone;
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", cep=" + cep + ", telefone=" + telefone + ", sexo=" + sexo + '}';
    }
}
