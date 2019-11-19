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

    public double calculaCusto(Veiculo v, Roteiro roteiro){
        switch(v.getCategoria()){
            case SIMPLES: custo = getCustosBasicos(roteiro); break;
            case NORMAL: custo = getCustosBasicos(roteiro) + (getCustosBasicos(roteiro)*0.1); break;
            case LUXO: custo = getCustosBasicos(roteiro) + (getCustosBasicos(roteiro)*0.1); custo = custo + (custo*percentLuxo(roteiro)); break;
        }
        return custo;
    }

    private double getCustosBasicos(Roteiro roteiro){
        double cont = 0;
        for(Bairro b: roteiro.bairrosPercorridos()){
            cont += b.getCustoBasico();
        }
        return cont;
    }

    private double percentLuxo(Roteiro roteiro){
        double resp = roteiro.bairrosPercorridos().size()*2;
        resp = resp/100;
        return resp;
    }

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