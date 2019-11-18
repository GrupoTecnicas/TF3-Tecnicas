package com.grupotf3.Entidades;

public class Motorista{
    
    private String cpf, nome;
    private int qtdAval, somaAval;
    private Veiculo veiculo;
    private FormaPagamento forma;

    public static Motorista criaMotorista(String cpf, String nome, Veiculo veiculo, String formaPgto){
        return new Motorista(cpf,nome,veiculo, formaPgto);
    }

    private Motorista(String cpf, String nome, Veiculo veiculo, String forma){
        this.cpf = cpf;
        this.nome = nome;
        qtdAval = 0;
        somaAval = 0;
        this.veiculo = veiculo;
        this.forma = definePagamento(forma);
    }

    private FormaPagamento definePagamento(String pgto){
        if(pgto.equalsIgnoreCase("debito")){
            return FormaPagamento.DEBITO;
        }
        else if(pgto.equalsIgnoreCase("credito")){
            return FormaPagamento.CREDITO;
        }
        else{
            return FormaPagamento.DINHEIRO;
        }
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

    public int getSomaAval(){
        return somaAval;
    }

    public String toString(){
        return "Nome: "+nome+"\nCPF: "+cpf+"\nVeiculo: "+veiculo.getMarca()+" - Placa: "+veiculo.getPlaca()+"\nForma de pagamento: "+forma+"\nQuantidade de avaliações: "+qtdAval+"\nSoma das avaliações: "+somaAval;
    }
}