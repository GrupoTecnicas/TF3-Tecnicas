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

    public static Viagem novaViagem(int id, Roteiro roteiro, Motorista motorista, Passageiro passageiro, double custo){
        return new Viagem(id,roteiro,motorista,passageiro,custo);
    }

    private Viagem(int id, Roteiro roteiro, Motorista motorista, Passageiro passageiro, double custo){
        this.id = id;
        dataHora = Calendar.getInstance();
        this.roteiro = roteiro;
        this.motorista = motorista;
        this.passageiro = passageiro;
        this.custo = custo;
        custoViagem = new CustoViagem();
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
        custo = custoViagem.calculaCusto(motorista.getVeiculo(), roteiro);
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