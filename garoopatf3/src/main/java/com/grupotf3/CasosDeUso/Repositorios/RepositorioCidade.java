package com.grupotf3.CasosDeUso.Repositorios;

import java.util.List;
import com.grupotf3.Entidades.*;

public class RepositorioCidade implements IRepositorioCidade{
    private List<Cidade> cidades;

    public RepositorioCidade(List<Cidade>cidades){
        this.cidades = cidades;
    }

    @Override
    public Cidade recuperaCidade(String nome){
        for(Cidade c : cidades){
            if(c.getNome().equals(nome)){
                return c;
            }
        }
        return null;
    }

    @Override
    public void atualizaCidades(Cidade cidade){
        cidades.add(cidade);
    }
}