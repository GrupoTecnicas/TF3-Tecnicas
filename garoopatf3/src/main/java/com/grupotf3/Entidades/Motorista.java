package com.grupotf3.Entidades;

public class Motorista{
    
    private String cpf, nome;
    private int qtdAval, somaAval;
    private Veiculo veiculo;
    private FormaPagamento forma;

    public static Motorista criaMotorista(String cpf, String nome, String formaPgto, Veiculo veiculo){
        return new Motorista(cpf,nome,formaPgto,veiculo);
    }

    private Motorista(String cpf, String nome, String forma, Veiculo veiculo){
        this.cpf = cpf;
        this.nome = nome;
        qtdAval = 0;
        somaAval = 0;
        this.veiculo = veiculo;
        this.forma = FormaPagamento.valueOf(forma);
    }

    public String getCPF(){
        return cpf;
    }

    public String getNome(){
        return nome;
    }

    public Veiculo getVeiculo(){
        return veiculo;
    }

    public FormaPagamento getForma(){
        return forma;
    }

    public int getQtdAval(){
        return qtdAval;
    }

    public void novaAval(){
        qtdAval++;
    }

    public int getSomaAval(){
        return somaAval;
    }

    public void novaSomaAval(int aval){
        somaAval += aval;
    }

    public int mediaAval(){
        return (int)Math.floor(somaAval/qtdAval);
    }

    public String toString(){
        return "Nome: "+nome+"\nCPF: "+cpf+"\nVeiculo: "+veiculo.getMarca()+" - Placa: "+veiculo.getPlaca()+"\nForma de pagamento: "+forma+"\nQuantidade de avaliações: "+qtdAval+"\nSoma das avaliações: "+somaAval;
    }
}