package controller;

import domain.Aluguel;
import domain.Carro;
import domain.Cliente;
import domain.TipoCarro;
import service.LocadoraService;

public class LocadoraController {

    LocadoraService service = new LocadoraService();

    public void cadastrarCliente(String nome, String cpf, String telefone){
        Cliente cliente = new Cliente(nome, cpf, telefone);
        service.cadastrarCliente(cliente);
    }

    public void cadastrarCarro(String modelo, String marca, String placa, String cor, TipoCarro tipoCarro){
        Carro carro = new Carro(modelo, marca, placa, cor, tipoCarro);
        service.cadastrarCarro(carro);
    }

    public void listarCarros(){
        System.out.println("Listando carros:");
        service.displayCarros();
    }

    public void alugarCarro(String cpf, String placa){
        Cliente cliente = service.buscaClientePorCPF(cpf);
        Carro carro = service.buscaCarroPorPlaca(placa);
        Aluguel aluguel = new Aluguel(carro, cliente);
        System.out.println("Obrigado, " + cliente.getNome() + " por alugar o carro " + carro.getModelo());
    }

    public Cliente buscarClientePorCPF(String cpf){
         return service.buscaClientePorCPF(cpf);
    }

    public Carro buscarCarroPorPlaca(String placa){
        return service.buscaCarroPorPlaca(placa);
    }
}
