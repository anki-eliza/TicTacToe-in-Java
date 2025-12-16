import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class ComputerGame{

    
    //display
    int boardWidth= 600;
    int boardHeight= 650;
    JFrame frame=new JFrame("Game of Tic Tac Toe");

    //text
    JLabel textLabel=new JLabel();
    JPanel textPanel=new JPanel();

    //board

    JPanel boardPanel=new JPanel();

    //buttons
    JButton[][] board=new JButton[3][3];
    String playerX="X";
    String playerO="O";
    String currentPlayer=playerX;

    //game
    boolean gameOver=false;
    int turns=0;

    Random random=new Random();


    ComputerGame(){

        
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());    
        
        textLabel.setBackground(Color.darkGray);
        textLabel.setForeground(Color.white);
        textLabel.setFont(new Font("Arial", Font.BOLD, 50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Tic Tac Toe");
        textLabel.setOpaque(true);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel, BorderLayout.NORTH);

        boardPanel.setLayout(new GridLayout(3,3));
        boardPanel.setBackground(Color.darkGray);
        frame.add(boardPanel);


        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                JButton tile=new JButton();
                board[i][j]=tile;
                boardPanel.add(tile);

                tile.setBackground(Color.pink);
                tile.setForeground(Color.darkGray);
                tile.setFont(new Font("Arial", Font.BOLD, 120));
                tile.setFocusable(false);
                //tile.setText(currentPlayer);

                tile.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        if (gameOver){
                            return;
                        }
                        JButton tile=(JButton)e.getSource();
                        if (tile.getText()==""){
                            tile.setText(currentPlayer);
                            turns++;
                            checkWin();
                            if (!gameOver) {
                               computerMove(); 
                            }
                            if (!gameOver){
                               currentPlayer=(currentPlayer==playerX)?playerO:playerX;
                               textLabel.setText("Player "+currentPlayer+"'s turn");
                            }

                        }
                          
                    
                    }
              });
            }
        }
    }

    void checkWin(){
        //horizontal win
        for (int i=0;i<3;i++){
            if (board[i][0].getText()==""){
                continue;
            }
            if (board[i][0].getText()==board[i][1].getText() && board[i][1].getText()==board[i][2].getText()){
                
                for (int j=0;j<3;j++){
                    setWin(board[i][j]);

                }
                gameOver=true;
                return;     
            }
        }

        //vertical win
        for (int i=0;i<3;i++){
            if (board[0][i].getText()==""){
                continue;
            }
            if (board[0][i].getText()==board[1][i].getText() && board[1][i].getText()==board[2][i].getText()){
                
                for (int j=0;j<3;j++){
                    setWin(board[j][i]);

                }
                gameOver=true;
                return;     
            }
        }

        //diagonal win
        if (board[0][0].getText()!="" && board[0][0].getText()==board[1][1].getText() && board[1][1].getText()==board[2][2].getText()){
            for (int i=0;i<3;i++){
                setWin(board[i][i]);
            }
            gameOver=true;
            return;
        }

        //anti-diagonal win
        if (board[0][2].getText()!="" && board[0][2].getText()==board[1][1].getText() && board[1][1].getText()==board[2][0].getText()){
            for (int i=0;i<3;i++){
                setWin(board[i][2-i]);
            }
            gameOver=true;
            return;
        }

        if (turns==9){
            for (int i=0;i<3;i++){
                for (int j=0;j<3;j++){
                    setTie(board[i][j]);
                }
            }
            gameOver=true;
        }

    }

    void setWin(JButton tile){
        tile.setBackground(Color.green);
        tile.setForeground(Color.red);
        textLabel.setText("Player "+currentPlayer+" is the winner!");
    }

    void setTie(JButton tile){
        tile.setBackground(Color.yellow);
        tile.setForeground(Color.blue);
        textLabel.setText("It's a tie!");
    }

    void computerMove() {
        int i, j;

        do {
            i = random.nextInt(3);
            j = random.nextInt(3);
        } while (board[i][j].getText()!="");

        currentPlayer=playerO;
        board[i][j].setText(currentPlayer);
        turns++;
        checkWin();
    }

    
}

