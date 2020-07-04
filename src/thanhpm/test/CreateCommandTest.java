package thanhpm.test;

import org.junit.Assert;
import org.junit.Test;
import thanhpm.main.command.CreateCommand;
import thanhpm.main.model.Canvas;
import thanhpm.main.service.impl.CanvasServiceImpl;
import thanhpm.main.util.Constant;

public class CreateCommandTest {

    @Test(expected = Exception.class)
    public void givenInvalidCreateCommand() throws Exception {
        Canvas canvas = new Canvas(new char[0][0]);
        CanvasServiceImpl canvasService = new CanvasServiceImpl();
        CreateCommand createCommand = new CreateCommand();
        String[] commandErrorOne = "C 20".split(Constant.REGEX);
        String[] commandErrorTwo = "C 20 4 a".split(Constant.REGEX);
        String[] commandErrorThree = "C 20 a".split(Constant.REGEX);
        String[] commandErrorFour = "C 20 a".split(Constant.REGEX);

        createCommand.action(commandErrorOne, canvasService, canvas);
        createCommand.action(commandErrorTwo, canvasService, canvas);
        createCommand.action(commandErrorThree, canvasService, canvas);
        createCommand.action(commandErrorFour, canvasService, canvas);
    }

    @Test
    public void givenValidCreateCommand() throws Exception {
        Canvas canvas = new Canvas(new char[0][0]);
        CanvasServiceImpl canvasService = new CanvasServiceImpl();
        CreateCommand createCommand = new CreateCommand();
        String[] command = "C 20 4".split(Constant.REGEX);
        Assert.assertNotEquals(canvas.getMatrix(), createCommand.action(command, canvasService, canvas).getMatrix());
    }

}
