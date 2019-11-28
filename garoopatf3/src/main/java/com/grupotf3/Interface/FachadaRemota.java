package com.grupotf3.Interface;

import com.grupotf3.CasosDeUso.Servicos.Fachada;
import com.grupotf3.Entidades.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}