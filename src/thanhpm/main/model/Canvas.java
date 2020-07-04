package thanhpm.main.model;

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

    public int getWidht() {
        if (matrix != null) {
            return matrix.length;
        }
        return 0;
    }

    public int getHeight() {
        if(matrix != null){
            return matrix[0].length;
        }
        return 0;
    }

}
