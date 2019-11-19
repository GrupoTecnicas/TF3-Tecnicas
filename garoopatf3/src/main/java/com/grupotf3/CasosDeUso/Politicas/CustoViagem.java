package com.grupotf3.CasosDeUso.Politicas;

import com.grupotf3.Entidades.*;

public class CustoViagem{
    private double custo;

    public CustoViagem(){
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

    public double getCusto(){
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

}