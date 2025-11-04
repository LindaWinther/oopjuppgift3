import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Board extends JFrame {
    private final int gridSize = 4;
    public Button[][] buttons = new Button[gridSize][gridSize];
    private final int [][] tiles = new int [gridSize][gridSize];
    int zeroWidth;
    int zeroHight;//Oklart om deet behövdes 3or här. Funkar fint utan.

    public Board() {
        setTitle("15 puzzle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400,400);
        setLayout(new GridLayout(gridSize, gridSize));
        int number = 1;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                tiles[i][j] = (number < gridSize * gridSize) ? number++ : 0;
                buttons[i][j] = new Button(tiles[i][j]);
                final int w = i, h = j;

                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        moveButton(w,h);
                    }
                });
                add(buttons[i][j]);
            }
        }
        zeroWidth = gridSize -1;
        zeroHight = gridSize -1;
        RandomiseBoard(); // kommentera ut vid redovisning
        updateBoard();
        setVisible(true);
    }

    public boolean isSolved (){
        int count = 1;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (i == gridSize - 1 && j == gridSize - 1) {
                    return tiles[i][j] == 0;
                }
                if (tiles[i][j] != count++){
                    return false;
                }
            }
        }
        return true;
    }

    public void moveButton (int width, int hight) {

        boolean adjacent =
                (Math.abs (width - zeroWidth) == 1 && (hight == zeroHight)) ||
                (Math.abs(hight - zeroHight) == 1 && (width == zeroWidth));

        if (!adjacent) return;

        int temporary = tiles[width][hight];
        tiles[width][hight] = tiles [zeroWidth][zeroHight];
        tiles[zeroWidth][zeroHight] = temporary;

        zeroWidth = width;
        zeroHight = hight;

        updateBoard();
        if (isSolved ()) {
            JOptionPane.showMessageDialog(null, "Solved!");
        }
    }

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
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < gridSize * gridSize; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        int index = 0;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                int number = numbers.get(index++);
                tiles[i][j] = number;
                buttons[i][j].setNumber(number);
                if (number == 0) {
                    zeroWidth = i;
                    zeroHight = j;
                }
            }
        }
    }
}
