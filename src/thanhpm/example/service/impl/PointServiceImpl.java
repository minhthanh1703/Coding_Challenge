package thanhpm.example.service.impl;

import thanhpm.example.model.Canvas;
import thanhpm.example.model.Point;
import thanhpm.example.service.PointService;

public class PointServiceImpl implements PointService {

    @Override
    /**
     * This method can draw a new point
     * @param canvas This is canvas
     * @param point this line want to add to canvas
     * @param c this is character want to render by line
     * @return canvas this canvas changed
     */
    public Canvas drawPoint(Canvas canvas, Point point, char c) {
        char[][] matrix = canvas.getMatrix();
        matrix[point.getX() - 1][point.getY() - 1] = c;
        canvas.setMatrix(matrix);
        return canvas;
    }

    @Override
    /**
     * This method can get value of one point
     * @param canvas This is canvas
     * @param point this line want to add to canvas
     * @return char this is value of point
     */
    public char getValueAtIndex(Canvas canvas, Point point) {
        return canvas.getMatrix()[point.getX() - 1][point.getY() - 1];
    }
}
