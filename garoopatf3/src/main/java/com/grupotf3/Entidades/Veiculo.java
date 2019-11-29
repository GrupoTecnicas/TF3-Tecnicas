package com.grupotf3.Entidades;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY)
@JsonSubTypes({
    @Type(value = VeiculoSimples.class, name = "Veiculo Simples"),
    @Type(value = VeiculoNormal.class, name = "Veiculo Normal"),
    @Type(value = VeiculoLuxo.class, name = "Veiculo Luxo"),
})
public abstract class Veiculo{
/*
    private boolean setCatInferior(CategoriaVeiculo cat){
        switch(cat){
            case SIMPLES: return false;
            default: return true;
        }
    }

    private boolean setPortaMalas(CategoriaVeiculo cat){
        switch(cat){
            case LUXO: return true;
            default: return false;
        }
    }
*/
    public abstract String getPlaca();

    public abstract String getMarca();

    public abstract String getCor();

    public abstract CategoriaVeiculo getCategoria();

    public abstract String toString();
}