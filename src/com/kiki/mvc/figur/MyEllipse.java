package com.kiki.mvc.figur;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class MyEllipse extends Ellipse2D.Double implements IRectangularShape {
    @Override
    public void setFrameFromDiagonal(double x1, double y1,
                                     double x2, double y2){
        if (x2 < x1) {
            double t = x1;
            x1 = x2;
            x2 = t;
        }
        if (y2 < y1) {
            double t = y1;
            y1 = y2;
            y2 = t;
        }
        setFrame(x1, y1, x2 - x1, y2 - y1);
    }
    @Override
    public void setFrameFromDiagonal(Point2D p,Point2D f){
        double x1 =p.getX(); double y1=p.getY();
        double x2=f.getX(); double y2=f.getY();
        if (x2 < x1) {
            double t = x1;
            x1 = x2;
            x2 = t;
        }
        if (y2 < y1) {
            double t = y1;
            y1 = y2;
            y2 = t;
        }
        setFrame(x1, y1, x2 - x1, y2 - y1);
    }
}
