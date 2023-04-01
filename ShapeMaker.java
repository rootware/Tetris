package Tetris;

import java.awt.*;
/**
 *The ShapeMaker class makes a Shape object that is chosen randomly out of the 7 possible shapes. This Shape object can then be accessed by other JPanel objects that require a shape.
 *@author Shah Saad Alam and Phyo Aung Kyaw.
 */

public class ShapeMaker{
    /**The Shape object created*/
    public  Shape shape;
    /**Constructor*/
    public ShapeMaker(){
	int i = (int)(Math.random()*7) + 1;
    	switch(i){
	case 1: shape = new IShape(); break;
	case 2: shape = new JShape(); break;
	case 3: shape = new LShape(); break;
	case 4: shape = new OShape(); break;
	case 5: shape = new SShape(); break;
	case 6: shape = new TShape(); break;
	case 7: shape = new ZShape(); break;
	}
    }

    class IShape extends Shape{
	IShape(){
	    int count = 3;
	    for(int i=0; i<4; i++){
		super.cells[i][0] = 0;
		super.cells[i][1] = count++;
	    }
	    super.color = Color.RED;
	}

	boolean isOShape(){
	    return false;
	}
    }

    class JShape extends Shape{
	JShape(){
	    int count = 4;
	    for(int i=0; i<3; i++){
		super.cells[i][0] = 0;
		super.cells[i][1] = count++;
	    }
	    super.cells[3][0] = 1;
	    super.cells[3][1] = 6;
	    super.color = Color.MAGENTA;
	}

	boolean isOShape(){
	    return false;
	}
    }

    class LShape extends Shape{
	LShape(){
	    int count = 4;
	    for(int i=0; i<3; i++){
		super.cells[i][0] = 0;
		super.cells[i][1] = count++;
	    }
	    super.cells[3][0] = 1;
	    super.cells[3][1] = 4;
	    super.color = Color.YELLOW;
	}

	boolean isOShape(){
	    return false;
	}
    }

    class OShape extends Shape{
	OShape(){
	    super.cells[0][0] = 0;
	    super.cells[0][1] = 4;
	    super.cells[1][0] = 0;
	    super.cells[1][1] = 5;
	    super.cells[2][0] = 1;
	    super.cells[2][1] = 4;
	    super.cells[3][0] = 1;
	    super.cells[3][1] = 5;
	    super.color = Color.CYAN;
	}

	boolean isOShape(){
	    return true;
	}
    }

    class SShape extends Shape{
	SShape(){
	    super.cells[0][0] = 0;
	    super.cells[0][1] = 6;
	    super.cells[1][0] = 0;
	    super.cells[1][1] = 5;
	    super.cells[2][0] = 1;
	    super.cells[2][1] = 4;
	    super.cells[3][0] = 1;
	    super.cells[3][1] = 5;
	    super.color = Color.BLUE;
	}

	boolean isOShape(){
	    return false;
	}
/**@return Name of the type of this Shape.*/
	public String toString(){
	    return "SShape";
	}
    }

    class TShape extends Shape{
	TShape(){
	    int count = 4;
	    for(int i=0; i<4; i++){
		super.cells[i][0] = 0;
		super.cells[i][1] = count++;
	    }
	    super.cells[3][0] = 1;
	    super.cells[3][1] = 5;
	    super.color = Color.DARK_GRAY;
	}

	boolean isOShape(){
	    return false;
	}
    }

    class ZShape extends Shape{
	ZShape(){
	    super.cells[0][0] = 0;
	    super.cells[0][1] = 4;
	    super.cells[1][0] = 0;
	    super.cells[1][1] = 5;
	    super.cells[2][0] = 1;
	    super.cells[2][1] = 5;
	    super.cells[3][0] = 1;
	    super.cells[3][1] = 6;
	    super.color = Color.GREEN;
	}

	boolean isOShape(){
	    return false;
	}
    }
}