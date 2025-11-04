import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {
    private int gridSize = 4;
    private Button[][] buttons;

    public Board() {
        setVisible(true);
        setTitle("15 puzzle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400,400);
        setLayout(new GridLayout(gridSize, gridSize));
        buttons = new Button[gridSize][gridSize];
        int number = 1;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (number < gridSize * gridSize) {
                    buttons[i][j] = new Button(number++);
                } else {
                    buttons[i][j] = new Button(0);
                }
                add(buttons[i][j]);
            }
        }
    }

    public void isSolved (){
    }

    public void moveButton () {

    }

    public void RandomiseBoard(){
    }
}
