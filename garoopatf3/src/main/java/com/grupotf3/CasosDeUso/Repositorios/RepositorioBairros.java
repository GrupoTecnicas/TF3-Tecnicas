package com.grupotf3.CasosDeUso.Repositorios;

import java.util.ArrayList;
import java.util.List;
import com.grupotf3.Entidades.*;

import org.springframework.stereotype.Component;

@Component
public class RepositorioBairros implements IRepositorioBairros{
    private List<Bairro> bairros;

    public RepositorioBairros(List<Bairro> bairros){
        this.bairros = bairros;
    }

    @Override
    public Bairro recuperaBairro(String nome){
        for(Bairro b : bairros){
            if(b.getNome().equals(nome)){
                return b;
            }
        }
        return null;
    }

    @Override
    public void atualizaBairros(Bairro bairro){
        bairros.add(bairro);
    }


}