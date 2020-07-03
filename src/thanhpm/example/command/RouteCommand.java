package thanhpm.example.command;

import thanhpm.example.model.Canvas;
import thanhpm.example.service.impl.CanvasServiceImpl;
import thanhpm.example.util.Constant;

import java.util.Scanner;

public class RouteCommand {

    //Create Scanner, CanvasSericeImpl, char[][] (canvas)
    private Scanner scanner = new Scanner(System.in);
    private CanvasServiceImpl canvasService = new CanvasServiceImpl();

    private char[][] matrixCanvas = new char[0][0];
    Canvas canvas = new Canvas(matrixCanvas);

    public void routeRun (){
        System.out.println(Constant.WELCOME_MESSAGE);
        String choice;
        do{
            System.out.print(Constant.ENTER_COMMAND);
            String command = scanner.nextLine().trim();
            String[] words = command.split(Constant.REGEX);
            choice = words[0];
            switch (choice.toUpperCase()){
                case Constant.OPTION_CREATE_CANVAS:
                    createCommand(words);
                    break;
                case Constant.OPTION_DRAW_LINE:
                    drawLineCommand(words);
                    break;
                case Constant.OPTION_DRAW_RECTANGLE:
                    drawRectangleCommand(words);
                    break;
                case Constant.OPTION_FILL_COLOR:
                    fillColorCommand(words);
                    break;
                case Constant.OPTION_QUIT:
                    quit();
                    break;
            }
        }while(!choice.equals(Constant.OPTION_QUIT));
    }

    /**
     * This method can create new canvas and print canvas to display
     * @param words This is command (String[])
     */
    private void createCommand(String[] words){
        CreateCommand create = new CreateCommand();
        canvas = create.action(words, canvasService, canvas);
    }

    /**
     * This method can add new line to canvas and print canvas to display
     * @param words This is command (String[])
     */
    private void drawLineCommand(String[] words){
        DrawLineCommand drawLine = new DrawLineCommand();
        canvas = drawLine.action(words, canvasService, canvas);

    }

    /**
     * This method can add new rectangle to canvas and print canvas to display
     * @param words This is command (String[])
     */
    private void drawRectangleCommand(String[] words){
        DrawRectangleCommand drawRectangle = new DrawRectangleCommand();
        canvas = drawRectangle.action(words, canvasService, canvas);
    }

    /**
     * This method can fill the entire area connected and print canvas to display
     * @param words This is command (String[])
     */
    private void fillColorCommand(String[] words){
        FillColorCommand fillColor = new FillColorCommand();
        canvas = fillColor.action(words, canvasService, canvas);
    }

    /**
     * This method can stop application
     */
    private void quit(){
        scanner.close();
        System.out.println(Constant.EXIT_MESSAGE);
    }

}
