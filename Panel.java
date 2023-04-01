package Tetris;

import javax.swing.*;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
/**
 *The Panel class is the main JPanel subclass where the actual animation and the the game is played. It also provides the animation by implementing Runnable. 
 *@author Shah Saad Alam and Phyo Aung Kyaw
 */

public class Panel extends JPanel implements Runnable{
    
    public static Cell [][] cells; 
    /**The Cont object that contains this Panel*/
    public Cont  parent ;
    /**See ShapeMaker doc*/
    ShapeMaker mkr;
    /**The Shape object to be animated*/
    Shape animate ;
    Junk junk;
    boolean running=true;
    /**To count scores.*/
    int count=0;
    int waitTime = 0;

    /**Constructor for Panel.
     *@param parent Pointer to the Cont parent
     */

    public Panel (Cont parent){
	setMinimumSize(new Dimension(300, 600));
	setMaximumSize(new Dimension(300, 600));

	setLayout(new GridLayout(20,10));
	cells =new Cell [20][10];
	for(int i=0; i<20; i++)
	    for(int j=0;j<10;j++){
		cells[i][j] = new Cell(null,this);
		cells[i][j].setBackground(Color.LIGHT_GRAY);
		add(cells[i][j]);		
	    }

       	this.parent = parent;
	addKeyListener(new MyKey(this));
	setFocusable(true);

	try{
	    String s = JOptionPane.showInputDialog("Please Enter a Level, 1-10: ");
	    int i = Integer.parseInt(s);
	    if(i>10) throw new Exception();
	    waitTime = 100 * (11 - i);	    
	}catch(Exception e){
	    waitTime = 1000;
	}

	animate = (new ShapeMaker()).shape;
	repaint();	

	Thread thread=new Thread(this);
	thread.start();
    }

    /**This method adds the instance variable animate to the Cell array so as to be later portrayed graphically.*/
    public synchronized void addShape(){
	for(int i=0; i<4; i++){
	    int r = animate.cells[i][0];
	    int c = animate.cells[i][1];
	    if(r>=0){
		cells[r][c].mass = animate;
		cells[r][c].setBackground(animate.color);
	    }
	}
    }

    /**Initializes the empty cells tnull.*/
    public synchronized void setNull(){
	for(int i=0; i<4; i++){
	    int r = animate.cells[i][0];
	    int c = animate.cells[i][1];
	    if(r>=0){
		cells[r][c].mass = null;
		cells[r][c].setBackground(Color.LIGHT_GRAY);
	    }
	}
    }

    /**converts the Shape object to Junk objects when animate reaches the end.*/
    public synchronized void addJunk(){
	for(int i=3; i>=0; i--){
	    int r = animate.cells[i][0];
	    int c = animate.cells[i][1];
	    if(r>=0)
		cells[r][c].mass = (junk = new Junk(r, c, animate.color));
	}
	animate = null;
    }

    /**Eliminates rows that are completed*/
    public synchronized void eliminate(){
	int score =0;
	boolean canEliminate = true;
	for(int i=19; i>0; i--){
	    for(int j=0; j<10; j++)
		if(!(cells[i][j].mass instanceof Junk)) canEliminate = false;
		
	    if(canEliminate){
		score++;
		for(int l=0; l<i-1; l++)
		    for(int k=0; k<10; k++){
			cells[i-l][k].mass = cells[i-l-1][k].mass;
			if(cells[i-l][k].mass==null)
			    cells[i-l][k].setBackground(Color.LIGHT_GRAY);
			else{
			    Junk junk = (Junk) cells[i-l][k].mass;
			    junk.row++;
			    cells[i-l][k].setBackground(junk.color);
			}
		    }  
		i++;    
	    }
	    canEliminate = true;
	}
       count+=score;
       parent.epanel.scpanel.repaint();
    }
    /**This method checks to see is game is over.
@param junk The most recent junk object created by conversion from the last Shape object.
    *@return true is game is over
    */

    public synchronized boolean gameOver(Junk junk){
	if(junk.row<=0){
	    running = false;
	    setBackground(Color.WHITE);
	    JOptionPane.showMessageDialog(null, "Game Over! Your Score is: " + count, 
				"Game Over!", JOptionPane.INFORMATION_MESSAGE, null);   
	    return true;
	}
	return false;
    }

    /**The run method required by Runnable. This provides the animation code.*/
    public synchronized void run(){
	while(running){
	    try{
		if(animate.check(1, 0, 1)){
		    wait(waitTime);
		    setNull();
		    animate.moveDown();
		    addShape();
		    repaint();		    
		}else{
		    addJunk();
		    eliminate();
		    if(!gameOver(junk)){
			animate = parent.epanel.spanel.getShape();
			addShape();		    
			repaint();
		    }
		}
	    }
	    catch(InterruptedException e){}	
	}
    }

    /**Changes the running instance variable*/
    public synchronized void setRun(boolean b){
	running = b;
    }

    /**Inner class MyKey to handle Key Events*/
    public class MyKey extends KeyAdapter{
	Panel parent;
	/**Constructor
	 *@param parent A pointer to the JPanel that uses MyKey.
	 */
	public MyKey(Panel parent){
	    this.parent=parent;
	}
	/** @param e The object for Key Events*/

	public synchronized void keyPressed(KeyEvent e){
	    switch(e.getKeyCode()){
	    case KeyEvent.VK_D: setNull(); animate.moveRight(); addShape(); repaint();
		break;
	    case KeyEvent.VK_A: setNull(); animate.moveLeft(); addShape(); repaint();
		break;
	    case KeyEvent.VK_W: setNull(); animate.rotate(); addShape(); repaint();
		break;
	    case KeyEvent.VK_S:
		if(animate.check(1, 0, 1)){
		    setNull();
		    animate.moveDown();
		    addShape();
		    repaint();		    
		}
		else{
		    addJunk();
		    eliminate();
		    repaint();
		    if(!gameOver(junk)){
			animate = parent.parent.epanel.spanel.getShape();	
			addShape();		  
			repaint();
		    }
		}
		break;
	    }
	}	    
    }
}