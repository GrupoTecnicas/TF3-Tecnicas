package com.grupotf3.CasosDeUso.Repositorios;

import java.util.List;
import com.grupotf3.Entidades.*;

import org.springframework.stereotype.Component;

@Component
public class RepositorioCidade implements IRepositorioCidade{
    private List<Cidade> cidades;

    public RepositorioCidade(List<Cidade>cidades){
        this.cidades = cidades;
    }

    @Override
    public List<Cidade>getLista(){
        return cidades;
    }

    @Override
    public Cidade recuperaCidade(String nome){
        Cidade c1 = Cidade.criaCidade("Batatinha");
        for(Cidade c : cidades){
            if(c.getNome().equalsIgnoreCase(nome)){
                c1 = c;
            }
        }
        return c1;
    }

    @Override
    public void atualizaCidades(Cidade cidade){
        cidades.add(cidade);
    }
}