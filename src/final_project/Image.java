/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import java.awt.Graphics;
import javax.swing.*;

/**
 *
 * @author Ahmed Abdelnaser
 */
public class Image extends JPanel {

    private ImageIcon img;

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        img = new ImageIcon(getClass().getResource("uni.jpg"));
        img.paintIcon(this, grphcs, 0, 0);
    }

    public Image() {
        this.setLayout(null);
        
    }

}
