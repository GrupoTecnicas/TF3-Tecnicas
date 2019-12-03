package com.grupotf3.CasosDeUso.Repositorios;
import com.grupotf3.Entidades.Viagem;

import org.springframework.stereotype.Component;

import com.grupotf3.Entidades.Motorista;
import java.util.List;


@Component
public interface IRepositorioViagem{
    void cadastraViagem(Viagem viagem);
    List<Viagem> getViagens(Motorista motorista);
    List<Viagem> getTodasViagens();
}