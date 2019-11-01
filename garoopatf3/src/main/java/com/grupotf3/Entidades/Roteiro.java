package com.grupotf3.Entidades;

public class Roteiro{
    private Cidade cidade;
    private Bairro bOrigem, bDestino;

    public Roteiro(Cidade cidade, Bairro bOrigem, Bairro bDestino){
        this.cidade = cidade;
        this.bOrigem = bOrigem;
        this.bDestino = bDestino;
    }

    public Cidade getCidade(){
        return cidade;
    }

    public Bairro getOrigem(){
        return bOrigem;
    }

    public Bairro getDestino(){
        return bDestino;
    }

    public String toString(){
        return "Cidade: "+cidade.getNome()+"\nBairro origem: "+bOrigem.getNome()+"\nBairro destino: "+bDestino.getNome();
    }
}