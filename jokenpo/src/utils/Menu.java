package utils;

import java.util.Scanner;

public class Menu {

    private Scanner scan;

    public Menu(Scanner scan) {
        this.scan = scan;
    }

    public int menuPrincipal() {
        System.out.println("1 - Jogar");
        System.out.println("2 - Sair");
        System.out.print("Escolha: ");
        return lerInt();
    }

    public void jogada() {
        System.out.printf("%nEscolha sua jogada:%n");
        System.out.println("1 - Pedra");
        System.out.println("2 - Papel");
        System.out.println("3 - Tesoura");
        System.out.print("Digite sua opção: ");
    }

    //!scan.hasNestInt serve para validar se a entrada do scan, é um int ou n
    private int lerInt() {
        while (!scan.hasNextInt()) {
            System.out.println("Opção inválida! Digite um número.");
            scan.next();
        }
        int opcao = scan.nextInt();
        scan.nextLine();
        return opcao;
    }
}
