package com.grupotf3.CasosDeUso.Repositorios;
import com.grupotf3.Entidades.Passageiro;

public interface IRepositorioPassageiro{
    Passageiro recuperaPorCPF(String cpf);
    void atualizaPassageiro(Passageiro passageiro);
}