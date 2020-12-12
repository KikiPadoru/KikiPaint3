/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiki.mvc.model.activity;


import com.kiki.mvc.model.Model;

import java.awt.geom.Point2D;

/**
 *
 * @author Wera
 */
public interface Activity {
    void getPointOne(Point2D p1);
    void getPointTwo(Point2D p1);
    void setModel(Model m);
    void execute();
    void unexecute();
    Activity clone();
}
