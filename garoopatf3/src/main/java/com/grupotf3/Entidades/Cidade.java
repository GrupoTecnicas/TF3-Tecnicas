package com.grupotf3.Entidades;

import java.util.ArrayList;
import java.util.List;

public class Cidade{
    private String nome;
    private List<Bairro> bairros;

    public static Cidade criaCidade(String nome){
        List<Bairro> bAux = novosBairros();
        return new Cidade(nome, bAux);
    }

    private Cidade(String nome, List<Bairro> bairros){
        this.nome = nome;
        this.bairros = bairros;
    }

    private static List<Bairro> novosBairros(){
        List<Bairro> bairroList = new ArrayList<>();
        bairroList.add(Bairro.criaBairro("Tristeza", 0, 10, 10, 0, 20.0));
        bairroList.add(Bairro.criaBairro("Glória", 0, 20, 20, 10, 10.0));
        bairroList.add(Bairro.criaBairro("Restinga", 40, 40, 60, 30, 12.0));
        bairroList.add(Bairro.criaBairro("Moinhos", 10, 20, 40, 10, 30.0));
        return bairroList;
    }

    public String getNome(){
        return nome;
    }

    public List<Bairro> getBairros(){
        return bairros;
    }

    public String toString(){
        return "Nome da cidade: "+nome+"\nBairros: "+bairros;
    }
}