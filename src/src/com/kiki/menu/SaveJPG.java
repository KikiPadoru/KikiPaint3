package com.kiki.menu;

import com.kiki.mvc.Controller.State;
import com.kiki.mvc.model.Model;
import com.kiki.mvc.view.MyPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import javax.imageio.ImageIO;

public class SaveJPG implements Command{

    MyPanel panel;
    public SaveJPG() {
    }
    public void addPanel(MyPanel s){panel = s;}
    @Override
    public void execute() {
        System.out.println(panel.getWidth()+"   "+panel.getHeight());
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
            ox.printStackTrace();
        }
    }

}
