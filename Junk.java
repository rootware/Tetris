package Tetris;

import java.awt.*;
/**Junk is what a Shape object becomes after hitting the bottom :) */

public class Junk extends Mass{
   
    public int row, col;
    public Color color;
    /**Constructor
     *@param r The row position in the Cell array in Panel for this junk.
     *@param c The column position in the Cell array in Panel for this junk.
     *@param color The color of this junk: initially the color of the dead Shape object that turned into this junk.*/

    public Junk(int r, int c, Color color){
	row = r; 
	col = c;
	this.color = color;
    }
}