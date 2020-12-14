/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiki.menu;

import com.kiki.mvc.Controller.State;
import com.kiki.mvc.model.activity.Activity;




public class SwitchActivity implements Command{
   State state;
   Activity activity;

    public SwitchActivity(State state, Activity activity) {
        this.state = state;
        this.activity = activity;
    }

    @Override
    public void execute() {
        state.setActivity(activity);
    }
}
