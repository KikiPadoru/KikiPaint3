package com.kiki.menu;

import com.kiki.mvc.Controller.State;
import com.kiki.mvc.view.MyPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class SaveJPG implements Command{
    MyPanel state;
    public SaveJPG(MyPanel s) {
        state = s;
    }
    @Override
    public void execute() {
        BufferedImage image2 = new BufferedImage(state.getWidth(), state.getHeight(),     BufferedImage.TYPE_INT_RGB);
        JFileChooser jFile = new JFileChooser();
        jFile.showSaveDialog(null);
        Path pth = jFile.getSelectedFile().toPath();
        JOptionPane.showMessageDialog(null, pth.toString());
        Graphics2D graphics2D = image2.createGraphics();
        state.paint(graphics2D);
        graphics2D.dispose();
        try {
            ImageIO.write(image2, "jpg", new File(pth.toString()+".jpg"));
        } catch (IOException ox) {
            // TODO: handle exception
            ox.printStackTrace();

        }
    }
}
