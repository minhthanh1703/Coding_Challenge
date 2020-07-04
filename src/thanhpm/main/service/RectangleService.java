package thanhpm.main.service;

import thanhpm.main.model.Canvas;
import thanhpm.main.model.Rectangle;

/**
 * This interface includes all the features of RectangleService
 * The RectangleServiceImpl will implement this interface
 */
public interface RectangleService {
    Canvas drawHorizontal(Canvas canvas, Rectangle rectangle, char c);
    Canvas drawVertical(Canvas canvas, Rectangle rectangle, char c);
}
