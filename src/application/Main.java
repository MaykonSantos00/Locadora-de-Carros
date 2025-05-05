package application;

import controller.LocadoraController;
import domain.Carro;
import domain.Cliente;
import domain.TipoCarro;
import exception.AluguelExecption;
import exception.CarroIndisponivelException;
import exception.ClienteNuloException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        LocadoraController controller = new LocadoraController();

        boolean executando = true;

        while (executando) {
            System.out.println("## Menu Locadora ##");
            System.out.println("[1] - Cadastrar Cliente");
            System.out.println("[2] - Cadastrar Carro");
            System.out.println("[3] - Alugar Carro");
            System.out.println("[4] - Devolver Carro");
            System.out.println("[5] - Listar Carros Disponíveis");
            System.out.println("[6] - Listar Aluguéis");
            System.out.println("[0] - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Você escolheu Cadastrar cliente");
                    System.out.println("Digite o seu Nome: ");
                    String nomeCliente = teclado.next();
                    System.out.println("Digite o seu CPF: ");
                    String cpfCliente = teclado.next();
                    System.out.println("Digite o seu Telefone: ");
                    String telefoneCliente = teclado.next();
                    controller.cadastrarCliente(nomeCliente, cpfCliente, telefoneCliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("Você escolheu Cadastrar carro");
                    System.out.println("Digite o Modelo: ");
                    String modeloCarro = teclado.next();
                    System.out.println("Digite o Marca: ");
                    String marcaCarro = teclado.next();
                    System.out.println("Digite a Placa: ");
                    String placaCarro = teclado.next();
                    System.out.println("Digite a Cor: ");
                    String corCarro = teclado.next();
                    System.out.println("Categoria (1 - PICAPE, 2 - SUV): ");
                    int cat = teclado.nextInt();
                    teclado.nextLine();
                    TipoCarro categoria = switch (cat) {
                        case 1 -> TipoCarro.PICAPE;
                        case 2 -> TipoCarro.SUV;
                        default -> TipoCarro.PICAPE;
                    };
                    controller.cadastrarCarro(modeloCarro, marcaCarro, placaCarro, corCarro, categoria);
                    System.out.println("Carro cadastrado com sucesso!");
                    break;
                case 3:
                    System.out.println("Você escolheu alugar um Carro");
                    System.out.println("Digite o seu CPF: ");
                    String cpfAlugar = teclado.next();
                    Cliente cliente = controller.buscarClientePorCPF(cpfAlugar);
                    System.out.println("Digite a placa do carro: ");
                    String placaAlugar = teclado.next();
                    Carro carro = controller.buscarCarroPorPlaca(placaAlugar);
                    if (cliente == null || carro == null) {
                        try {
                            throw new AluguelExecption("Aluguel Inválido: Cliente  ou Carro é Nulo");
                        } catch (AluguelExecption e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    try {
                        controller.alugarCarro(cpfAlugar, placaAlugar);
                    } catch (ClienteNuloException e) {
                        throw new RuntimeException(e);
                    } catch (CarroIndisponivelException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    System.out.println("Você escolheu Devolver o carro");
                    break;
                case 5:
                    System.out.println("## Você escolheu Listar os Carros ## ");
                    controller.listarCarros();
                    break;

                case 0:
                    executando = false;
                    System.out.println("Encerrando sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;

            }


        }
    }
}
