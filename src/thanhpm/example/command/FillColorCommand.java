package thanhpm.example.command;

import thanhpm.example.model.Canvas;
import thanhpm.example.model.Point;
import thanhpm.example.service.impl.CanvasServiceImpl;
import thanhpm.example.util.Constant;
import thanhpm.example.util.Utils;

public class FillColorCommand extends Command {

    public FillColorCommand() {
    }

    public FillColorCommand(String[] words, CanvasServiceImpl canvasService, char[][] matrix) {
        super(words, canvasService, matrix);
    }

    @Override
    /**
     * This method can fill the entire area connected and print canvas to display
     * @param words This is command (String[])
     * @param canvasService
     * @param canvas This is canvas
     * @return canvas This is canvas changed
     */
    public Canvas action(String[] words, CanvasServiceImpl canvasService, Canvas canvas) {
        try {
            if(canvas.getMatrix() != null && canvas.getMatrix().length > 0){
                Utils.checkCommand(words);
                int x = Integer.parseInt(words[1]);
                int y = Integer.parseInt(words[2]);
                Utils.checkPositiveInt(x);
                Utils.checkPositiveInt(y);
                char c = words[3].charAt(0);
                Point point = new Point(x, y);
                canvas = canvasService.fillColor(canvas, point, c);
                canvasService.printCanvas(canvas);
                return canvas;
            }else{
                System.out.println(Constant.CANVAS_EMPTY_MESSAGE);
            }
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println(Constant.ERROR_MESSAGE);
        }
        return canvas;
    }
}
