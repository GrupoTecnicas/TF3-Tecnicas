package com.grupotf3.CasosDeUso.Repositorios;

import com.grupotf3.Entidades.Bairro;

import org.springframework.stereotype.Component;

@Component
public interface IRepositorioBairros{
    Bairro recuperaBairro(String nome);
    void atualizaBairros(Bairro bairro);
}