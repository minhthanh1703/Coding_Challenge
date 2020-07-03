package thanhpm.example.service.impl;

import thanhpm.example.model.Canvas;
import thanhpm.example.model.Line;
import thanhpm.example.model.Point;
import thanhpm.example.model.Rectangle;
import thanhpm.example.service.CanvasService;
import thanhpm.example.util.Constant;

public class CanvasServiceImpl implements CanvasService {

    //create LineServiceImpl
    LineServiceImpl lineService = new LineServiceImpl();

    //create RectangleServiceImpl
    RectangleServiceImpl rectangleService = new RectangleServiceImpl();

    //create PointServiceImpl
    PointServiceImpl pointService = new PointServiceImpl();

    @Override
    /**
     * This method can check the number is positive or not
     * @param widht This is widht value of canvas want to create
     * @param height This is height value of canvas want to create
     * @return char[][] This return is 2-dimensional arrays
     */
    public char[][] createCanvas(int widht, int height) {
        return new char[widht][height];
    }

    @Override
    /**
     * This method can render canvas to console
     * @param canvas This is canvas want to render
     */
    public void printCanvas(Canvas canvas) {

        //widht of matrix and height of matrix
        int widht = canvas.getWidht();
        int height = canvas.getHeight();

        //render the top part of the frame
        for (int i = 0; i <= widht + 2; i++) {
            System.out.print("-");
        }
        System.out.println();

        //render the content
        char[][] matrix = canvas.getMatrix();
        for (int h = 0; h < height; h++) {
            System.out.print("|");
            for (int w = 0; w < widht; w++) {
                System.out.print(matrix[w][h]);
            }
            System.out.println("|");
        }

        //render the bottom part of the frame
        for (int i = 0; i <= widht + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    @Override
    /**
     * This method can draw a new line
     * @param canvas This is canvas
     * @param line this line want to add to canvas
     * @param c this is character want to render by line
     * @return canvas this canvas changed
     */
    public Canvas drawLine(Canvas canvas, Line line, char c) throws Exception {
        if(line.getStartPoint().getX() == line.getEndPoint().getX() && line.getStartPoint().getY() == line.getEndPoint().getY()){
            throw new Exception(Constant.ERROR_MESSAGE);
        }

        //if lise is horizontal lise
        if (line.getStartPoint().getX() == line.getEndPoint().getX()) {
            canvas = lineService.drawVertical(canvas, line, c);
        } else if (line.getStartPoint().getY() == line.getEndPoint().getY()) {
            //if line is vertical lise
            canvas = lineService.drawHorizontal(canvas, line, c);
        } else {
            //not support
            throw new Exception(Constant.LINE_NOT_SUPPORT);
        }
        return canvas;
    }

    @Override
    /**
     * This method can draw a new Rectangle
     * @param canvas This is canvas
     * @param rectangle this rectangle want to add to canvas
     * @param c this is character want to render by rectangle
     * @return canvas this canvas changed
     */
    public Canvas drawRectangle(Canvas canvas, Rectangle rectangle, char c) throws Exception {
        if(rectangle.getStartPoint().getX() == rectangle.getEndPoint().getX()
                || rectangle.getStartPoint().getY() == rectangle.getEndPoint().getY()){
            throw new Exception(Constant.ERROR_MESSAGE);
        }
        //render 2 horizontal line parallel
        canvas = rectangleService.drawHorizontal(canvas, rectangle, c);
        //render 2 vertical line parallel
        canvas = rectangleService.drawVertical(canvas, rectangle, c);
        return canvas;
    }

    @Override
    /**
     * This method can fill the entire area connected
     * @param canvas This is canvas
     * @param point This is a point in the area you want to fill
     * @param c this is character want to render by rectangle
     * @return canvas this canvas changed
     */
    public Canvas fillColor(Canvas canvas, Point point, char c) {
        fillArea(canvas, point, c);
        return canvas;
    }


    /**
     * This method can change the values of points around the selected point
     * @param canvas This is canvas
     * @param point This is a point in the area you want to fill
     * @param c this is character want to render by rectangle
     * @return canvas this canvas changed
     */
    private void fillArea(Canvas canvas, Point point, char c) {
        if (point.getX() > 0 && point.getY() > 0 && point.getX() <= canvas.getWidht() && point.getY() <= canvas.getHeight()) {
            if (pointService.getValueAtIndex(canvas, point) != Constant.DEFAULT_COLOR && pointService.getValueAtIndex(canvas, point) != c) {
                canvas = pointService.drawPoint(canvas, point, c);
                fillArea(canvas, new Point(point.getX() - 1, point.getY()), c);
                fillArea(canvas, new Point(point.getX() + 1, point.getY()), c);
                fillArea(canvas, new Point(point.getX(), point.getY() -1) , c);
                fillArea(canvas, new Point(point.getX() , point.getY() +1), c);
            }
        }
    }
}
