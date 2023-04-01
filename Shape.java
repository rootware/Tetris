package Tetris;

import java.awt.*;
/**The class that provide objects representing the various shapes. 
 *@author Shah Saad Alam and Phyo Aung Kyaw.
 */

public class Shape extends Mass{

    public int[][] cells = new int[4][2];
    public Color color;

    /**Checks whether Shape is an OShape object (square) so as to know if it can be rotated.
     *@return boolean value-true is OShape object, else false
     */

    boolean isOShape(){
	return true;
    }
    /**checks Cells .
     *@return boolean
     */
    /**Checks to see if the Cells to be operated on are valid.
     *@param  a 
     *@param b
     *@param f
     *@return boolean*/

    public boolean check(int a, int b, int f){
	for(int i=0; i<4; i++){
	    int x = cells[i][0], y = cells[i][1];
	    int r = 0, c = 0;

	    if(f==4) {
		r = y+a; c = -x+b;
	    }else{
		r = x+a; c = y+b;
	    }

	    if((f==1 && r>=20) || (f==2 && c>=10) || (f==3 && c<0) ||
	       (f==4 && (r<0 || r>=20 || c<0 || c>=10)) || 
	       Panel.cells[r][c].mass instanceof Junk) 
		return false;;
	}
	return true;
    }
   
    /**Moves the Shape object down */
    public synchronized void moveDown(){	
	if(check(1, 0, 1))
	    for(int i=0; i<4; i++)
		cells[i][0]++;
    }
    /**Moves the Shape object Right.*/
    public synchronized void moveRight(){
	if(check(0, 1, 2))	
	    for(int i=0; i<4; i++)
		cells[i][1]++;
    }
    /**Moves the Shape object left.*/

    public synchronized void moveLeft(){
	if(check(0, -1, 3))
	    for(int i=0; i<4; i++)
		cells[i][1]--;
    }
    /**Rotates the Shape object*/
    public synchronized void rotate(){
	if(!isOShape()){
	    int medx = cells[1][0], medy = cells[1][1];
	    if(check(medx - medy, medx + medy, 4))		
		for (int i=0; i<4; i++){
		    int x = cells[i][0], y = cells[i][1];
		    cells[i][0] = y - medy + medx;
		    cells[i][1] = medx - x + medy;
		}    
	}
    }

}