package com.grupotf3;

public class Bairros{
    private String nome;
    private Area limites;
    private int custoBasico;

    public Bairro(String nome, Area limites, int custoBasico){
        this.nome = nome;
        this.limites = limites;
        this.custoBasico = custoBasico;
    }

    public String getNome(){
        return nome;
    }

    public Area getLimites(){
        return limites;
    }

    public int getCustoBasico(){
        return custoBasico;
    }

    public String toString(){
        return "Nome do bairro: "+nome+"\nLimites: "+limites+"\nCusto básico: "+custoBasico;
    }
}