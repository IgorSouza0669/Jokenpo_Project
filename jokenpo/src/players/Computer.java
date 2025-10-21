package players;

import java.util.Random;

public class Computer {

    private int pedra = 1;
    private int papel = 2;
    private int tesoura = 3;

    Random jogadaComputador = new Random();

    public int gerarJogadaComputador() {
        return jogadaComputador.nextInt(3) + 1;
    }

}
