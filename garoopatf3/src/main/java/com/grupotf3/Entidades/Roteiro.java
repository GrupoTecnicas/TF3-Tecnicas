package com.grupotf3.Entidades;

import java.util.ArrayList;

import com.grupotf3.Entidades.Geometria.*;

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

    public ArrayList<Bairro> getBairros(){
        Ponto p1 = bOrigem.getCentro();
        Ponto p2 = bDestino.getCentro();
        Reta r = new Reta(p1,p2);
        ArrayList<Bairro> aux = new ArrayList<>();
        if(bOrigem.getNome().equals(bDestino.getNome())){
            aux.add(bOrigem);
        }
        else{
            for (Bairro b : cidade.getBairros()) {
                if(b.getLimites().classifica(r) == SituacaoReta.INTERSECTA){
                    aux.add(b);
                }
            }
        }
        return aux;
    }

    public String toString(){
        return "Cidade: "+cidade.getNome()+"\nBairro origem: "+bOrigem.getNome()+"\nBairro destino: "+bDestino.getNome();
    }
}