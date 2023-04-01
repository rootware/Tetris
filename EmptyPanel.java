package Tetris;

import javax.swing.*;
import java.awt.*;
/**EmptyPanel is contained in Cont and contains the ScorePanel and the ShapePanel objects.*/

public class EmptyPanel extends JPanel{
    /**The Cont object*/

    public Cont parent;
    public ShapePanel spanel;
    public ScorePanel scpanel;
    /**Constructor
     *@param parent A pointer to the Cont parent*/
    public EmptyPanel(Cont parent){
	this.parent = parent;

	setLayout(new BoxLayout( this, BoxLayout.Y_AXIS));
	setMinimumSize(new Dimension(180, 600));
	setMaximumSize( new Dimension(180, 600));
	setBackground(Color.white);
	spanel = new ShapePanel(this);
	scpanel = new ScorePanel(this);
	add(spanel);
	add(scpanel);
	validate();
    }
}
