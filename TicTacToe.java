package tictactoe;

import javax.swing.JFrame;

/**
 * This is simple TicTacToe game 
 * @author ankur
 */
public class TicTacToe 
{

    public static void main(String[] args) 
    {
        JFrame tictactoe = new TicTacToeFrame();
        tictactoe.setTitle("Akki TicTacToe Game!");
        tictactoe.setSize(600,600);
        tictactoe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tictactoe.setLocationRelativeTo(null);
        tictactoe.setVisible(true);
    }
    
}
