
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
    }

    @Override
    public String toString() {
        return String.format("Nome: %s%n", getNome(),
                             "Email: %s%n", getEmail(),
                             "Cpf: %s%n", getCpf(),
                             "Cep: %s%n", getCep(),
                             "Telefone: %s%n", getTelefone(),
                             "Sexo: %s%n", getSexo());
    }
}