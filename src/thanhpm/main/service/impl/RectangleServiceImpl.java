package thanhpm.main.service.impl;

import thanhpm.main.model.Canvas;
import thanhpm.main.model.Point;
import thanhpm.main.model.Rectangle;
import thanhpm.main.service.RectangleService;

public class RectangleServiceImpl implements RectangleService {

    //create pointService
    PointServiceImpl pointService = new PointServiceImpl();

    @Override
    /**
     * This method can draw 2 line horizontal parallel
     * @param canvas This is canvas
     * @param line this line want to add to canvas
     * @param c this is character want to render by line
     * @return canvas this canvas changed
     */
    public Canvas drawHorizontal(Canvas canvas, Rectangle rectangle, char c) {
        if (rectangle.getStartPoint().getX() < rectangle.getEndPoint().getX()) {
            for (int i = rectangle.getStartPoint().getX(); i <= rectangle.getEndPoint().getX(); i++) {
                canvas = pointService.drawPoint(canvas, new Point(i, rectangle.getStartPoint().getY()), c);
                canvas = pointService.drawPoint(canvas, new Point(i, rectangle.getEndPoint().getY()), c);
            }
        } else {
            for (int i = rectangle.getEndPoint().getX(); i <= rectangle.getStartPoint().getX(); i++) {
                canvas = pointService.drawPoint(canvas, new Point(i, rectangle.getStartPoint().getY()), c);
                canvas = pointService.drawPoint(canvas, new Point(i, rectangle.getEndPoint().getY()), c);
            }
        }
        return canvas;
    }

    @Override
    /**
     * This method can draw 2 line vertical parallel
     * @param canvas This is canvas
     * @param line this line want to add to canvas
     * @param c this is character want to render by line
     * @return canvas this canvas changed
     */
    public Canvas drawVertical(Canvas canvas, Rectangle rectangle, char c) {
        if (rectangle.getStartPoint().getY() < rectangle.getEndPoint().getY()) {
            for (int i = rectangle.getStartPoint().getY(); i <= rectangle.getEndPoint().getY(); i++) {
                canvas = pointService.drawPoint(canvas, new Point(rectangle.getStartPoint().getX(), i), c);
                canvas = pointService.drawPoint(canvas, new Point(rectangle.getEndPoint().getX(), i), c);
            }
        } else {
            for (int i = rectangle.getEndPoint().getY(); i <= rectangle.getStartPoint().getY(); i++) {
                canvas = pointService.drawPoint(canvas, new Point(rectangle.getStartPoint().getX(), i), c);
                canvas = pointService.drawPoint(canvas, new Point(rectangle.getEndPoint().getX(), i), c);
            }
        }
        return canvas;
    }
}
