package br.com.fiap.OndeAchar.model;

public class Necessidade {

    Integer idProduto;
    String mensagem;

    public Necessidade(Integer idProduto, String mensagem) {
        this.idProduto = idProduto;
        this.mensagem = mensagem;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
