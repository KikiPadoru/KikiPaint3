package com.kiki.mvc.figur;

import java.awt.*;
import java.awt.geom.Point2D;

public interface IRectangularShape extends Shape {
    void setFrameFromDiagonal(double x1, double y1,
                              double x2, double y2);
    void setFrameFromDiagonal(Point2D d,Point2D p);

    boolean contains(Point2D p);
    Object clone();

    double getMinX();

    double getMinY();

    double getMaxX();

    double getMaxY();
}
