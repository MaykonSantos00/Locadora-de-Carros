package service;

import domain.Aluguel;
import domain.Carro;
import domain.Cliente;

import java.util.ArrayList;
import java.util.List;

public class LocadoraService {
    private List<Carro> carros;
    private List<Cliente> clientes;
    public List<Aluguel> alugueis;

    public LocadoraService() {
        this.carros = new ArrayList<Carro>();
        this.clientes = new ArrayList<>();
        this.alugueis = new ArrayList<>();
    }

    public void cadastrarCarro(Carro carro) {
        this.carros.add(carro);
    }

    public void cadastrarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public Carro buscaCarroPorPlaca(String placa) {
        for (Carro carro : carros) {
            if (carro.getPlaca().equals(placa)) {
                return carro;
            }
        }
        return null;
    }

    public Cliente buscaClientePorCPF(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public void displayCarros() {
        for (Carro carro : carros) {
            System.out.println(carro);
        }
    }
}
