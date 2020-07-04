package thanhpm.main.command;

import thanhpm.main.model.Canvas;
import thanhpm.main.model.Point;
import thanhpm.main.service.impl.CanvasServiceImpl;
import thanhpm.main.util.Constant;
import thanhpm.main.util.Utils;

public class FillColorCommand extends Command {

    public FillColorCommand() {
    }

    public FillColorCommand(String[] words, CanvasServiceImpl canvasService, Canvas canvas) {
        super(words, canvasService, canvas);
    }

    @Override
    /**
     * This method can fill the entire area connected and print canvas to display
     * @param words This is command (String[])
     * @param canvasService
     * @param canvas This is canvas
     * @return canvas This is canvas changed
     */
    public Canvas action(String[] words, CanvasServiceImpl canvasService, Canvas canvas) throws Exception {

        if (canvas.getMatrix() != null && canvas.getWidht() > 0) {
            Utils.checkCommand(words);
            int x = Integer.parseInt(words[1]);
            int y = Integer.parseInt(words[2]);
            Utils.checkPositiveInt(x);
            Utils.checkPositiveInt(y);
            char c = words[3].charAt(0);
            Point point = new Point(x, y);
            canvas = canvasService.fillColor(canvas, point, c);
            canvasService.printCanvas(canvas);
        } else {
           throw new Exception(Constant.CANVAS_EMPTY_MESSAGE);
        }

        return canvas;

    }
}
