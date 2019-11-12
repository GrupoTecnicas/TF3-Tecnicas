package com.grupotf3.CasosDeUso.Repositorios;
import com.grupotf3.Entidades.*;

public interface RepositorioPassageiro{
    Passageiro recuperaPorCPF(String cpf);
    void atualizaPassageiro(Passageiro passageiro);
}