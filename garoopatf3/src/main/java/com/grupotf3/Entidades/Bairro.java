package com.grupotf3.Entidades;

import com.grupotf3.Entidades.Geometria.Area;
import com.grupotf3.Entidades.Geometria.Ponto;

public class Bairro{
    private String nome;
    private Area limites;
    private double custoBasico;

    public static Bairro criaBairro(String nome,Ponto p1,Ponto p2,double custo){
        Area area = new Area(p1, p2);
        return new Bairro(nome, area, custo);
    }


    private Bairro(String nome, Area limites, double custoBasico){
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

    public double getCustoBasico(){
        return custoBasico;
    }

    public Ponto getCentro(){
        int x = limites.getPInfDir().getX()/2;
        int y = limites.getPSupEsq().getY()/2;
        return new Ponto(x,y);
    }

    public String toString(){
        return "Nome do bairro: "+nome+"\nLimites: "+limites+"\nCusto básico: "+custoBasico;
    }
}