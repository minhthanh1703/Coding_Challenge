package thanhpm.main.service.impl;

import thanhpm.main.model.Canvas;
import thanhpm.main.model.Line;
import thanhpm.main.model.Point;
import thanhpm.main.service.LineService;

public class LineServiceImpl implements LineService {

    //Create PointServiceImpl
    PointServiceImpl pointService = new PointServiceImpl();

    @Override
    /**
     * This method can draw a new line horizontal
     * @param canvas This is canvas
     * @param line this line want to add to canvas
     * @param c this is character want to render by line
     * @return canvas this canvas changed
     */
    public Canvas drawHorizontal(Canvas canvas, Line line, char c) {

        if (line.getStartPoint().getX() < line.getEndPoint().getX()) {
            for (int i = line.getStartPoint().getX(); i <= line.getEndPoint().getX(); i++) {
                canvas = pointService.drawPoint(canvas, new Point(i, line.getStartPoint().getY()), c);
            }
        } else {
            for (int i = line.getEndPoint().getX(); i <= line.getStartPoint().getX(); i++) {
                canvas = pointService.drawPoint(canvas, new Point(i, line.getStartPoint().getY()), c);
            }
        }
        return canvas;
    }


    @Override
    /**
     * This method can draw a new line vertical
     * @param canvas This is canvas
     * @param line this line want to add to canvas
     * @param c this is character want to render by line
     * @return canvas this canvas changed
     */
    public Canvas drawVertical(Canvas canvas, Line line, char c) {
        if (line.getStartPoint().getY() < line.getEndPoint().getY()) {
            for (int i = line.getStartPoint().getY(); i <= line.getEndPoint().getY(); i++) {
                canvas = pointService.drawPoint(canvas, new Point(line.getStartPoint().getX(), i), c);
            }
        } else {
            for (int i = line.getEndPoint().getY(); i <= line.getStartPoint().getY(); i++) {
                canvas = pointService.drawPoint(canvas, new Point(line.getStartPoint().getX(), i), c);
            }
        }
        return canvas;
    }


}
