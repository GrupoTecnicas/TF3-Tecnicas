package com.grupotf3.CasosDeUso.Politicas;

import com.grupotf3.CasosDeUso.Repositorios.*;
import com.grupotf3.Entidades.*;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class SelecaoMotorista{
    private RepositorioMotorista motoristas;

    private SelecaoMotorista(RepositorioMotorista motoristas){
        this.motoristas = motoristas;
    }

    public Motorista selecionaMotoristaParaViagem(String categoriaVeiculo){
        Random rand = new Random();
        List<Motorista> list = listaCat(categoriaVeiculo);
        int index = rand.nextInt(list.size());
        return list.get(index);
    }

    private List<Motorista> listaCat(String categoria){
        List<Motorista> lista = new ArrayList<>();
        for(Motorista m : motoristas.getLista()){
            if(m.getVeiculo().getCategoria().equals(CategoriaVeiculo.valueOf(categoria))){
                lista.add(m);
            }
        }
        return lista;
    }
}