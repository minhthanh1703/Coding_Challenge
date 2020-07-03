package thanhpm.example.command;

import thanhpm.example.model.Canvas;
import thanhpm.example.service.impl.CanvasServiceImpl;
import thanhpm.example.util.Constant;
import thanhpm.example.util.Utils;

public class CreateCommand extends Command{

    public CreateCommand() {
    }

    public CreateCommand(String[] words, CanvasServiceImpl canvasService, char[][] matrix) {
        super(words, canvasService, matrix);
    }

    @Override
    /**
     * This method can create new canvas and print canvas to display
     * @param words This is command (String[])
     * @param canvasService
     * @param canvas This is canvas
     * @return canvas This is new canvas
     */
    public Canvas action(String[] words, CanvasServiceImpl canvasService, Canvas canvas) {
        try{
            Utils.checkCommand(words);
            int wight = Integer.parseInt(words[1]);
            int height = Integer.parseInt(words[2]);
            Utils.checkPositiveInt(wight);
            Utils.checkPositiveInt(height);
            canvas.setMatrix(canvasService.createCanvas(wight, height));
            canvasService.printCanvas(canvas);
            return canvas;
        }catch (Exception ex){
            System.out.println(Constant.ERROR_MESSAGE);
        }
        return canvas;
    }
}
