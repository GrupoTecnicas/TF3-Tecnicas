package com.grupotf3.CasosDeUso.Politicas;

import com.grupotf3.CasosDeUso.Repositorios.*;
import com.grupotf3.Entidades.*;

public class SelecaoMotorista{
    private RepositorioMotorista motoristas;

    private SelecaoMotorista(RepositorioMotorista motoristas){
        this.motoristas = motoristas;
    }

    public Motorista getMotorista(String cpf){
        return motoristas.recuperaPorCPF(cpf);
    }
}