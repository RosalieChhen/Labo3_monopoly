package monopoly;

import java.util.ArrayList;
import java.util.List;

public class MonopolyGame {
    private static final int NB_TURNS = 20;
    private static final int NB_DICE = 2;
    private static final int CASH_AMOUNT_AT_BEGINNING = 1500;
    private List<Player> players = new ArrayList<>();
    private Cup cup;
    private Board board;

    public MonopolyGame(int nbPlayer) {
        board = new Board();
        cup = new Cup(NB_DICE);
        if (nbPlayer > 8 || nbPlayer < 2) {
            throw new IllegalArgumentException("Le nombre de players ne peut être inférieur à 2 ou supérieur à 8");
        }

        for (int i = 0; i < nbPlayer; ++i) {
            players.add(new Player(i + 1, cup, board));
        }

        for(Player p : players){
            p.addCash(CASH_AMOUNT_AT_BEGINNING);
        }
    }

    public void playGame() {
        for (int idxTurn = 0; idxTurn < NB_TURNS; ++idxTurn) {
            playRound();
            System.out.println("#####  FIN DE TOUR #####\n");
        }
        System.out.println("***** FIN DU JEU *****");
    }

    private void playRound() {
        for (Player player : players) {
            System.out.println(String.format("===> Au %s de jouer", player));
            player.takeTurn();
        }
    }
}
