package com.kiki.mvc.figur;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class MyLine extends Line2D.Double implements IRectangularShape{
    public MyLine(){}
    @Override
    public void setFrameFromDiagonal(double x1, double y1,
                                     double x2, double y2)
    {
        setLine(x1,y1,x2,y2);
    }

    @Override
    public void setFrameFromDiagonal(Point2D d, Point2D p) {
        setLine(d,p);
    }

    @Override
    public double getMinX() {
        return getX1();
    }

    @Override
    public double getMinY() {
        return getY1();
    }

    @Override
    public double getMaxX() {
        return getX2();
    }

    @Override
    public double getMaxY() {
        return getY2();
    }
}
