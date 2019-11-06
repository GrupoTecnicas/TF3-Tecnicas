package com.grupotf3.Entidades;

public class FactoryVeiculo{
    public static Veiculo criaVeiculo(String placa, String marca, String cor, CategoriaVeiculo cat){
        Veiculo vel = null;
        switch(cat){
            case SIMPLES: vel = new VeiculoSimples(placa, marca, cor, cat); break;
            case NORMAL: vel = new VeiculoNormal(placa, marca, cor, cat); break;
            case LUXO: vel = new VeiculoLuxo(placa, marca, cor, cat); break;
        }
        return vel;
    }
}