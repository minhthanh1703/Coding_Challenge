package thanhpm.example.command;

import thanhpm.example.model.Canvas;
import thanhpm.example.service.impl.CanvasServiceImpl;

public class Command {
    private String[] words;
    private CanvasServiceImpl canvasService;
    private char[][] matrix;

    public Command() {
    }

    public Command(String[] words, CanvasServiceImpl canvasService, char[][] matrix) {
        this.words = words;
        this.canvasService = canvasService;
        this.matrix = matrix;
    }

    public String[] getWords() {
        return words;
    }

    public void setWords(String[] words) {
        this.words = words;
    }

    public CanvasServiceImpl getCanvasService() {
        return canvasService;
    }

    public void setCanvasService(CanvasServiceImpl canvasService) {
        this.canvasService = canvasService;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    public Canvas action(String[] words, CanvasServiceImpl canvasService, Canvas canvas) {
        return canvas;
    }
}
