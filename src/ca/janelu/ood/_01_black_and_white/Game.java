package ca.janelu.ood._01_black_and_white;

import java.util.*;

public class Game {
    private Grid grid;
    private List<Player> players = new ArrayList<>();
    private int score;
    private int connectN;

    private Map<String, Integer> scores = new HashMap<>();

    static Scanner input = new Scanner(System.in);

    public Game(Grid grid, int score, int connectN) {
        this.grid = grid;
        this.score = score;
        this.connectN = connectN;
        this.players.add(new Player("Player 1", GridType.BLACK));
        this.players.add(new Player("Player 2", GridType.WHITE));

        for (Player player : players) {
            this.scores.put(player.getName(), 0);
        }

    }

    private void printBoard() {
        System.out.println("Board:");
        int[][] grid = this.grid.getGrid();
        for (int i = 0; i < grid.length; i++) {
            String row = "";
            for (int piece : grid[i]) {
                if (piece == GridType.EMPTY.ordinal()) {
                    row += "0 ";
                } else if (piece == GridType.BLACK.ordinal()) {
                    row += "B ";
                } else if (piece == GridType.WHITE.ordinal()) {
                    row += "W ";
                }
            }
            System.out.println(row);

        }
        System.out.println();
    }

    private int[] playMove(Player player) {
        printBoard();
        System.out.println(player.getName() + "'s turn");
        int colNum = grid.getCol();
        System.out.println("enter col 0 to " + (colNum - 1) + " to add piece:");
        int moveCol = input.nextInt();
        int movRow = grid.placePiece(moveCol, player.getGridType());

        return new int[]{movRow, moveCol};
    }
    private Player playRound() {
        while (true) {
            for (Player player : players) {
                int[] pos = playMove(player);
                int row = pos[0];
                int col = pos[1];
                GridType pieceColor = player.getGridType();
                if (this.grid.checkWinCondition(connectN, row, col, pieceColor)) {
                    scores.put(player.getName(), this.scores.get(player.getName()) + 1);
                    return player;
                }
            }
        }

    }

    public void play() {
        int maxScore = 0;
        Player winner = null;
        while (maxScore < this.score) {
            winner = playRound();
            System.out.println(winner.getName() + "won the round");
            maxScore = Math.max(this.scores.get(winner.getName()), maxScore);
            grid.initBoard();

        }

        System.out.println("winner is " + winner.getName());
    }

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getConnectN() {
        return connectN;
    }

    public void setConnectN(int connectN) {
        this.connectN = connectN;
    }


    public static void main(String[] args) {
        Grid grid = new Grid(15, 15);
        Game game = new Game(grid, 5, 3);
        game.play();
    }

}
