package com.grupotf3.Interface;

import com.grupotf3.CasosDeUso.Servicos.Fachada;
import com.grupotf3.Entidades.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    }

    @GetMapping("/solicitaVeiculoParaViagem")
    public Viagem getDadosViagem(@RequestParam String cpf, @RequestParam String bOrig, @RequestParam String bDest, @RequestParam String formaPgto, @RequestParam String catVeiculo){
        Viagem viagem = fachada.solicitaVeiculoParaViagem(1, cpf, "Porto Alegre", bOrig, bDest, formaPgto, catVeiculo);
        return viagem;
    }

    @GetMapping("/getViagens")
    public List<Viagem> getViagem(String cpfMotorista){
        return fachada.recuperaViagensMotorista(cpfMotorista);
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

    @PostMapping("/registroMotorista")
    public void setDadoMotorista(@RequestParam String cpf, @RequestParam String nome, @RequestParam String formaPgto, @RequestParam String placa, @RequestParam String marca, @RequestParam String cor, @RequestParam String cat){
        fachada.registraMotorista(cpf, nome, formaPgto, placa, marca, cor, cat);
    }

    @PostMapping("/registraPassageiro")
    public void setDadosPassageiro(@RequestParam String cpf, @RequestParam String nome){
        fachada.registraPassageiro(cpf, nome);
    }

    @PostMapping("/registraCidade")
    public void setDadosCidade(@RequestParam String nome){
        fachada.registraCidade(nome);
    }
}