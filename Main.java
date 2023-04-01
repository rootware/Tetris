package Tetris;

import javax.swing.*;
import java.awt.*;

/**
 *This class is provides the JFrame container and the main method for running Tetris.
 *
 *@author Shah Saad Alam and Phyo Aung Kyaw
 */

public class Main extends JFrame {
    /** The Cont instance that is held inside the JFrame and in turn contains all other components.
     */
    public Cont cont;;

    /**Constructor for the Main class. Calling this constructor sets the program going.
     */

    public Main(){

	setMinimumSize(new Dimension(480, 600));
	setMaximumSize(new Dimension(480, 600));
	setTitle("Tetris");
	setResizable(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	cont= new Cont (this);
	add(cont);
	pack();
	setVisible(true);
    }

    /** The main method that runs the Tetris game.
     *@param args Command-line arguments. Not used in this code.
     */
    public static void main (String [] args){
	Main main = new Main();
    }
}