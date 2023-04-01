package Tetris;

import javax.swing.*;
import java.awt.*;
/**
Cells are basically the units used in the Panel and the ShapePanel as units. The shapes are drawn by filling out these units.
*
*@author Shah Saad Alam and Phyo Aung Kyaw
*/

public class Cell extends JPanel{
    Mass mass;
    JPanel parent ;

    public Cell (Mass mass,JPanel parent ){
	this.mass = mass;
	this.parent = parent ;
	setMinimumSize(new Dimension(30, 30));
	setMaximumSize(new Dimension(30, 30));
    }    

    public void paintComponent(Graphics g){
	super.paintComponent(g);
	g.setColor(this.getBackground());
	g.fill3DRect(0,0,30,30, true);
    }
}
