package com.grupotf3.Interface.Controle;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.grupotf3.CasosDeUso.Servicos.Fachada;
import com.grupotf3.Entidades.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
    }

    @GetMapping(path = "/solicitaVeiculoParaViagem")
    public Viagem getDadosViagem(@RequestParam int id, @RequestParam String cpf, @RequestParam String cidade, @RequestParam String bOrig, @RequestParam String bDest, @RequestParam String catVeiculo){
        Viagem viagem = fachada.solicitaVeiculoParaViagem(id, cpf, cidade, bOrig, bDest, catVeiculo);
        return viagem;
    }

    @GetMapping("/getMotorista")
    public Motorista getMotorista(@RequestParam String cpf){
        return fachada.getMotorista(cpf);
    }

    @GetMapping("/getMotoristas")
    public List<Motorista>retornaMotoristas(){
        return fachada.getMotoristas();
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
        fachada.registraCidade(Cidade.criaCidade("POA"));
        fachada.registraPassageiro(Passageiro.novoPassageiro("85820571053", "Frederico"));
        fachada.registraPassageiro(Passageiro.novoPassageiro("12345678922", "Francine"));
        fachada.registraPassageiro(Passageiro.novoPassageiro("98765432111", "Fillipe"));
        fachada.registraMotorista(Motorista.criaMotorista("24681357955", "Celso", "DINHEIRO", FactoryVeiculo.criaVeiculo("1234ABCD", "Fusca", "Preto", "NORMAL")));
        fachada.registraMotorista(Motorista.criaMotorista("98765432133", "Roger", "DEBITO", FactoryVeiculo.criaVeiculo("4321DCBA", "Fiat", "Prata", "SIMPLES")));
        fachada.registraMotorista(Motorista.criaMotorista("55500011199", "Amanda", "CREDITO", FactoryVeiculo.criaVeiculo("5544ABBA", "BMW", "Azul Marinho", "LUXO")));
    }

    @Bean
    public CommandLineRunner commandLineRunner(){
        return args ->{
            System.out.println("Salvando dados...");
            autoFill();
            System.out.println("Dados salvos com sucesso!");
            programa();
        };
    }

    private void programa(){
        Scanner in = new Scanner(System.in);
        int opcao;
        System.out.println("=====================");
        System.out.println("Bem vindo ao Garoopa!");
        System.out.println("=====================");
        
        do{
            System.out.println("Por favor, escolha uma opcao");
            System.out.println("1 - Pagina do Passageiro");
            System.out.println("2 - Pagina do Motorista");
            System.out.println("3 - Sair");
            System.out.print("Opcao: ");
            opcao = in.nextInt();
            switch(opcao){
                case 1: pgPassageiro(); break;
                case 2: pgMotorista(); break;
                case 3: System.out.println("Obrigado por viajar no Garoopa, até a próxima!"); in.close();System.exit(0);
            }

        }while(opcao>0);
    }

    private void pgPassageiro(){
        Scanner in = new Scanner(System.in);
        int opcao;
        System.out.println("=====================");
        System.out.println("Área do Passageiro");
        System.out.println("=====================");
        System.out.println("Informe o seu CPF: ");
        String cpf = in.nextLine();
        System.out.println("Bem vindo "+getPassageiro(cpf).getNome());
        in.nextLine();
        System.out.println("Informe o bairro de Origem: ");
        int i = 0;
        for(Bairro b : getCidade("POA").getBairros()){
            System.out.println(i+" -> "+b.getNome());
            i++;
        }
        System.out.print("Opcao: ");
        opcao = in.nextInt();
        String bOrig = getCidade("POA").getBairros().get(opcao).getNome();
        System.out.println("Informe o bairro de Destino: ");
        i = 0;
        for(Bairro b : getCidade("POA").getBairros()){
            System.out.println(i+" -> "+b.getNome());
            i++;
        }
        System.out.print("Opcao: ");
        opcao = in.nextInt();
        String bDest = getCidade("POA").getBairros().get(opcao).getNome();

        System.out.println("Selecione a categoria do Veiculo: ");
        i = 0;
        for(Motorista m: retornaMotoristas()){
            System.out.println(i+" -> "+m.getVeiculo().getCategoria());
            i++;
        }
        System.out.print("Opcao: ");
        opcao = in.nextInt();
        String catVeiculo = retornaMotoristas().get(opcao).getVeiculo().getCategoria().toString();
        Viagem viagem = getDadosViagem(fachada.getViagens().size()+1, cpf, "POA", bOrig, bDest, catVeiculo);
        System.out.println("O motorista "+viagem.getMotorista().getNome()+" irá lhe buscar em um "+viagem.getMotorista().getVeiculo().getMarca()+" "+viagem.getMotorista().getVeiculo().getCor());
        System.out.println("Dados da viagem: ");
        System.out.println(viagem);
        fachada.registraViagem(viagem);
        System.out.println("Por favor, informe uma pontuacao para "+ viagem.getMotorista().getNome());
        int ponto = in.nextInt();
        fachada.pontuarMotorista(viagem.getMotorista().getCPF(), ponto);
        System.out.println(viagem.getMotorista());
        System.out.println("Obrigado por viajar no Garoopa, até a próxima!");
    }
    private void pgMotorista(){
        Scanner in = new Scanner(System.in);
        System.out.println("=====================");
        System.out.println("Área do Motorista");
        System.out.println("=====================");
        System.out.println("Informe o seu CPF: ");
        String cpf = in.nextLine();
        System.out.println("Bem vindo "+getMotorista(cpf).getNome());
        in.nextLine();
        System.out.println("Confira suas viagens e escolha um passageiro para pontua-lo: ");
        int i = 0;
        for(Viagem v: fachada.recuperaViagensMotorista(cpf)){
            System.out.println(i+" -> "+v.getRoteiro());
            System.out.println(v.getPassageiro());
            i++;
        }
        System.out.println("Opcao: ");
        int opcao = in.nextInt();
        Viagem dadoViagem = fachada.recuperaViagensMotorista(cpf).get(opcao);
        System.out.println("Informe a nota do passageiro: ");
        int nota = in.nextInt();
        fachada.pontuarPassageiro(dadoViagem.getPassageiro().getCPF(), nota);
        System.out.println(dadoViagem.getPassageiro());
        System.out.println("Obrigado por utilizar o Garoopa, até a próxima!");
    }
}