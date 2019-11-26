package com.grupotf3.CasosDeUso.Repositorios;

import java.util.ArrayList;
import java.util.List;

import com.grupotf3.Entidades.Passageiro;

import org.springframework.stereotype.Component;


@Component
public class RepositorioPassageiro implements IRepositorioPassageiro{
    private List<Passageiro> passageiros;

    public RepositorioPassageiro(List<Passageiro> passageiros){
        this.passageiros = passageiros;
    }

    public List<Passageiro> getLista(){
        return passageiros;
    }

    @Override
    public Passageiro recuperaPorCPF(String cpf){
        for(Passageiro p: passageiros){
            if(p.getCPF().equalsIgnoreCase(cpf)){
                return p;
            }
        }
        return null;
    }

    @Override
    public void atualizaPassageiro(Passageiro passageiro){
        passageiros.add(passageiro);
    }
}