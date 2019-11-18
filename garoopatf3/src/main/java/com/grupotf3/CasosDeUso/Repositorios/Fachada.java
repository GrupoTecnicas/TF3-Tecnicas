package com.grupotf3.CasosDeUso.Repositorios;

import com.grupotf3.CasosDeUso.Politicas.CustoViagem;
import com.grupotf3.CasosDeUso.Politicas.SelecaoMotorista;

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
}