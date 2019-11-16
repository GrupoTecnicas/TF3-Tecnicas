package com.grupotf3.CasosDeUso.Repositorios;

import java.util.List;
import java.util.ArrayList;
import com.grupotf3.Entidades.Motorista;
import com.grupotf3.Entidades.Viagem;

public class RepositorioViagem implements IRepositorioViagem{
    private List<Viagem> viagens;

    public RepositorioViagem(List<Viagem> viagens){
        this.viagens = viagens;
    }

    @Override
    public void cadastraViagem(Viagem viagem){
        viagens.add(viagem);
    }

    @Override
    public List<Viagem> getViagens(Motorista m){
        List<Viagem> aux = new ArrayList<>();

        for(Viagem v : viagens){
            if(v.getMotorista().getCPF().equals(m.getCPF())){
                aux.add(v);
            }
        }
        return aux;
    }
}