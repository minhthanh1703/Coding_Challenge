package thanhpm.example.command;

import thanhpm.example.model.Canvas;
import thanhpm.example.model.Line;
import thanhpm.example.model.Point;
import thanhpm.example.service.impl.CanvasServiceImpl;
import thanhpm.example.util.Constant;
import thanhpm.example.util.Utils;

public class DrawLineCommand extends Command{
    public DrawLineCommand() {
    }

    public DrawLineCommand(String[] words, CanvasServiceImpl canvasService, char[][] matrix) {
        super(words, canvasService, matrix);
    }

    @Override
    /**
     * This method can add new line to canvas and print canvas to display
     * @param words This is command (String[])
     * @param canvasService
     * @param canvas This is canvas
     * @return canvas This is canvas changed
     */
    public Canvas action(String[] words, CanvasServiceImpl canvasService, Canvas canvas) {
        try {
            if(canvas.getMatrix() != null && canvas.getMatrix().length > 0){
                Utils.checkCommand(words);
                int x1 = Integer.parseInt(words[1]);
                int y1 = Integer.parseInt(words[2]);
                int x2 = Integer.parseInt(words[3]);
                int y2 = Integer.parseInt(words[4]);
                Utils.checkPositiveInt(x1);
                Utils.checkPositiveInt(y1);
                Utils.checkPositiveInt(x2);
                Utils.checkPositiveInt(y2);
                Point startPoint = new Point(x1, y1);
                Point endPoint = new Point(x2, y2);
                Line line = new Line(startPoint, endPoint);
                canvas = canvasService.drawLine(canvas, line, Constant.DEFAULT_COLOR);
                canvasService.printCanvas(canvas);
                return canvas;
            }else{
                System.out.println(Constant.CANVAS_EMPTY_MESSAGE);
            }
        }catch (Exception ex){
            if(ex.getMessage()==Constant.LINE_NOT_SUPPORT){
                System.out.println(Constant.LINE_NOT_SUPPORT);
            }else{
                System.out.println(Constant.ERROR_MESSAGE);
            }
        }
        return canvas;
    }
}
