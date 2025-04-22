package main;

import model.*;
import service.LocadoraService;

public class Locadora {
    public static void main(String[] args) {
        LocadoraService locadora =  new LocadoraService();

        Carro carro = new Carro("Dodge RAM", "RAM","Preta","QQQ999", TipoVeiculo.PICAPE);
        Moto moto = new Moto("CB1000","Honda","Capitao-America", "PSG598",TipoVeiculo.ESPORTIVA);
        Caminhao caminhao = new Caminhao("Volvo FH 540","Volvo", "Prata", "REA598", TipoVeiculo.
                CAMINHAO_TRUCK);

        Cliente cliente1 = new Cliente("Maykon","04753245284",21,true);
        Cliente cliente2 = new Cliente("Lívyan","01889753628",24,true);
        Cliente cliente3 = new Cliente("Luan","45678903034",9,false);

        locadora.cadastroCliente(cliente1,FormaDePagamento.DINHEIRO);
        locadora.cadastroCliente(cliente2,FormaDePagamento.PIX);
        locadora.cadastroCliente(cliente3,FormaDePagamento.CARTAO_DE_CREDITO);

        locadora.cadastroVeiculo(moto);
        locadora.cadastroVeiculo(caminhao);
        locadora.cadastroVeiculo(carro);

        locadora.realizarAluguel("QQQ999","04753245284" );
        locadora.realizarAluguel("PSG598","01889753628" );
        locadora.realizarAluguel("REA598","45678903034" );

        locadora.realizarDevolucao("QQQ999","04753245284" );
        locadora.realizarDevolucao("PSG598","01889753628" );
        locadora.realizarDevolucao("REA598","45678903034" );


    }
}
