import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    Board board = new Board();
    JButton newGame = new JButton("Nytt spel");

    public GameWindow() {
        setTitle("15 puzzle");
        setSize(400, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(board, BorderLayout.CENTER);
        add(newGame, BorderLayout.SOUTH);
        newGame.addActionListener(e -> board.RandomiseBoard());
        setResizable(false);
        setVisible(true);
    }
}
