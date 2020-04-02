package br.com.fiap.OndeAchar.dto;

import br.com.fiap.OndeAchar.model.Necessidade;
import br.com.fiap.OndeAchar.model.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class UsuarioDTO implements Serializable {
    @JsonProperty("necessidade")
    private List<Necessidade> necessidades;

    private String cpf;
    private String nome;
    private Integer cidade;
    private String email;
    private String celular;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String cpf, String nome, Integer cidade, String email, String celular, List<Necessidade> necessidades) {
        this.cpf = cpf;
        this.nome = nome;
        this.cidade = cidade;
        this.email = email;
        this.celular = celular;
        this.necessidades = necessidades;
    }

    public UsuarioDTO(Usuario usuario){
        this.cpf = usuario.getCpf();
        this.nome = usuario.getNome();
        this.cidade = usuario.getCidade();
        this.email = usuario.getEmail();
        this.celular = usuario.getCelular();
        this.necessidades = usuario.getNecessidades();
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

    public void setNecessidade(List<Necessidade> necessidades) {
        this.necessidades = necessidades;
    }
}
