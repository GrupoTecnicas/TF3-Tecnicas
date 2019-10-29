package com.grupotf3;
public class Passageiro{
    private int qtdAval, somaAval;
    private String cpf,nome;

    public Passageiro(String cpf, String nome){
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

    public void setSomaAval(int somaAval){
        this.somaAval = somaAval;
    }

    public String toString(){
        return "Nome: "+nome+"\nCPF: "+cpf+"\nQuantidade de avaliações: "+qtdAval+"\nSomatório das avaliações: "+somaAval;
    }
}