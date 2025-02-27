import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Clientes clientes = new Clientes();

            Cliente cliente1 = clientes.criarCliente("Vitor","12/12/2003", "123.123.123-32", "Rua da mofea, 19");        //Aqui eu crio 2 clientes para teste, sendo eles Vitor e Rodolfo.
            Cliente cliente2 = clientes.criarCliente("Rodolfo", "12/09/2000", "432.563.674-54", "Rua dos Anjos, 89");
            cliente1.getContaPoupanca().depositar(2000);
            cliente1.getContaCorrente().depositar(2000);
            cliente2.getContaCorrente().depositar(1000);
            cliente2.getContaPoupanca().depositar(1000);


        while (true) {
            System.out.println("\nSeja bem-vindo! Escolha a opção desejada:");                                       //emplemantação de forma pratica de escilha de serviço do sistema
            System.out.println("1 - Visualizar saldo");                                                  //Mostra o saldo juntamente com informações da conta
            System.out.println("2 - Fazer um depósito");                                                             //Da a possibilidade ao cliente de fazer depositos de dinheiro em conta corrente o conta poupança.
            System.out.println("3 - Fazer um saque");                                              //Da ao cliente a possibilidade de fazer um saque a qualquer momento em ambas as contas.
            System.out.println("4 - Fazer uma transferência");                                                       //Da ao cliente a possibilidade de fazer transações entre as contas criadas.
            System.out.println("5 - Aplicar rendimento na Poupança");                        //Aplica um rendimento a conta poupança de 3% ao mes.
            System.out.println("6 - Mostrar todos os clientes");                                                     //Mostra uma lista detalhada de todos os clientes cadastrados no sistema e informações pessoais.
            System.out.println("7 - Criar Conta");                                       // Da a possibilidade ao usuario a criação de conta no sistema.
            System.out.println("8 - Fazer um saque-aniversário");                                                    //Da a possiblidade o cliente da conta fazer um saque aniversario no mes de nascimento.
            System.out.println("9 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 9) {
                System.out.println("Agradecemos por utilizar o nosso sistema bancário!");
                break;
            }

            if (opcao == 7) {
                System.out.println("Ficamos felizes em ter você conosco!\n Informe suas credenciais -");

                System.out.print("Digite seu nome - ");
                String nome = scanner.nextLine();

                System.out.print("Digite a data de nascimento (dd/mm/aaaa) - ");
                String data_nasc = scanner.nextLine();

                System.out.print("Digite o CPF - ");
                String CPF = scanner.nextLine();

                System.out.print("Digite o endereço - ");
                String endereco = scanner.nextLine();

                Cliente novoCliente = clientes.criarCliente(nome, data_nasc, CPF, endereco);
                novoCliente.getContaPoupanca().definirDataAniversario(data_nasc);
                System.out.println("\nCliente cadastrado com sucesso");
                System.out.println("Seja bem vindo(a)");
                System.out.println("\nDetalhes da sua CONTA NOVA");
                System.out.println("Nome: " + novoCliente.getNome());
                System.out.println("Número da Conta  " + novoCliente.getNumeroConta());
                System.out.println("Agência: " + novoCliente.getAgencia());

                continue;
            }

            System.out.print("Digite seu nome: ");
            String nome = scanner.nextLine();
            Cliente cliente = clientes.buscarCliente(nome);

            if (cliente == null) {
                System.out.println("Infelizmente, você não foi encontrado em nosso sistema.");
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("Nome: " + cliente.getNome());
                    System.out.println("Data de nascimento: " + cliente.getData_Nasc());
                    cliente.visualizarSaldo();
                    cliente.exibirDadosConta();
                    break;
                case 2:
                    System.out.println("\nEscolha a conta para depósito:");
                    System.out.println("1 - Conta Corrente");
                    System.out.println("2 - Conta Poupança");
                    int escolhaDeConta = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o valor que deseja depositar: ");
                    double valorDeDeposito = scanner.nextDouble();
                    scanner.nextLine();

                    if (escolhaDeConta == 1) {
                        cliente.getContaCorrente().depositar(valorDeDeposito);
                    } else if (escolhaDeConta == 2) {
                        cliente.getContaPoupanca().depositar(valorDeDeposito);
                    } else {
                        System.out.println("Opção inválida.");
                        continue;
                    }
                    System.out.println("Depósito realizado com sucesso.");
                    continue;
                case 3:
                    System.out.println("\nEscolha de qual conta deseja sacar:");
                    System.out.println("1 - Conta Corrente");
                    System.out.println("2 - Conta Poupança");
                    int escolhaDeSaque = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o valor do saque: ");
                    double valorDeSaque = scanner.nextDouble();
                    scanner.nextLine();

                    if (valorDeSaque > 2000) {
                        System.out.println("O limite de saque diário é de R$2000.");
                        break;
                    }

                    try {
                        if (escolhaDeSaque == 1) {
                            cliente.getContaCorrente().sacar(valorDeSaque);
                        } else if (escolhaDeSaque == 2) {
                            cliente.getContaPoupanca().sacar(valorDeSaque);
                        } else {
                            System.out.println("Opção inválida.");
                            continue;
                        }
                        System.out.println("Saque realizado com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Erro: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("\nDigite o nome do destinatário: ");
                    String nomeDoDestinatario = scanner.nextLine();
                    Cliente destinatario = clientes.buscarCliente(nomeDoDestinatario);

                    if (destinatario == null) {
                        System.out.println("Cliente não encontrado.");
                        continue;
                    }

                    System.out.println("\nEscolha a conta de origem da transferência:");
                    System.out.println("1 - Conta Corrente");
                    System.out.println("2 - Conta Poupança");
                    int escolhaDeOrigem = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("\nEscolha a conta de destino da transferência:");
                    System.out.println("1 - Conta Corrente");
                    System.out.println("2 - Conta Poupança");
                    int escolhaDeDestino = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o valor da transferência: ");
                    double valorDeTransferencia = scanner.nextDouble();
                    scanner.nextLine();

                    try {
                        if (escolhaDeOrigem == 1 && escolhaDeDestino == 1) {
                            cliente.getContaCorrente().transferir(destinatario.getContaCorrente(), valorDeTransferencia);
                        } else if (escolhaDeOrigem == 1 && escolhaDeDestino == 2) {
                            cliente.getContaCorrente().transferir(destinatario.getContaPoupanca(), valorDeTransferencia);
                        } else if (escolhaDeOrigem == 2 && escolhaDeDestino == 1) {
                            cliente.getContaPoupanca().transferir(destinatario.getContaCorrente(), valorDeTransferencia);
                        } else if (escolhaDeOrigem == 2 && escolhaDeDestino == 2) {
                            cliente.getContaPoupanca().transferir(destinatario.getContaPoupanca(), valorDeTransferencia);
                        } else {
                            System.out.println("Opção inválida.");
                            continue;
                        }
                        System.out.println("Transferência realizada com sucesso.");
                    } catch (Exception e) {
                        System.out.println("Algo não deu certo " + e.getMessage());
                    }
                    break;
                case 5:
                    cliente.getContaPoupanca().aplicarRendimento();
                    System.out.println("Rendimento aplicado com sucesso.");
                    break;
                case 6:
                    System.out.println("Esses são os clientes do nosso banco - ");
                    clientes.mostrarClientes();
                    break;

                case 8:
                    try {
                        cliente.getContaPoupanca().saqueAniversario(cliente);
                    } catch (Exception e) {
                        System.out.println("Erro no saque-aniversário: " + e.getMessage());
                    }
                    break;

            }
        }

        scanner.close();
    }
}
