package com.grupotf3.Interface.Controle;

import com.grupotf3.CasosDeUso.Servicos.Fachada;
import com.grupotf3.Entidades.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grupotf3")
public class FachadaRemota{
    private Fachada fachada;

    @Autowired
    public FachadaRemota(Fachada fachada){
        this.fachada = fachada;
        autoFill();
    }

    @GetMapping(path = "/solicitaVeiculoParaViagem")
    public Viagem getDadosViagem(@RequestParam int id, @RequestParam String cpf, @RequestParam String cidade, @RequestParam String bOrig, @RequestParam String bDest, @RequestParam String formaPgto, @RequestParam String catVeiculo){
        Viagem viagem = fachada.solicitaVeiculoParaViagem(1, cpf, "Porto Alegre", bOrig, bDest, formaPgto, catVeiculo);
        return viagem;
    }

    @GetMapping("/getMotorista")
    public Motorista getMotorista(@RequestParam String cpf){
        return fachada.getMotorista(cpf);
    }

    @GetMapping("/getPassageiro")
    public Passageiro getPassageiro(@RequestParam String cpf){
        return fachada.getPassageiro(cpf);
    }

    @GetMapping("/getCidade")
    public Cidade getCidade(@RequestParam String nome){
        return fachada.getCidade(nome);
    }

    @PostMapping("/registraMotorista")
    public void setDadoMotorista(@RequestBody Motorista motorista){
        fachada.registraMotorista(motorista);
    }

    @PostMapping("/registraPassageiro")
    public void setDadosPassageiro(@RequestBody Passageiro p){
        fachada.registraPassageiro(p);
    }

    @PostMapping("/registraCidade")
    public void setDadosCidade(@RequestBody Cidade cidade){
        fachada.registraCidade(cidade);
    }

    /*
    O método abaixo preenche os repositórios. Motivo: teste para demonstração.
    */
    private void autoFill(){
        String cidade = "Porto Alegre";
        fachada.registraCidade(Cidade.criaCidade(cidade));
        String nomeP = "Frederico";
        String cpf= "85820571053";
        fachada.registraPassageiro(Passageiro.novoPassageiro(cpf, nomeP));
        String nomeM = "Celso";
        cpf = "123456789";
        Veiculo v = FactoryVeiculo.criaVeiculo("1234ABCD", "Fusca", "Preto", "NORMAL");
        fachada.registraMotorista(Motorista.criaMotorista(cpf, nomeM, "DINHEIRO", v));
        fachada.registraMotorista(Motorista.criaMotorista("987654321", "Roger", "DEBITO", FactoryVeiculo.criaVeiculo("4321DCBA", "Fiat", "Prata", "SIMPLES")));
        fachada.registraMotorista(Motorista.criaMotorista("555000111", "Amanda", "CREDITO", FactoryVeiculo.criaVeiculo("5544ABBA", "BMW", "Azul Marinho", "LUXO")));
    }
}