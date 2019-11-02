package com.grupotf3.CasosDeUso.Politicas;

import com.grupotf3.Entidades.*;

public class CustoViagem{
    private Motorista motorista;
    private Passageiro passageiro;
    private double custo;

    public CustoViagem(Motorista motorista, Passageiro passageiro){
        this.motorista = motorista;
        this.passageiro = passageiro;
        custo = 0.0;
    }
/*
    public double calculaCusto(Motorista m){
        switch(m.getVeiculo().getCategoria()){
            case SIMPLES: custo = 39.0; break;
            case NORMAL: custo = 39.0 + ()
        }
        return custo;
    }
*/
    public Motorista getMotorista(){
        return motorista;
    }

    public Passageiro getPassageiro(){
        return passageiro;
    }

    public String toString(){
        return "Motorista: "+motorista.getNome()+"\nPassageiro: "+passageiro.getNome()+"\nCusto: R$"+custo;
    }

}