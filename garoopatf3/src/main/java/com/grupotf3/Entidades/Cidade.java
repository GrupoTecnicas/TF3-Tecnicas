package com.grupotf3.Entidades;

//import java.util.ArrayList;
import java.util.List;

public class Cidade{
    private String nome;
    private List<Bairro> bairros;

    public Cidade(String nome, List<Bairro> bairros){
        this.nome = nome;
        this.bairros = bairros;
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