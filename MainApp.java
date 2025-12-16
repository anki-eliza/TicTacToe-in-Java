import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainApp {

    JFrame startFrame = new JFrame("Game of Tic Tac Toe");

    MainApp() {
        startFrame.setSize(600, 650);
        startFrame.setLocationRelativeTo(null);
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/bg.jpg"));
        Image img = icon.getImage().getScaledInstance(
        600, 650, Image.SCALE_SMOOTH);

        JLabel background = new JLabel(new ImageIcon(img));

        background.setLayout(null);
        startFrame.setContentPane(background);


        startFrame.setResizable(false);

        JLabel title = new JLabel("TIC TAC TOE", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 50));
        title.setOpaque(false);
        title.setForeground(Color.white);

        JButton startButton = new JButton("Play with a friend");
        startButton.setFont(new Font("Arial", Font.BOLD, 25));
        startButton.setFocusable(false);

        JButton start2Button = new JButton("Play with the computer");
        start2Button.setFont(new Font("Arial", Font.BOLD, 25));
        start2Button.setFocusable(false);



        title.setBounds(120, 80, 360, 60); 
        background.add(title);

        startButton.setBounds(170, 400, 260, 60);
        background.add(startButton);

        start2Button.setBounds(100, 500, 400, 60);
        background.add(start2Button);


        startButton.addActionListener(e -> {
            startFrame.dispose();      // close start screen
            new TicTacToe();           // open your existing game
        });

        start2Button.addActionListener(e -> {
            startFrame.dispose();      // close start screen
            new ComputerGame();           // open your existing game
        });

        startFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainApp();
    }
}

