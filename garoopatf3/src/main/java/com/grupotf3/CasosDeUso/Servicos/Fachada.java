package com.grupotf3.CasosDeUso.Servicos;

import com.grupotf3.CasosDeUso.Politicas.*;
import com.grupotf3.CasosDeUso.Repositorios.*;
import com.grupotf3.Entidades.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Service
public class Fachada{
    private  CustoViagem custoViagem;
    private  IRepositorioMotorista motoristas;
    private  IRepositorioPassageiro passageiros;
    private  IRepositorioViagem viagens;
    private  IRepositorioCidade cidades;
    private  IRepositorioBairros bairros;

    @Autowired
    public Fachada( CustoViagem custoViagem,  IRepositorioMotorista motoristas,  IRepositorioPassageiro passageiros,  IRepositorioViagem viagens,  IRepositorioCidade cidades,  IRepositorioBairros bairros){
        this.custoViagem = custoViagem;
        this.motoristas = motoristas;
        this.passageiros = passageiros;
        this.viagens = viagens;
        this.cidades = cidades;
        this.bairros = bairros;
    }

    public Viagem solicitaVeiculoParaViagem( int id,  String cpf,  String nomeCidade,  String bOrig,  String bDest,  String catVeiculo){
        Viagem v = null;
        Passageiro passageiro = passageiros.recuperaPorCPF(cpf);
         Cidade cidade = cidades.recuperaCidade(nomeCidade);
         bairros.atualizaBairros(cidade.getBairros());
         Bairro origem = bairros.recuperaBairro(bOrig);
         Bairro destino = bairros.recuperaBairro(bDest);
         Roteiro roteiro = Roteiro.criaRoteiro(cidade,origem,destino);
         Motorista motorista = selecionaMotoristaParaViagem(catVeiculo);
         Veiculo veiculo = motorista.getVeiculo();
         double custo = custoViagem.calculaCusto(veiculo, roteiro);
        v = Viagem.novaViagem(id, roteiro, motorista, passageiro, custo);
        viagens.cadastraViagem(v);
        return v;
    }

    public List<Viagem> recuperaViagensMotorista( String cpf){
         Motorista mot = motoristas.recuperaPorCPF(cpf);
        return viagens.getViagens(mot);
    }

    public Motorista getMotorista( String cpf){
        return motoristas.recuperaPorCPF(cpf);
    }

    public Passageiro getPassageiro( String cpf){
        return passageiros.recuperaPorCPF(cpf);
    }

    public Cidade getCidade( String nome){
        return cidades.recuperaCidade(nome);
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

    public boolean pontuarPassageiro( String cpf,  int avaliacao){
         Passageiro p = passageiros.recuperaPorCPF(cpf);
        if(p!=null){
            p.novaSomaAval(avaliacao);
            p.novaAval();
            return true;
        }
        return false;
    }

    public boolean informaPontuacaoMotorista( String cpf){
         Motorista m = motoristas.recuperaPorCPF(cpf);
        if(m != null){
            System.out.println(m.getNome());
            System.out.println("Quantidade de avaliações: " + m.getQtdAval());
            System.out.println("Soma de avaliações: "+m.getSomaAval());
            return true;
        }
        return false;
    }

    public boolean informaPontuaçãoPassageiro( String cpf){
         Passageiro p = passageiros.recuperaPorCPF(cpf);
        if(p != null){
            System.out.println(p.getNome());
            System.out.println("Quantidade de avaliações: " + p.getQtdAval());
            System.out.println("Soma de avaliações: "+p.getSomaAval());
            return true;
        }
        return false;
    }

    public void registraMotorista(Motorista m){
        motoristas.atualizaMotorista(m);
    }

    public void registraPassageiro(Passageiro p){;
        passageiros.atualizaPassageiro(p);
    }

    public void registraCidade( Cidade cidade){
        cidades.atualizaCidades(cidade);
    }

    public void registraViagem(Viagem viagem){
        viagens.cadastraViagem(viagem);
    }

    public List<Motorista> getMotoristas(){
        return motoristas.getLista();
    }
    public List<Passageiro> getPassageiros(){
        return passageiros.getLista();
    }
    public List<Cidade> getCidades(){
        return cidades.getLista();
    }

    public List<Viagem>getViagens(){
        return viagens.getTodasViagens();
    }

    public Motorista selecionaMotoristaParaViagem(String categoriaVeiculo){
        List<Motorista> list = listaCat(categoriaVeiculo);
        return list.get(0);
    }

    private List<Motorista> listaCat(String categoria){
        List<Motorista> lista = new ArrayList<>();
        for(Motorista m : motoristas.getLista()){
            if(m.getVeiculo().getCategoria().toString().equalsIgnoreCase(categoria)){
                lista.add(m);
            }
        }
        return lista;
    }
}