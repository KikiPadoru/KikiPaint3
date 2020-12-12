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

import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;


public class MyFrame extends JFrame {

    MyPanel panel;
    State state;
    UndoMachine undoMachine;
    Toolkit toolkit= Toolkit.getDefaultToolkit();
    Dimension dimension= toolkit.getScreenSize();

    public MyFrame(State state, UndoMachine machine) {
        this.state = state;
        this.undoMachine = machine;
       
        JMenuBar bar;
        bar = new JMenuBar();
        this.setJMenuBar(bar);

        Action f1 = new SwitchState("открыть файл",new ImageIcon("open.png"), new OpenFile(state));
        Action f2=new SwitchState("создать файл",new ImageIcon("open.png"), new SaveFile(state));
        JMenuItem save =new JMenuItem("Сохранить как",new ImageIcon("save1.png"));
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                savefile();
            }
        });
        Action fi1 = new SwitchState("прямоугольник",new ImageIcon("rectangle.png"),
                new SwitchShape(state, new MyRectangle()));
        Action fi2 =new SwitchState("овал", new ImageIcon("ellipse.png"),
                new SwitchShape(state, new MyEllipse()));

        Action fi3 =new SwitchState("линия", new ImageIcon("Line.gif"),
                new SwitchShape(state, new MyLine()));

        Action za1 =new SwitchState("незалитый", new ImageIcon("nofill.gif"),
                new SwitchFill(state, MyShape.FillBehavior.NO_FILL));
        Action za2 =new SwitchState("залитый", new ImageIcon("fill.gif"),
                new SwitchFill(state, MyShape.FillBehavior.FILL));
        Action de1 =new SwitchState("рисовать", new ImageIcon("draw.gif"),
                new SwitchActivity(state, new Draw()));
        Action de2 =new SwitchState("двигать", new ImageIcon("move.gif"),
                new SwitchActivity(state, new Move()));
        Action u=new SwitchUndo("undo",new ImageIcon("undo.gif"),undoMachine);
        Action r=new SwitchRedo("redo",new ImageIcon("redo.gif"),undoMachine);
        Action col=new SwitchState("выбор цвета", new ImageIcon("colors.gif"), new SwitchColor(state));
        undoMachine.addObserver((SwitchUndo)u);
        undoMachine.addObserver((SwitchRedo)r);
        undoMachine.notifyMenu();
        

        JMenu file =new JMenu("Файл");
        file.add(f1);
        file.add(f2);
        file.add(save);
        JMenu figur = new JMenu("Фигура");
        figur.add(fi1);
        figur.add(fi2);
        figur.add(fi3);
        JMenu zal = new JMenu("Заливка");
        zal.add(za1);
        zal.add(za2);
        JMenu del =new JMenu("Действие");
        del.add(de1);
        del.add(de2);
        JMenu ur = new JMenu("Undo/redo");
        ur.add(u);
        ur.add(r);
        JMenu color =new JMenu("Цвет");
        color.add(col);
        ////////////
        bar.add(file);
        bar.add(figur);
        bar.add(zal);
        bar.add(del);
        bar.add(ur);
        bar.add(color);
        ////////////
        JToolBar toolBar = new JToolBar();
            toolBar.add(f1);
        toolBar.add(f2);
        toolBar.add(save);
            toolBar.add(fi1);
        toolBar.add(fi2);
        toolBar.add(fi3);
            toolBar.add(za1);
        toolBar.add(za2);
            toolBar.add(de1);
        toolBar.add(de2);
            toolBar.add(u);
        toolBar.add(r);
            toolBar.add(col);


        add(toolBar, BorderLayout.SOUTH);


        

//        
        /////////////////////////////////////////////////////////////////
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(dimension.width/2-500,dimension.height/2-300,1000, 600);
        setTitle("KikiPaint");
        ImageIcon icon = new ImageIcon("fon.png");
        setIconImage(icon.getImage());
        setVisible(true);
    }
    public void savefile()
    {
        BufferedImage image2 = new BufferedImage(panel.getWidth(), panel.getHeight(),     BufferedImage.TYPE_INT_RGB);
        JFileChooser jFile = new JFileChooser();
        jFile.showSaveDialog(null);
        Path pth = jFile.getSelectedFile().toPath();
        JOptionPane.showMessageDialog(null, pth.toString());
        Graphics2D graphics2D = image2.createGraphics();
        panel.paint(graphics2D);
        graphics2D.dispose();
        try {
            ImageIO.write(image2, "jpeg", new File(pth.toString()+".jpeg"));
        } catch (IOException ox) {
            // TODO: handle exception
            ox.printStackTrace();

        }
    }
    public void setPanel(MyPanel panel) {
        this.panel = panel;
        add(panel);
    }

}
