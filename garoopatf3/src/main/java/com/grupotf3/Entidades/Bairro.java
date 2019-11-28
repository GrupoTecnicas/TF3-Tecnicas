package com.grupotf3.Entidades;

import com.grupotf3.Entidades.Geometria.Area;
import com.grupotf3.Entidades.Geometria.Ponto;

public class Bairro{
    private String nome;
    private Area limites;
    private double custoBasico;

    public static Bairro criaBairro(String nome,int x1,int y1,int x2, int y2,double custo){
        Ponto p1 = new Ponto(x1,y1);
        Ponto p2 = new Ponto(x2,y2);
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