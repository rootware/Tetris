package Tetris;

import javax.swing.*;
import java.awt.*;
/**ScorePanel is contained in an EmptyPanel and displays the score*/

public class ScorePanel extends JPanel{
    /**The EmptyPanel container parent*/

   public EmptyPanel parent ;
    /**Constructor
     *@param parent A pointer to the EmptyPanel
     */

    public ScorePanel(EmptyPanel parent){
	this.parent = parent;

	setMinimumSize(new Dimension(180, 420));
	setMaximumSize(new Dimension(180, 420));
	setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g){
	super.paintComponent(g);
	g.setFont(new Font("Ariel", Font.PLAIN, 25));
	g.setColor(Color.BLACK);
	g.drawString("Score: " + parent.parent.panel.count, 15, 210);
    }
}