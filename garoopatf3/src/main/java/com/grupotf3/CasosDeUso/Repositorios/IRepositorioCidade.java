package com.grupotf3.CasosDeUso.Repositorios;

import java.util.List;

import com.grupotf3.Entidades.Cidade;

import org.springframework.stereotype.Component;

@Component
public interface IRepositorioCidade{
    Cidade recuperaCidade(String nome);
    void atualizaCidades(Cidade cidade);
    List<Cidade>getLista();
}