package com.grupotf3.CasosDeUso.Repositorios;
import com.grupotf3.Entidades.Motorista;;

public interface IRepositorioMotorista{
    Motorista recuperaPorCPF(String cpf);
    void atualizaMotorista(Motorista motorista);
}