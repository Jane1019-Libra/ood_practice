package ca.janelu.ood._01_black_and_white;

public class Grid {
    private int[][] grid;
    private int row;
    private int col;

    public Grid(int row, int col) {
        this.row = row;
        this.col = col;
        initBoard();
    }

    public void initBoard() {
        grid = new int[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                grid[i][j] = GridType.EMPTY.ordinal();
            }
        }
    }

    public int placePiece(int col, GridType gridType) {
        if (col < 0 || col >= this.col) {
            throw new IndexOutOfBoundsException("Invalid column");
        }
        if (gridType == GridType.EMPTY) {
            throw new RuntimeException("Invalid piece");
        }

        for (int i = 0; i < row; ++i) {
            if (grid[i][col] == GridType.EMPTY.ordinal()) {
                grid[i][col] = gridType.ordinal();
                return i;
            }
        }
        return -1;
    }

    public boolean checkWinCondition(int connectN, int row, int col, GridType piece) {
        //1.row
        int count = 0;
        for (int c = 0; c < this.col; c++) {
            if (grid[row][c] == piece.ordinal()) {
                count++;
            } else {
                count = 0;
            }
            if (count == connectN) {
                return true;
            }
        }
        //2.col

        count = 0;
        for (int r = 0; r < this.row; r++) {
            if (grid[r][col] == piece.ordinal()) {
                count++;
            } else {
                count = 0;
            }
            if (count == connectN) {
                return true;
            }
        }
        //3.Diagonal
        count = 0;
        for (int r = 0; r < this.row; r++) {
            int c = row + col - r; //row + col = r + c
            if (c >= 0 && c < this.col && grid[r][c] == piece.ordinal()) {
                count++;
            } else {
                count = 0;
            }
            if (count == connectN) {
                return true;
            }


        }

        count = 0;
        for (int r = 0; r < this.row; r++) {
            int c = col - row + r;//row - col = r - c
            if (c >= 0 && c < this.col && grid[r][c] == piece.ordinal()) {
                count++;
            } else {
                count = 0;
            }
            if (count == connectN) {
                return true;
            }
        }
        return false;
    }

    public void setGrid(int[][] grid) {
        this.grid = grid;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int[][] getGrid() {
        return grid;
    }

}
