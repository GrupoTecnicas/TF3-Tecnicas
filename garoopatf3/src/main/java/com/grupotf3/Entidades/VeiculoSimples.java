package com.grupotf3.Entidades;

public class VeiculoSimples extends Veiculo{
    private String placa, marca, cor;

    private CategoriaVeiculo cat;

    public VeiculoSimples(String placa, String marca, String cor, CategoriaVeiculo cat){
        this.placa = placa;
        this.marca = marca;
        this.cor = cor;
        this.cat = cat;
    }

    @Override
    public String getPlaca(){
        return this.placa;
    }

    @Override
    public String getMarca(){
        return this.marca;
    }

    @Override
    public String getCor(){
        return this.cor;
    }

    @Override
    public CategoriaVeiculo getCategoria(){
        return this.cat;
    }

    @Override
    public String toString(){
        return "Placa: "+placa+"\nMarca: "+marca+"\nCor: "+cor+"\nCategoria do veiculo: "+cat;
    }
}