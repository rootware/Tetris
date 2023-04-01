package Tetris;

import javax.swing.*;
import java.awt.*;
/**Cont is contained in Main (the JFrame) . It itself contains all other components.
 *
 *@author Shah Saad Alam and Phyo Aung Kyaw
 */

public class Cont extends JPanel{
    /**The Main object that contains this Cont object*/
    JFrame parent;

    public Panel panel;
    public EmptyPanel epanel;
    /**Constructor for Cont. 
     *@param parent A pointer to the Main parent container.
     */

    public Cont (JFrame parent){
	this.parent = parent;
	setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	setMinimumSize(new Dimension(480, 600));
	setMaximumSize(new Dimension(480, 600));
	panel = new Panel(this);
	epanel = new EmptyPanel (this);
	add(panel);
	add(epanel);
	validate();
    }
}