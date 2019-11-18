package com.grupotf3.CasosDeUso.Repositorios;

import com.grupotf3.CasosDeUso.Politicas.*;
import com.grupotf3.Entidades.*;
import java.util.List;

public class Fachada{
    private CustoViagem custoViagem;
    private RepositorioMotorista motoristas;
    private RepositorioPassageiro passageiros;
    private RepositorioViagem viagens;
    private RepositorioCidade cidades;
    private RepositorioBairros bairros;

    public Fachada(CustoViagem custoViagem, SelecaoMotorista selecao, RepositorioMotorista motoristas, RepositorioPassageiro passageiros, RepositorioViagem viagens, RepositorioCidade cidades, RepositorioBairros bairros){
        this.custoViagem = custoViagem;
        this.motoristas = motoristas;
        this.passageiros = passageiros;
        this.viagens = viagens;
        this.cidades = cidades;
        this.bairros = bairros;
    }

    public Viagem solicitaVeiculoParaViagem(int id, String cpf, String nomeCidade, String bOrig, String bDest, String formaPagamento, String catVeiculo){
        Viagem v = null;
        Passageiro passageiro = passageiros.recuperaPorCPF(cpf);
        Cidade cidade = cidades.recuperaCidade(nomeCidade);
        Bairro origem = bairros.recuperaBairro(bOrig);
        Bairro destino = bairros.recuperaBairro(bDest);
        Roteiro roteiro = Roteiro.criaRoteiro(cidade,origem,destino);
        //Motorista motorista = selecaoMotorista.selecionaMotoristaParaViagem(roteiro,catVeiculo);
        //Veiculo veiculo = motorista.getVeiculo();
        //double custo = custoViagem.calculaCusto(motorista, roteiro);
        //v = Viagem.novaViagem(id, roteiro, motorista, passageiro, custo);
        viagens.cadastraViagem(v);
        return v;
    }

    public List<Viagem> recuperaViagensMotorista(String cpf){
        Motorista mot = motoristas.recuperaPorCPF(cpf);
        return viagens.getViagens(mot);
    }

    public boolean informaPontuacaoMotorista(String cpf){
        Motorista m = motoristas.recuperaPorCPF(cpf);
        if(m != null){
            System.out.println(m.getNome());
            System.out.println("Quantidade de avaliações: " + m.getQtdAval());
            System.out.println("Soma de avaliações: "+m.getSomaAval());
            return true;
        }
        return false;
    }

    public boolean informaPontuaçãoPassageiro(String cpf){
        Passageiro p = passageiros.recuperaPorCPF(cpf);
        if(p != null){
            System.out.println(p.getNome());
            System.out.println("Quantidade de avaliações: " + p.getQtdAval());
            System.out.println("Soma de avaliações: "+p.getSomaAval());
            return true;
        }
        return false;
    }
}