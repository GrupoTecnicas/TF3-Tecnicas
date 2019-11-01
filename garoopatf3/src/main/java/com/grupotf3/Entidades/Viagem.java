package com.grupotf3.Entidades;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Viagem{
    private int id;
    private LocalTime dataHora;
    private Roteiro roteiro;
    private Motorista motorista;
    private Passageiro passageiro;
    private double custo;

    public Viagem(int id, Motorista motorista, Passageiro passageiro){
        this.id = id;
        dataHora = LocalTime.now();
        this.motorista = motorista;
        this.passageiro = passageiro;
    }

    public int getId(){
        return id;
    }

    public Motorista getMotorista(){
        return motorista;
    }

    public Passageiro getPassageiro(){
        return passageiro;
    }

    public double getCusto(){
        return custo;
    }

    public Roteiro getRoteiro(){
        return roteiro;
    }

    public String toString(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        return "Viagem: "+id+"\nTempo: "+dataHora.format(formato)+"\nMotorista: "+motorista.getNome()+"\nPassageiro: "+passageiro.getNome();
    }

}