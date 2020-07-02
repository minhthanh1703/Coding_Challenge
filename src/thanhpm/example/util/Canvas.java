package thanhpm.example.util;

public class Canvas {

    private char matrix[][];

    public Canvas(char[][] matrix) {
        this.matrix = matrix;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    public Canvas() {
    }

    public void createCanvas(int wight, int height) {
        matrix = new char[wight][height];

        printCanvas(matrix);
    }

    public void printCanvas(char[][] matrix) {
        int wight = matrix.length;
        int height = matrix[0].length;
        for (int i = 0; i <= wight + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int h = 0; h < height; h++) {
            System.out.print("|");
            for (int w = 0; w < wight; w++) {
                System.out.print(matrix[w][h]);
            }
            System.out.println("|");
        }
        for (int i = 0; i <= wight + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void createLine(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            createVertical(x1, y1, x2, y2);
            printCanvas(matrix);
        } else if (y1 == y2) {
            createHorizontal(x1, y1, x2, y2);
            printCanvas(matrix);
        } else {
            System.out.println("error command");
        }
    }

    public void createRectangle(int x1, int y1, int x2, int y2) {
        createHorizontal(x1, y1, x2, y2);
        createVertical(x1, y1, x2, y2);
        printCanvas(matrix);
    }

    public void createHorizontal(int x1, int y1, int x2, int y2) {
        if (x1 < x2) {
            for (int w = x1 - 1; w < x2; w++) {
                matrix[w][y1 - 1] = 'x';
                matrix[w][y2 - 1] = 'x';
            }
        } else {
            for (int w = x2 - 1; w < x1; w++) {
                matrix[w][y1 - 1] = 'x';
                matrix[w][y2 - 1] = 'x';
            }
        }
    }

    public void createVertical(int x1, int y1, int x2, int y2) {
        if (y1 < y2) {
            for (int h = y1 - 1; h < y2; h++) {
                matrix[x1 - 1][h] = 'x';
                matrix[x2 - 1][h] = 'x';
            }
        } else {
            for (int h = y2 - 1; h < y1; h++) {
                matrix[x1 - 1][h] = 'x';
                matrix[x2 - 1][h] = 'x';
            }
        }
    }

    public void fillColor(int x, int y, char c){
        fill(x, y, c);
        printCanvas(matrix);
    }

    public void fill(int x, int y, char c) {
        if (x > 0 && y> 0 && x <= matrix.length && y <= matrix[0].length) {
            if (matrix[x - 1][y - 1] != 'x' && matrix[x - 1][y - 1] != c) {
                matrix[x - 1][y - 1] = c;
                fill(x - 1, y, c);
                fill(x + 1, y, c);
                fill(x, y - 1, c);
                fill(x, y + 1, c);
            }
        }

    }

}
