package h2;

public class Spielstein {
    private int currentRow;
    private int currentCol;
    private Spielbrett brett;

    public Spielstein(Spielbrett brett, int indexRow, int indexCol) {
        this.brett = brett;
        this.currentRow = indexRow;
        this.currentCol = indexCol;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public void setCurrentRow(int currentRow) {
        this.currentRow = currentRow;
    }

    public int getCurrentCol() {
        return currentCol;
    }

    public void setCurrentCol(int currentCol) {
        this.currentCol = currentCol;
    }

    public Spielbrett getBrett() {
        return brett;
    }

    public void setBrett(Spielbrett brett) {
        this.brett = brett;
    }

    private boolean movesOut() {
        char d = brett.getBrett()[currentRow][currentCol].getDirection();
        if (d == 'U' && currentRow == 0) return true;
        if (d == 'D' && currentRow == brett.getDim() - 1) return true;
        if (d == 'L' && currentCol == 0) return true;
        if (d == 'R' && currentCol == brett.getDim() - 1) return true;
        return false;
    }

    public void go(int n) {
        for (int i = 0; i < n; i++) {
            Feld f = brett.getBrett()[currentRow][currentCol];
            if (f.isBoese() || movesOut()) {
                continue;
            }

            switch (f.getDirection()) {
                case 'U':
                    currentRow--;
                    break;
                case 'D':
                    currentRow++;
                    break;
                case 'L':
                    currentCol--;
                    break;
                case 'R':
                    currentCol++;
                    break;
            }
        }
    }
}
