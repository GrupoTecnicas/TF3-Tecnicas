package com.grupotf3.Entidades;
public class Passageiro{
    private int qtdAval, somaAval;
    private String cpf,nome;

    public static Passageiro novoPassageiro(String cpf, String nome){
        return new Passageiro(cpf,nome);
    }

    private Passageiro(String cpf, String nome){
        this.nome = nome;
        this.cpf = cpf;
        qtdAval = 0;
        somaAval = 0;
    }

    public String getNome(){
        return nome;
    }

    public String getCPF(){
        return cpf;
    }

    public int getQtdAval(){
        return qtdAval;
    }

    public void setQtdAval(int qtdAval){
        this.qtdAval = qtdAval;
    }

    public int getSomaAval(){
        return somaAval;
    }

    public int mediaAval(){
        return (int)Math.floor(somaAval/qtdAval);
    }

    public void setSomaAval(int somaAval){
        this.somaAval = somaAval;
    }

    public String toString(){
        return "Nome: "+nome+"\nCPF: "+cpf+"\nQuantidade de avaliações: "+qtdAval+"\nSomatório das avaliações: "+somaAval;
    }
}