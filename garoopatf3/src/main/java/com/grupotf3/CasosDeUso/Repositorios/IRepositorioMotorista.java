package com.grupotf3.CasosDeUso.Repositorios;
import com.grupotf3.Entidades.Motorista;
import java.util.List;

import org.springframework.stereotype.Component;;

@Component
public interface IRepositorioMotorista{
    Motorista recuperaPorCPF(String cpf);
    void atualizaMotorista(Motorista motorista);
    List<Motorista>getLista();
}