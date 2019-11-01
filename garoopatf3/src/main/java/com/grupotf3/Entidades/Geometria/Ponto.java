package com.grupotf3.Entidades.Geometria;

public class Ponto{
    private int x, y;

    public Ponto(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public String toString(){
        return "("+x+","+y+")";
    }
}