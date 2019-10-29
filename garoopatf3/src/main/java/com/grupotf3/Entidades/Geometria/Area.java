package com.grupotf3;

public class Area{
    private Ponto pSupEsq, pInfDir;

    public Area(Ponto pSupEsq, Ponto pInfDir) {
        if ((pSupEsq.getX() >= pInfDir.getX()) || (pSupEsq.getY() <= pInfDir.getY())) {
            throw new IllegalArgumentException("O retangulo deve ser definido pela diagonal principal");
        } else {
            this.pSupEsq = pSupEsq;
            this.pInfDir = pInfDir;
        }
    }
    public Ponto getPSupEsq() {
        return pSupEsq;
    }
    
    public Ponto getPInfDir() {
        return pInfDir;
    }
/*
    public SituacaoReta classifica(Reta reta){
        int minX = pSupEsq.getX();
        int maxY = pSupEsq.getY();
        int maxX = pInfDir.getX();
        int minY = pInfDir.getY();
    }
*/
    public String toString(){
        return "Area ["+pSupEsq+","+pInfDir+"]";
    }
}