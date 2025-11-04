import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JFrame {
    private int gridSize = 4;
    //private Button[][] buttons;
    public Button[][] buttons = new Button[gridSize][gridSize]; // Här

    public Board() {
        setVisible(true);
        setTitle("15 puzzle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400,400);
        setLayout(new GridLayout(gridSize, gridSize));
     //   buttons = new Button[gridSize][gridSize];  // Jag lånar ut den här till högst upp
        int number = 1;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (number < gridSize * gridSize) {
                    buttons[i][j] = new Button(number++);
                } else {
                    buttons[i][j] = new Button(0);
                }
                int w = i;
                int h = j;

                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        moveButton(w,h);
                    }
                });
                add(buttons[i][j]);
            }
        }
    }

    public void isSolved (){
    }


    // Vart nollan är
    int zeroWith = 3;
    int zeroHight = 3;
    public void moveButton (int with, int hight) {

        boolean adjacent =
                (with - zeroWith == 1) && (hight == zeroHight) ||
                (hight - zeroHight == 1) && (with == zeroWith);

        if (adjacent) {
            String saveNumber = buttons[with][hight].getText();
            buttons[with][hight].setText("");
            buttons[zeroWith][zeroHight].setText(saveNumber);

            zeroWith = with;
            zeroHight = hight;

            updateBoard();
        }
    }

    int [][] tiles = new int [gridSize][gridSize];
    public void updateBoard() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {

                int value = tiles[i][j];
                buttons[i][j].setText(value == 0 ? "" : String.valueOf(value));
            }
        }
        repaint();
    }


    public void RandomiseBoard(){
    }
}
