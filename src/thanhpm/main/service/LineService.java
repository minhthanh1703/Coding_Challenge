package thanhpm.main.service;

import thanhpm.main.model.Canvas;
import thanhpm.main.model.Line;
/**
 * This interface includes all the features of LineService
 * The LineServiceImpl will implement this interface
 */
public interface LineService {
    Canvas drawHorizontal (Canvas canvas, Line line, char c);

    Canvas drawVertical (Canvas canvas, Line line, char c);
}
