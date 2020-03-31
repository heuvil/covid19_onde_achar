package br.com.fiap.OndeAchar.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "usuario")
public class Usuario {

    @Id
    private String cpf;
    private String nome;
    private Integer cidade;
    private String email;
    private String celular;
    private List<Necessidade> necessidades;

    public Usuario(String cpf, String nome, Integer cidade, String email, String celular, List<Necessidade> necessidades) {
        this.cpf = cpf;
        this.nome = nome;
        this.cidade = cidade;
        this.email = email;
        this.celular = celular;
        this.necessidades = necessidades;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCidade() {
        return cidade;
    }

    public void setCidade(Integer cidade) {
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public List<Necessidade> getNecessidades() {
        return necessidades;
    }

    public void setNecessidades(List<Necessidade> necessidades) {
        this.necessidades = necessidades;
    }
}
