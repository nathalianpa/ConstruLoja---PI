package br.senac.sp.conexaobd.entidade;

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
    
    public boolean validarCPF() {
        return true;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s <br/> Email: %s <br/> CPF: %s", nome, email, cpf);
    }
}
