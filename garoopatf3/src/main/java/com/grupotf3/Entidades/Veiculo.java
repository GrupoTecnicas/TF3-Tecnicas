package com.grupotf3.Entidades;
public class Veiculo{
    enum CategoriaVeiculo{
        SIMPLES, NORMAL, LUXO;
    }

    private String placa,marca,cor;

    private CategoriaVeiculo cat;

    private boolean catInferior, portaMalasGrande;

    public Veiculo(String placa, String marca, String cor, CategoriaVeiculo cat){
        this.placa = placa;
        this.marca = marca;
        this.cor = cor;
        this.cat = cat;
        catInferior = setCatInferior(cat);
        portaMalasGrande = setPortaMalas(cat);
    }

    private boolean setCatInferior(CategoriaVeiculo cat){
        switch(cat){
            case SIMPLES: return false;
            default: return true;
        }
    }

    private boolean setPortaMalas(CategoriaVeiculo cat){
        switch(cat){
            case LUXO: return true;
            default: return false;
        }
    }

    public boolean getCategoriaInferior(){
        return catInferior;
    }

    public boolean getPortaMalas(){
        return portaMalasGrande;
    }

    public String getPlaca(){
        return placa;
    }

    public String getMarca(){
        return marca;
    }

    public String getCor(){
        return cor;
    }

    public CategoriaVeiculo getCategoria(){
        return cat;
    }

    public String toString(){
        return "Placa: "+placa+"\nMarca: "+marca+"\nCor: "+cor+"\nCategoria do veiculo: "+cat+"\nAtende categoria inferior? "+catInferior+"\nTem porta malas grande? "+portaMalasGrande;
    }
}