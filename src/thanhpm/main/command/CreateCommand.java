package thanhpm.main.command;

import thanhpm.main.model.Canvas;
import thanhpm.main.service.impl.CanvasServiceImpl;
import thanhpm.main.util.Constant;
import thanhpm.main.util.Utils;

public class CreateCommand extends Command {

    public CreateCommand() {
    }

    public CreateCommand(String[] words, CanvasServiceImpl canvasService, Canvas canvas) {
        super(words, canvasService, canvas);
    }

    @Override
    /**
     * This method can create new canvas and print canvas to display
     * @param words This is command (String[])
     * @param canvasService
     * @param canvas This is canvas
     * @return canvas This is new canvas
     */
    public Canvas action(String[] words, CanvasServiceImpl canvasService, Canvas canvas) throws Exception {
        Utils.checkCommand(words);
        int wight = Integer.parseInt(words[1]);
        int height = Integer.parseInt(words[2]);
        Utils.checkPositiveInt(wight);
        Utils.checkPositiveInt(height);
        canvas.setMatrix(canvasService.createCanvas(wight, height));
        canvasService.printCanvas(canvas);

        return canvas;

    }
}
