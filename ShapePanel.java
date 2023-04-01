package Tetris;

import javax.swing.*;
import java.awt.*;
/** ShapePanel is the class for the object that shows the next coming shape. It also passes the same shape to the Panel later.
 *@author Shah Saad Alam and Phyo Aung Kyaw
 */
public class ShapePanel extends JPanel{
    
    public EmptyPanel parent ;
    Cell [][] cells ;
    Shape shape;
    /**Constructor
     *@param parent A pointer to the EmptyPanel parent component.
     */

    public ShapePanel(EmptyPanel parent){
	setMinimumSize (new Dimension(180, 180));
	setMaximumSize (new Dimension(180, 180));
       
	cells = new Cell[6][6];
	shape = (new ShapeMaker()).shape;

	setLayout(new GridLayout(6,6));
	
	for(int i=0;i<6; i++)
	    for(int j=0;j<6;j++){
		cells[i][j]=new Cell(null, this);
		cells[i][j].setBackground(new Color(100, 125, 176, 190));
		add(cells[i][j]);
	    }
	this.parent = parent;
	addShape();
	repaint();
    }
    /**Used by panel to obtain a the 'next' Shape.
     *@return Shape object
     */

    public Shape getShape(){
	Shape s = shape;
	setNull();
	shape = (new ShapeMaker()).shape;	
	addShape();
	repaint();
	return s;
    }
    /** This method adds the current shape to the ShapePanel
     */
    public synchronized void addShape(){
	for(int i=0; i<4; i++){
	    int r = shape.cells[i][0]+2;
	    int c = shape.cells[i][1]-2;
	    cells[r][c].mass = shape;
	    cells[r][c].setBackground(shape.color);
	}
    }
    /**This method resets the Cells in the ShapePanel */
    public synchronized void setNull(){
	for(int i=0; i<4; i++){
	    int r = shape.cells[i][0]+2;
	    int c = shape.cells[i][1]-2;
	    cells[r][c].mass = null;
	    cells[r][c].setBackground(new Color(100, 125, 176, 190));
	}
    }
}