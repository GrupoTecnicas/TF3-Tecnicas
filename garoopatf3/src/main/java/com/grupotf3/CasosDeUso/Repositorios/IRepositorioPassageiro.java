package com.grupotf3.CasosDeUso.Repositorios;
import com.grupotf3.Entidades.Passageiro;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface IRepositorioPassageiro{
    Passageiro recuperaPorCPF(String cpf);
    void atualizaPassageiro(Passageiro passageiro);
    List<Passageiro>getLista();
}