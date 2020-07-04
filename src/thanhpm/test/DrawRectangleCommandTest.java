package thanhpm.test;

import org.junit.Assert;
import org.junit.Test;
import thanhpm.main.command.DrawLineCommand;
import thanhpm.main.command.DrawRectangleCommand;
import thanhpm.main.model.Canvas;
import thanhpm.main.service.impl.CanvasServiceImpl;
import thanhpm.main.util.Constant;

public class DrawRectangleCommandTest {

    @Test(expected = Exception.class)
    public void givenCanvasEmpty() throws Exception {
        Canvas canvas = new Canvas(new char[0][0]);
        CanvasServiceImpl canvasService = new CanvasServiceImpl();
        DrawRectangleCommand rectangleCommand = new DrawRectangleCommand();
        String[] command = "R 14 1 18 3".split(Constant.REGEX);

        rectangleCommand.action(command, canvasService, canvas);
    }

    @Test(expected = Exception.class)
    public void givenInvalidDrawCommand() throws Exception {
        Canvas canvas = new Canvas(new char[20][4]);
        CanvasServiceImpl canvasService = new CanvasServiceImpl();
        DrawRectangleCommand rectangleCommand = new DrawRectangleCommand();
        String[] commandErrorOne = "R 14 1 18 ".split(Constant.REGEX);
        String[] commandErrorTwo = "R 14 1 18".split(Constant.REGEX);
        String[] commandErrorThree = "R 14 1 18 3 a".split(Constant.REGEX);
        String[] commandErrorFour = "R 14 1 18 a".split(Constant.REGEX);

        rectangleCommand.action(commandErrorOne, canvasService, canvas);
        rectangleCommand.action(commandErrorTwo, canvasService, canvas);
        rectangleCommand.action(commandErrorThree, canvasService, canvas);
        rectangleCommand.action(commandErrorFour, canvasService, canvas);
    }

    @Test
    public void givenValidDrawCommand() throws Exception {
        Canvas canvas = new Canvas(new char[20][4]);
        CanvasServiceImpl canvasService = new CanvasServiceImpl();
        DrawRectangleCommand rectangleCommand = new DrawRectangleCommand();

        String[] command = "R 14 1 18 3".split(Constant.REGEX);

        rectangleCommand.action(command, canvasService, canvas);
    }
}
