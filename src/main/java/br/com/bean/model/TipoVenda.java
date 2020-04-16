package br.com.bean.model;

public enum TipoVenda {

    VendaBrinde("Brinde"),
    VendaPadrao("Padrão");

    private String tipo;

    TipoVenda(String tipo){
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
