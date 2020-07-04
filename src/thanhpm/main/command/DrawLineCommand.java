package thanhpm.main.command;

import thanhpm.main.model.Canvas;
import thanhpm.main.model.Line;
import thanhpm.main.model.Point;
import thanhpm.main.service.impl.CanvasServiceImpl;
import thanhpm.main.util.Constant;
import thanhpm.main.util.Utils;

public class DrawLineCommand extends Command {
    public DrawLineCommand() {
    }

    public DrawLineCommand(String[] words, CanvasServiceImpl canvasService, Canvas canvas) {
        super(words, canvasService, canvas);
    }

    @Override
    /**
     * This method can add new line to canvas and print canvas to display
     * @param words This is command (String[])
     * @param canvasService
     * @param canvas This is canvas
     * @return canvas This is canvas changed
     */
    public Canvas action(String[] words, CanvasServiceImpl canvasService, Canvas canvas) throws Exception {
        if (canvas.getMatrix() != null && canvas.getWidht() > 0) {
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
        } else {
            throw new Exception(Constant.CANVAS_EMPTY_MESSAGE);
        }
        return canvas;


    }
}
