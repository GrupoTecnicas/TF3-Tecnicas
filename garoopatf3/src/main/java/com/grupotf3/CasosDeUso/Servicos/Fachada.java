package com.grupotf3.CasosDeUso.Servicos;

import com.grupotf3.CasosDeUso.Politicas.*;
import com.grupotf3.CasosDeUso.Repositorios.*;
import com.grupotf3.Entidades.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Fachada{
    private CustoViagem custoViagem;
    private SelecaoMotorista selecaoMotorista;
    private RepositorioMotorista motoristas;
    private RepositorioPassageiro passageiros;
    private RepositorioViagem viagens;
    private RepositorioCidade cidades;
    private RepositorioBairros bairros;

    @Autowired
    public Fachada(CustoViagem custoViagem, SelecaoMotorista selecao, RepositorioMotorista motoristas, RepositorioPassageiro passageiros, RepositorioViagem viagens, RepositorioCidade cidades, RepositorioBairros bairros){
        this.custoViagem = custoViagem;
        this.motoristas = motoristas;
        this.passageiros = passageiros;
        this.viagens = viagens;
        this.cidades = cidades;
        this.bairros = bairros;
    }

    @Autowired
    public Fachada(){
        custoViagem = new CustoViagem();
        motoristas = new RepositorioMotorista();
        passageiros = new RepositorioPassageiro();
        viagens = new RepositorioViagem();
        cidades = new RepositorioCidade();
        bairros = new RepositorioBairros();
    }

    public Viagem solicitaVeiculoParaViagem(int id, String cpf, String nomeCidade, String bOrig, String bDest, String formaPagamento, String catVeiculo){
        Viagem v = null;
        Passageiro passageiro = passageiros.recuperaPorCPF(cpf);
        Cidade cidade = cidades.recuperaCidade(nomeCidade);
        Bairro origem = bairros.recuperaBairro(bOrig);
        Bairro destino = bairros.recuperaBairro(bDest);
        Roteiro roteiro = Roteiro.criaRoteiro(cidade,origem,destino);
        Motorista motorista = selecaoMotorista.selecionaMotoristaParaViagem(catVeiculo);
        Veiculo veiculo = motorista.getVeiculo();
        double custo = custoViagem.calculaCusto(veiculo, roteiro);
        v = Viagem.novaViagem(id, roteiro, motorista, passageiro, custo);
        viagens.cadastraViagem(v);
        return v;
    }

    public List<Viagem> recuperaViagensMotorista(String cpf){
        Motorista mot = motoristas.recuperaPorCPF(cpf);
        return viagens.getViagens(mot);
    }

    public Motorista getMotorista(String cpf){
        return motoristas.recuperaPorCPF(cpf);
    }

    public boolean pontuarMotorista(String cpf, int avaliacao){
        Motorista m = motoristas.recuperaPorCPF(cpf);
        if(m!=null){
            m.novaSomaAval(avaliacao);
            m.novaAval();
            return true;
        }
        return false;
    }

    public boolean pontuarPassageiro(String cpf, int avaliacao){
        Passageiro p = passageiros.recuperaPorCPF(cpf);
        if(p!=null){
            p.novaSomaAval(avaliacao);
            p.novaAval();
            return true;
        }
        return false;
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