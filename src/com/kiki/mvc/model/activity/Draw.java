/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiki.mvc.model.activity;


import com.kiki.mvc.model.Model;
import com.kiki.mvc.model.MyShape;
import java.awt.geom.Point2D;

/**
 *
 * @author Wera
 */
public class Draw implements Activity{
    Model model;
    Point2D[] p;
    MyShape myShape;
    
    public Draw(Model model) {
        this.model = model;
        p = new Point2D[2];
    }

    public Draw() {
       p = new Point2D[2]; 
    }
   
    @Override
    public void getPointOne(Point2D p1){
         p[0] = p1;
         myShape =model.inintCurrentShape();
    }
    
    public void getPointTwo(Point2D p1){
        p[1] = p1;
        model.changeShape(p);
    }
    
    @Override
    public void execute() {
        model.setActiveShape(myShape);
    }

    @Override
    public void unexecute() {
        model.ctrlZ_Shape();
    }

    @Override
    public Activity clone() {
       Draw d = new Draw(model);
        d.myShape = myShape;
        d.p = p;
        return d;
    }

    @Override
    public void setModel(Model m) {
        model = m;
    }
    
}
