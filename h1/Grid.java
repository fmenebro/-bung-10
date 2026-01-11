package h1;

public class Grid {
    private Cell[][] gridArray;

    public Grid(Cell[] cells, int gridRows, int gridCols) {
        gridArray = new Cell[gridRows][gridCols];
        for (int i = 0; i < gridRows; i++) {
            for (int j = 0; j < gridCols; j++) {
                gridArray[i][j] = new Cell(i, j);
            }
        }

        for (Cell c : cells) {
            int r = c.getIndexRow();
            int col = c.getIndexCol();
            if (r >= 0 && col >= 0 && r < gridRows && col < gridCols) {
                gridArray[r][col].setAlive(true);
            }
        }

        for (int i = 0; i < gridRows; i++) {
            for (int j = 0; j < gridCols; j++) {
                gridArray[i][j].countLivingNeighbors(gridArray);
            }
        }
    }

    public Cell[][] getGridArray() {
        return gridArray;
    }

    public void setGridArray(Cell[][] gridArray) {
        this.gridArray = gridArray;
    }

    public void computeNextGen() {
        for (int i = 0; i < gridArray.length; i++) {
            for (int j = 0; j < gridArray[0].length; j++) {
                gridArray[i][j].countLivingNeighbors(gridArray);
            }
        }

        for (int i = 0; i < gridArray.length; i++) {
            for (int j = 0; j < gridArray[0].length; j++) {
                gridArray[i][j].setAlive(gridArray[i][j].isAliveNextGen());
            }
        }
    }

    public void computeGeneration(int n) {
        for (int i = 0; i < n; i++) {
            computeNextGen();
        }
    }
}
