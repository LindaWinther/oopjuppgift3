import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    Board board = new Board();
    JButton newGame = new JButton("New Game");

    public GameWindow() {
        setTitle("15 puzzle");
        setSize(400, 420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(board, BorderLayout.CENTER);
        add(newGame, BorderLayout.SOUTH);
        setResizable(false);
        setVisible(true);
    }
}
