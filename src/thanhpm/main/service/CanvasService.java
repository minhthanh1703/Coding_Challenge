package thanhpm.main.service;

import thanhpm.main.model.Canvas;
import thanhpm.main.model.Line;
import thanhpm.main.model.Point;
import thanhpm.main.model.Rectangle;
/**
 * This interface includes all the features of CanvasService
 * The CanvasServiceImpl will implement this interface
 */
public interface CanvasService {

    char[][] createCanvas(int wight, int height);

    void printCanvas(Canvas canvas);

    Canvas drawLine(Canvas canvas, Line line, char c) throws Exception;

    Canvas drawRectangle(Canvas canvas, Rectangle rectangle, char c) throws Exception;

    Canvas fillColor(Canvas canvas, Point point, char c);
}
