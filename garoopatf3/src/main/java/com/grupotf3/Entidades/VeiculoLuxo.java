package com.grupotf3.Entidades;

public class VeiculoLuxo extends Veiculo{
    private String placa, marca, cor;

    private CategoriaVeiculo cat;

    public VeiculoLuxo(String placa, String marca, String cor, CategoriaVeiculo cat){
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
}