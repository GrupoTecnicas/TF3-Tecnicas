package com.grupotf3.Entidades.Geometria;

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

    public Ponto pontoCentral(){
        int x = (pSupEsq.getX()+pInfDir.getX())/2;
        int y = (pSupEsq.getY()+pInfDir.getY())/2;
        return new Ponto(x,y);
    }

    private int computaTeste(int x, int y){
        final int INSIDE = 0;
        final int LEFT = 1;
        final int RIGHT = 2;
        final int BOTTOM = 4;
        final int TOP = 8;


        int xMin = pSupEsq.getX();
        int xMax = pInfDir.getX();
        int yMin = pInfDir.getY();
        int yMax = pSupEsq.getY();

        int code = INSIDE;

        if (x < xMin){
            code = code|LEFT;
        }
        else if (x > xMax){
            code = code|RIGHT;
        }
        if(y < yMin){
            code = code|BOTTOM;
        }
        else if(y > yMax){
            code = code|TOP;
        }

        return code;
    }

    private SituacaoReta calculaSituacao(int x0, int y0, int x1, int y1){
        int code0 = computaTeste(x0,y0);
        int code1 = computaTeste(x1,y1);
        String aux1 = Integer.toBinaryString(code0|code1);
        String aux2 = Integer.toBinaryString(code0 & code1);
        while(true){
            if( aux1.charAt(aux1.length()-1) == '0'){
                return SituacaoReta.TODA_DENTRO;
            }
            else if (aux2.charAt(aux2.length()-1) != '0'){
                return SituacaoReta.TODA_FORA;
            }
            else{
                return SituacaoReta.INTERSECTA;
            }
        }
    }

    public SituacaoReta classifica(Reta reta){
        int x1 = reta.getP1().getX();
        int y1 = reta.getP1().getY();
        int x2 = reta.getP2().getX();
        int y2 = reta.getP2().getY();

        return calculaSituacao(x1,y1,x2,y2);
        
    }

    public String toString(){
        return "Area ["+pSupEsq+","+pInfDir+"]";
    }
}