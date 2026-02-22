package service;

import model.ContaBancaria;
import java.util.Scanner;

public class BancoService {

    private ContaBancaria conta;
    private Scanner scanner;

    public BancoService(ContaBancaria conta) {
        this.conta = conta;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("Bem-vindo, " + conta.getTitular());

        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        if (!conta.autenticar(senha)) {
            System.out.println("Senha incorreta. Encerrando sistema.");
            return;
        }

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    depositar();
                    break;
                case 2:
                    sacar();
                    break;
                case 3:
                    System.out.println("Saldo atual: " + conta.getSaldo());
                    break;
                case 4:
                    conta.exibirHistorico();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    private void exibirMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1 - Depositar");
        System.out.println("2 - Sacar");
        System.out.println("3 - Ver Saldo");
        System.out.println("4 - Histórico");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    private void depositar() {
        System.out.print("Valor para depósito: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        conta.depositar(valor);
    }

    private void sacar() {
        System.out.print("Valor para saque: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        if (!conta.sacar(valor)) {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }
}
