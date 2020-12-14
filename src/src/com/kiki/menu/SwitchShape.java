/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiki.menu;


import com.kiki.mvc.Controller.State;
import com.kiki.mvc.figur.IRectangularShape;

import java.awt.geom.RectangularShape;


public class SwitchShape implements Command{
    State state;
    IRectangularShape rs;

    public SwitchShape(State state, IRectangularShape rs) {
        this.state = state;
        this.rs = rs;
    }
    
    @Override
    public void execute() {
        state.setRectangularShape(rs);
    }
    
}
