package com.grupotf3.CasosDeUso.Repositorios;

import java.util.ArrayList;
import java.util.List;

import com.grupotf3.Entidades.Motorista;

import org.springframework.stereotype.Component;


@Component
public class RepositorioMotorista implements IRepositorioMotorista{
    private List<Motorista> motoristas;

    public RepositorioMotorista(List<Motorista> motoristas){
        this.motoristas = motoristas;
    }

    public RepositorioMotorista(){
        motoristas = new ArrayList<>();
    }

    public List<Motorista> getLista(){
        return motoristas;
    }

    @Override
    public Motorista recuperaPorCPF(String cpf){
        for(Motorista m: motoristas){
            if(m.getCPF().equalsIgnoreCase(cpf)){
                return m;
            }
        }
        return null;
    }

    @Override
    public void atualizaMotorista(Motorista motorista){
        motoristas.add(motorista);
    }
}