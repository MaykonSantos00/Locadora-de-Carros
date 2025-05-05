package controller;

import domain.Aluguel;
import domain.Carro;
import domain.Cliente;
import domain.TipoCarro;
import exception.CarroIndisponivelException;
import exception.ClienteNuloException;
import service.LocadoraService;
import util.ValidacaoUtil;

public class LocadoraController {

    LocadoraService service = new LocadoraService();

    public void cadastrarCliente(String nome, String cpf, String telefone) {
        Cliente cliente = new Cliente(nome, cpf, telefone);
        service.cadastrarCliente(cliente);
    }

    public void cadastrarCarro(String modelo, String marca, String placa, String cor, TipoCarro tipoCarro) {
        Carro carro = new Carro(modelo, marca, placa, cor, tipoCarro);
        service.cadastrarCarro(carro);
    }

    public void listarCarros() {
        System.out.println("Listando carros:");
        service.displayCarros();
    }

    public void alugarCarro(String cpf, String placa) throws ClienteNuloException, CarroIndisponivelException {
        Cliente cliente = service.buscaClientePorCPF(cpf);
        ValidacaoUtil.validarCliente(cliente);
        Carro carro = service.buscaCarroPorPlaca(placa);
        ValidacaoUtil.validarCarro(carro);
        Aluguel aluguel = new Aluguel(carro, cliente);
        carro.setDisponivel(false);
        System.out.println("Obrigado, " + cliente.getNome() + " por alugar o carro " + carro.getModelo() + " em " +
                aluguel.getDataAluguel());
    }

    public void devolverCarro(){}

    public Cliente buscarClientePorCPF(String cpf) {
        return service.buscaClientePorCPF(cpf);
    }

    public Carro buscarCarroPorPlaca(String placa) {
        return service.buscaCarroPorPlaca(placa);
    }
}
