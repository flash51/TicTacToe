package tictactoe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * JFrame to hold TicTac Toe Board
 * @author ankur
 * */
public class TicTacToeFrame extends JFrame
{
    //Indicate whose turn it is
        private char whoseTurn = 'X';
        private boolean gameOver = false;
        
   //Create cell Grid
        private Cell[][] cells = new Cell[3][3];
        
   //Create a status label     
        JLabel jlblStatus = new JLabel("X's turn to play");
        
   //No arguement Constructor Or Default Constructor      
        public TicTacToeFrame()
        {
            //Panel to hold cells
            JPanel panel = new JPanel(new GridLayout(3, 3, 0, 0));
            for(int i = 0; i < 3; i++)
                for(int j =0; j < 3; j++)
                    panel.add(cells[i][j] = new Cell());
            
            panel.setBorder(new LineBorder(Color.RED,1));
            jlblStatus.setBorder(new LineBorder(Color.YELLOW));
            
            add(panel,BorderLayout.CENTER);
            add(jlblStatus, BorderLayout.SOUTH);
            
        }
        
         /**
             * Determine if game board is full
             * @return if 
             */
            public boolean isFull()
            {
                for(int i = 0; i < 3; i++)
                for(int j =0; j < 3; j++)
                    if(cells[i][j].getToken() == ' ')
                        return false;
                
                return true;
            }
            
            /**
             * Determine if the given token has won
             * @param token Token to test for winning
             * @return True, if token has won, Otherwise false
             */
            public boolean isWon(char token)
            {
                //check rows
                for(int i = 0; i < 3;i++)
                    if((cells[i][0].getToken() == token)
                        && (cells[i][1].getToken() == token)
                        && (cells[i][2].getToken() == token))    
                    {
                        return true;
                    }
                
                //check columns
                for(int i = 0; i < 3;i++)
                    if((cells[0][i].getToken() == token)
                        && (cells[1][i].getToken() == token)
                        && (cells[2][i].getToken() == token))    
                    {
                        return true;
                    }
                
           //check Diagonal-1
                if((cells[0][0].getToken() == token)
                    && (cells[1][1].getToken() == token)
                            && (cells[1][2].getToken() == token))
                {
                    return true;
                }
                 
           //check Diagonal-2
                if((cells[0][2].getToken() == token)
                    && (cells[1][1].getToken() == token)
                            && (cells[2][0].getToken() == token))
                {
                    return true;
                }
                
              return false;
            }
 
//end TicTacToe Frame class


/**
 * Cell class to make game board
 * @author ankur
 */
public class Cell extends JPanel
{
   //token of this cell
    private char token = ' ';
    
    public Cell()
    {
        setBorder(new LineBorder(Color.BLACK,1));
        addMouseListener(new MyMouseListener());
        
    }
    
    /**
     * Gets the token of the cells
     * @return token value of the cell
     */
    public char getToken()
    {
        return token;
    }
    
    /**
     * sets the token of the cell
     * @param c Character to use as token value
     */
    public void setToken(char c)
    {
        token = c;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        if(token == 'X')
        {
            g.drawLine(10, 10, getWidth() -10, getHeight() - 10);
            g.drawLine(getWidth()-10, 10, 10, getHeight()-10);
        }
        
        else if(token == 'O')
        {
            g.drawOval(10, 10, getWidth()-20, getHeight()-20);
        }
    }
    
  private class MyMouseListener extends MouseAdapter
{
     @Override
     public void mouseClicked(MouseEvent e)
     {
         if(gameOver)
             return;
         
         //If the cell is empty and the game is not over
         if(token ==' ' && whoseTurn != ' ')
         setToken(whoseTurn);
         
         // check game status
         if(isWon(whoseTurn))
         {
             jlblStatus.setText(whoseTurn +"Won! the game");
             whoseTurn = ' ';
             gameOver = true;
         }
         else if(isFull())
         {
             jlblStatus.setText("tie game! game over");
             gameOver = true;
         }
         else
         {
             whoseTurn = (whoseTurn == 'X')  ? 'O' : 'X';
             jlblStatus.setText(whoseTurn + "'s turn.");
         }
     }
     
 }//end class MyMouseListener 
    
}//end class Cell

}//end class TicTacToeFrame
