package com.grupotf3.Entidades;

public enum CategoriaVeiculo{
    SIMPLES, NORMAL, LUXO;

    public String toString(){
        switch(this){
            case SIMPLES: return "Simples";
            case NORMAL: return "Normal";
            case LUXO: return "Luxo";
        }
        return null;
    }
}