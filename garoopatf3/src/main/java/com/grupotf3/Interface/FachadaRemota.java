package com.grupotf3.Interface;

import com.grupotf3.CasosDeUso.Servicos.Fachada;
import com.grupotf3.Entidades.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public void setDadosCidade(@RequestBody String nome){
        fachada.registraCidade(nome);
    }
}