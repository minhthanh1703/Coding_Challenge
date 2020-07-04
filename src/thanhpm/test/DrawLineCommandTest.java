package thanhpm.test;

import org.junit.Assert;
import org.junit.Test;
import thanhpm.main.command.DrawLineCommand;
import thanhpm.main.model.Canvas;
import thanhpm.main.service.impl.CanvasServiceImpl;
import thanhpm.main.util.Constant;

public class DrawLineCommandTest {

    @Test(expected = Exception.class)
    public void givenCanvasEmpty() throws Exception {
        Canvas canvas = new Canvas(new char[0][0]);
        CanvasServiceImpl canvasService = new CanvasServiceImpl();
        DrawLineCommand drawLineCommand = new DrawLineCommand();
        String[] commandError = "L 1 2 6 2".split(Constant.REGEX);
        drawLineCommand.action(commandError, canvasService, canvas);
    }

    @Test(expected = Exception.class)
    public void givenInvalidDrawCommand() throws Exception {
        Canvas canvas = new Canvas(new char[20][4]);
        CanvasServiceImpl canvasService = new CanvasServiceImpl();
        DrawLineCommand drawLineCommand = new DrawLineCommand();

        String[] commandErrorOne = "L a b c d".split(Constant.REGEX);
        String[] commandErrorTwo = "L 1 2 6".split(Constant.REGEX);
        String[] commandErrorThree = "L 1 2 6 3".split(Constant.REGEX);
        String[] commandErrorFour = "L 1 2 6 2 a".split(Constant.REGEX);

        drawLineCommand.action(commandErrorOne, canvasService, canvas);
        drawLineCommand.action(commandErrorTwo, canvasService, canvas);
        drawLineCommand.action(commandErrorThree, canvasService, canvas);
        drawLineCommand.action(commandErrorFour, canvasService, canvas);
    }

    @Test
    public void givenValidDrawCommand() throws Exception {
        Canvas canvas = new Canvas(new char[20][4]);
        CanvasServiceImpl canvasService = new CanvasServiceImpl();
        DrawLineCommand drawLineCommand = new DrawLineCommand();

        String[] command = "L 1 2 6 2".split(Constant.REGEX);

        drawLineCommand.action(command, canvasService, canvas);
    }
}
