package thanhpm.example.service;

import thanhpm.example.model.Canvas;
import thanhpm.example.model.Point;

/**
 * This interface includes all the features of PointService
 * The PointServiceImpl will implement this interface
 */
public interface PointService {

    Canvas drawPoint(Canvas canvas, Point point, char c);

    char getValueAtIndex(Canvas canvas, Point point);
}
