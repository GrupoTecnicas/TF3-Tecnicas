package com.grupotf3.CasosDeUso.Repositorios;
import com.grupotf3.Entidades.Motorista;

import org.springframework.stereotype.Component;;

@Component
public interface IRepositorioMotorista{
    Motorista recuperaPorCPF(String cpf);
    void atualizaMotorista(Motorista motorista);
}