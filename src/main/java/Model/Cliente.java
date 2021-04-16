/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author wmdbox
 */

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
    private string sexo;

    public Cliente(String nome, String email, String cpf, String cep, String telefone, String sexo) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.cep = cep;
        this.telefone = telefone;
        
    }

    @Override
    public String toString() {
        return String.format("Nome: %s <br/> E-mail: %s <br/> CPF: %s", nome, email, cpf);
    }
}
