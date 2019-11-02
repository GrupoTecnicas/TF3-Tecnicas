package com.grupotf3.Entidades;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import com.grupotf3.CasosDeUso.Politicas.CustoViagem;

public class Viagem{
    private int id;
    private Calendar dataHora;
    private Roteiro roteiro;
    private Motorista motorista;
    private Passageiro passageiro;
    private double custo;
    private CustoViagem custoViagem;

    public Viagem(int id, Motorista motorista, Passageiro passageiro, Roteiro roteiro){
        this.id = id;
        dataHora = Calendar.getInstance();
        this.motorista = motorista;
        this.passageiro = passageiro;
        custo = 0.0;
        custoViagem = new CustoViagem(motorista, passageiro);
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

    public CustoViagem getCustoViagem(){
        return custoViagem;
    }

    public double getCusto(){
        custo = custoViagem.calculaCusto(motorista, roteiro);
        return custo;
    }

    public Roteiro getRoteiro(){
        return roteiro;
    }

    public String toString(){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss" );
        return "Viagem: "+id+"\nData: "+formato.format(dataHora.getTime())+"\nRoteiro: "+roteiro.getOrigem()+" -> "+roteiro.getDestino()+"\nMotorista: "+motorista.getNome()+"\nPassageiro: "+passageiro.getNome()+"\nValor: R$"+custo;
    }

}