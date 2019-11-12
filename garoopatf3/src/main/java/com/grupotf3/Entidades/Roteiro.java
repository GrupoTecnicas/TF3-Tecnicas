package com.grupotf3.Entidades;

import java.util.List;
import java.util.stream.Collectors;

import com.grupotf3.Entidades.Geometria.*;

public class Roteiro {
    private Cidade cidade;
    private Bairro bairroOrigem;
    private Bairro bairroDestino;

    public static Roteiro criaRoteiro(Cidade cidade,Bairro origem,Bairro destino){
        return new Roteiro(cidade,origem,destino);
    }

    private Roteiro(Cidade cidade, Bairro bairroOrigem, Bairro bairroDestino) {
        this.cidade = cidade;
        this.bairroOrigem = bairroOrigem;
        this.bairroDestino = bairroDestino;
    }
    
    public Cidade getCidade() {
        return cidade;
    }

    public Bairro getOrigem() {
        return bairroOrigem;
    }

    public Bairro getDestino() {
        return bairroDestino;
    }

    //Define a reta que representa o percurso da viagem
    public Reta getRota(){
        Ponto pOrig = bairroOrigem.getLimites().pontoCentral();
        Ponto pDest = bairroOrigem.getLimites().pontoCentral();
        return new Reta(pOrig,pDest);
    }

    // Define a lista de bairros percorridos
    public List<Bairro> bairrosPercorridos(){
        return cidade
                .getBairros()
                .stream()
                .filter(b->b.getLimites().classifica(this.getRota())!= SituacaoReta.TODA_FORA)
                .collect(Collectors.toList());
    }

    public String toString(){
        return "Cidade: "+cidade.getNome()+"\nBairro origem: "+bairroOrigem.getNome()+"\nBairro destino: "+bairroDestino.getNome();
    }
}