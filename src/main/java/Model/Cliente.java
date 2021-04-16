
package Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {
    
    private String nome;
    private String email;
    private String cpf;
    private String cep;
    private String telefone;
    private String sexo;

    public Cliente(String nome, String email, String cpf, String cep, String telefone, String sexo) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.cep = cep;
        this.telefone = telefone;
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s <br/> %s%s <br/> %s%s <br/> %s%s <br/> %s%s <br/> %s%s", getNome(), 
                             "Email: ", getEmail(),
                             "CPF: ", getCpf(), 
                             "CEP: ", getCep(),
                             "Telefone: ", getTelefone(),
                             "Sexo: ", getSexo());
    }
}