package com.grupotf3.Entidades;

public class FactoryVeiculo{
    public static Veiculo criaVeiculo(String placa, String marca, String cor, String cat){
        Veiculo vel = null;
        CategoriaVeiculo c = CategoriaVeiculo.valueOf(cat);
        switch(c){
            case SIMPLES: vel = new VeiculoSimples(placa, marca, cor, c); break;
            case NORMAL: vel = new VeiculoNormal(placa, marca, cor, c); break;
            case LUXO: vel = new VeiculoLuxo(placa, marca, cor, c); break;
        }
        return vel;
    }
}