package thanhpm.test;

import org.junit.Test;
import thanhpm.main.command.DrawRectangleCommand;
import thanhpm.main.command.FillColorCommand;
import thanhpm.main.model.Canvas;
import thanhpm.main.service.impl.CanvasServiceImpl;
import thanhpm.main.util.Constant;

public class FillColorTest {

    @Test(expected = Exception.class)
    public void givenCanvasEmpty() throws Exception {
        Canvas canvas = new Canvas(new char[0][0]);
        CanvasServiceImpl canvasService = new CanvasServiceImpl();
        FillColorCommand fillColorCommand = new FillColorCommand();
        String[] commandError = "B 10 3 o".split(Constant.REGEX);

        fillColorCommand.action(commandError, canvasService, canvas);
    }

    @Test
    public void givenValidCommand() throws Exception {
        Canvas canvas = new Canvas(new char[20][4]);
        CanvasServiceImpl canvasService = new CanvasServiceImpl();
        FillColorCommand fillColorCommand = new FillColorCommand();

        String[] command = "B 10 3 o".split(Constant.REGEX);

        fillColorCommand.action(command, canvasService, canvas);
    }
}
