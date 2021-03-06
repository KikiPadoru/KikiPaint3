/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiki.mvc.Controller;



import com.kiki.mvc.figur.IRectangularShape;
import com.kiki.mvc.model.Model;
import com.kiki.mvc.model.MyShape;
import com.kiki.mvc.model.activity.Activity;
import com.kiki.mvc.model.activity.Draw;
import java.awt.Color;
import java.awt.geom.RectangularShape;


public class State {
   //from controller 
   Model model;
   // menu created 
   MyShape shape;
   Color color;
   MyShape.FillBehavior fb;
   IRectangularShape rectangularShape;
   Activity activity;

    public void setActivity(Activity activity) {
       this.activity = activity;
       this.activity.setModel(model);
    }

    public Activity getActivity() {
        return activity;
    }

    public State(Model model) {
        this.model = model;
        activity = new Draw(model);
    }

    public void setShape(MyShape shape) {
        this.shape = shape;
    }

    public void setColor(Color color) {
        this.color = color;
        shape.setColor(color);
        model.setSampleShape(shape);
    }

    public void setFb(MyShape.FillBehavior fb) {
        this.fb = fb;
        shape.setFb(fb);
        model.setSampleShape(shape);
    }

    public void setRectangularShape(IRectangularShape rectangularShape) {
        this.rectangularShape = rectangularShape;
        shape.setShape(rectangularShape);
        model.setSampleShape(shape);
    }

    public MyShape getShape() {
        return shape;
    }

    public Model getModel() {
        return model;
    }
    
    
}
