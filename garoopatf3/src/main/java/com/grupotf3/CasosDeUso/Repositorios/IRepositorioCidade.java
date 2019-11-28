package com.grupotf3.CasosDeUso.Repositorios;

import com.grupotf3.Entidades.Cidade;

import org.springframework.stereotype.Component;

@Component
public interface IRepositorioCidade{
    Cidade recuperaCidade(String nome);
    void atualizaCidades(Cidade cidade);
}