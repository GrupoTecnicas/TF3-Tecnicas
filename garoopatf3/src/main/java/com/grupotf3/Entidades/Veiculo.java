package com.grupotf3.Entidades;
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

    public String toString(){
        return "Placa: "+this.getPlaca()+"\nMarca: "+this.getMarca()+"\nCor: "+this.getCor()+"\nCategoria do veiculo: "+this.getCategoria();
    }
}