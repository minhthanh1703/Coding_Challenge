package thanhpm.main.service;

import thanhpm.main.model.Canvas;
import thanhpm.main.model.Point;

/**
 * This interface includes all the features of PointService
 * The PointServiceImpl will implement this interface
 */
public interface PointService {

    Canvas drawPoint(Canvas canvas, Point point, char c);

    char getValueAtIndex(Canvas canvas, Point point);
}
