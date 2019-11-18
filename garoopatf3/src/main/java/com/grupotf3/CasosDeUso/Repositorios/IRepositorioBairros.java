package com.grupotf3.CasosDeUso.Repositorios;

import com.grupotf3.Entidades.Bairro;

public interface IRepositorioBairros{
    Bairro recuperaBairro(String nome);
    void atualizaBairros(Bairro bairro);
}