package game;

import players.Computer;
import players.Player;
import utils.Menu;

import java.util.Random;
import java.util.Scanner;

public class Game{
    public static void iniciar(String[] args) {


        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        Player player = new Player();
        Computer computer = new Computer();
        Menu menu = new Menu(scan);

        System.out.printf("%nBem Vindo ao jogo Jokenpo!%n");

        boolean jogo = true;

        while(jogo) {

            int opcaoMenu = menu.menuPrincipal();

            switch (opcaoMenu) {
                case 1 -> {
                    menu.jogada();
                    int opcao = scan.nextInt();


                    String jogadaPlayer = switch (opcao) {
                        case 1 -> "Pedra";
                        case 2 -> "Papel";
                        case 3 -> "Tesoura";
                        default -> "Opção inválida";
                    };
                    int jogadaComputador = computer.gerarJogadaComputador();

                    partida(opcao, jogadaComputador, player);

                    escolhasComputador(jogadaComputador);

                }
                case 2 ->{
                    System.out.printf("Encerrando...%n");
                    jogo = false;
                    System.out.println("Jokenpo encerrado com sucesso!");
                }
                default -> System.out.println("Opção inválida!");
            }
        }
        scan.close();
    }


    private static void partida(int opcao, int jogadaComputador, Player player) {
        if (opcao == jogadaComputador){
        System.out.printf("%nEmpate%n");
        }else if (
                (opcao == player.getPedra() && jogadaComputador == player.getTesoura()) ||
                (opcao == player.getPapel() && jogadaComputador == player.getPedra()) ||
                (opcao == player.getTesoura() && jogadaComputador == player.getPapel())
        ){
            System.out.printf("%nParabens, você venceu!!%n");
        }else if ((opcao == player.getPedra() && jogadaComputador == player.getPapel()) ||
                (opcao == player.getPapel() && jogadaComputador == player.getTesoura()) ||
                (opcao == player.getTesoura() && jogadaComputador == player.getPedra()))
        {
            System.out.printf("%nVocê perdeu, tente novamente%n");
        }
        else {
            System.out.printf("%nOpção inválida%n");
        }
    }

    private static void escolhasComputador(int jogadaComputador) {
        if(jogadaComputador == 1){
            System.out.printf("%nA máquina escolheu Pedra%n%n");
        } else if (jogadaComputador == 2) {
            System.out.printf("%nA máquina escolheu Papel%n%n");
        }else {
            System.out.printf("%nA máquina escolheu Tesoura%n%n");
        }
    }
}
