package br.com.fiap.OndeAchar.dto;

import br.com.fiap.OndeAchar.model.Produto;

import java.io.Serializable;

public class ProdutoDTO implements Serializable {

    private Integer id;
    private String descricao;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.descricao = produto.getDescricao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
