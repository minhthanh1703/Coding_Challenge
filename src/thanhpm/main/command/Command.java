package thanhpm.main.command;

import thanhpm.main.model.Canvas;
import thanhpm.main.service.impl.CanvasServiceImpl;

public class Command {
    private String[] words;
    private CanvasServiceImpl canvasService;
    private Canvas canvas;

    public Command() {
    }

    public Command(String[] words, CanvasServiceImpl canvasService, Canvas canvas) {
        this.words = words;
        this.canvasService = canvasService;
        this.canvas = canvas;
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

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public Canvas action(String[] words, CanvasServiceImpl canvasService, Canvas canvas) throws Exception {
        return canvas;
    }
}
