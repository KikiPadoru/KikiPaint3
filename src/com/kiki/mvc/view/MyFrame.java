/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kiki.mvc.view;

import com.kiki.menu.*;
import com.kiki.mvc.Controller.State;
import com.kiki.mvc.figur.*;
import com.kiki.mvc.model.MyShape;
import com.kiki.mvc.model.UndoMachine;
import com.kiki.mvc.model.activity.Draw;
import com.kiki.mvc.model.activity.Move;
import java.awt.BorderLayout;


import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;


public class MyFrame extends JFrame {

    MyPanel panel;
    State state;
    UndoMachine undoMachine;

    public MyFrame(State state, UndoMachine machine) {
        this.state = state;
        this.undoMachine = machine;
       
        JMenuBar bar;
        bar = new JMenuBar();
        this.setJMenuBar(bar);
        ArrayList<Action> menuItems = new ArrayList<>();
        menuItems.add(new SwitchState("открыть файл",new ImageIcon("rectangle.gif"),
                new OpenFile(state)));
        menuItems.add(new SwitchState("создать файл",new ImageIcon("rectangle.gif"),
                new SaveFile(state)));
        menuItems.add(new SwitchState("создать как",new ImageIcon("rectangle.gif"),
                new SaveJPG(panel)));
        menuItems.add(new SwitchState("прямоугольник",new ImageIcon("rectangle.gif"),
                new SwitchShape(state, new MyRectangle())));
        menuItems.add(new SwitchState("овал", new ImageIcon("ellipse.gif"),
                new SwitchShape(state, new MyEllipse())));

       menuItems.add(new SwitchState("линия", new ImageIcon("src/Line.gif"),
                new SwitchShape(state, new MyLine())));

        menuItems.add(new SwitchState("незалитый", new ImageIcon("nofill.gif"),
                new SwitchFill(state, MyShape.FillBehavior.NO_FILL)));
        menuItems.add(new SwitchState("залитый", new ImageIcon("fill.gif"),
                new SwitchFill(state, MyShape.FillBehavior.FILL)));
        menuItems.add(new SwitchState("рисовать", new ImageIcon("draw.gif"),
                new SwitchActivity(state, new Draw())));
        menuItems.add(new SwitchState("двигать", new ImageIcon("move.gif"),
                new SwitchActivity(state, new Move())));
        menuItems.add(new SwitchUndo("undo",new ImageIcon("undo.gif"),undoMachine));
        menuItems.add(new SwitchRedo("redo",new ImageIcon("redo.gif"),undoMachine));
        menuItems.add(new SwitchState("выбор цвета", new ImageIcon("colors.gif"),
                new SwitchColor(state)));
        undoMachine.addObserver((SwitchUndo)menuItems.get(menuItems.size()-3));
        undoMachine.addObserver((SwitchRedo)menuItems.get(menuItems.size()-2));
        undoMachine.notifyMenu();
        
        ArrayList<JMenu> menus = new ArrayList<>();
        menus.add(new JMenu("Файл"));
        menus.add(new JMenu("Фигура"));
        menus.add(new JMenu("Заливка"));
        menus.add(new JMenu("Действие"));
        menus.add(new JMenu("Undo/redo"));
        menus.add(new JMenu("Цвет"));
        int i = 0;
        int k = menuItems.size()-1;
        int fl = 0;
        for (JMenu m : menus) {
            bar.add(m);
            if(fl<=1){
                m.add(menuItems.get(i));
                m.add(menuItems.get(i + 1));
                m.add(menuItems.get(i + 2));
                i += 3;
                fl++;
                continue;
            }
            if (i < k) {
                m.add(menuItems.get(i));
                m.add(menuItems.get(i + 1));
                i += 2;
            } else {
                m.add(menuItems.get(i));
            }
            fl++;
        }
        JToolBar toolBar = new JToolBar();
        for (Action x : menuItems) {
            toolBar.add(x);
        }

        add(toolBar, BorderLayout.NORTH);


        

//        
        /////////////////////////////////////////////////////////////////
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 700);
        setVisible(true);
    }

    public void setPanel(MyPanel panel) {
        this.panel = panel;
        add(panel);
    }

}
