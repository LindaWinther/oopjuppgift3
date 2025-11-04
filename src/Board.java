import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JFrame {
    private int gridSize = 4;
    //private Button[][] buttons;
    public Button[][] buttons = new Button[gridSize][gridSize]; // Här
    private final int [][] tiles = new int [gridSize][gridSize]; // ta bort ovan?
    // Vart nollan är
    int zeroWidth = 3;
    int zeroHight = 3;

    public Board() {
        setTitle("15 puzzle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400,400);
        setLayout(new GridLayout(gridSize, gridSize));
     //   buttons = new Button[gridSize][gridSize];  // Jag lånar ut den här till högst upp
        int number = 1;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                tiles[i][j] = (number < gridSize * gridSize) ? number++ : 0;
                buttons[i][j] = new Button(tiles[i][j]);
                final int w = i, h = j;

              //  int w = i;
               // int h = j;

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
        updateBoard();
        setVisible(true); // flyttad sist så allt kommer med
    }

    public void isSolved (){
    }



    public void moveButton (int width, int hight) {

        boolean adjacent =
                (Math.abs (width - zeroWidth) == 1 && (hight == zeroHight)) ||
                (Math.abs(hight - zeroHight) == 1 && (width == zeroWidth));

        if (!adjacent) return;

        int tempoary = tiles[width][hight];
        tiles[width][hight] = tiles [zeroWidth][zeroHight];
        tiles[zeroWidth][zeroHight] = tempoary;

        zeroWidth = width;
        zeroHight = hight;

        updateBoard();
        /*
        if (adjacent) {
            String saveNumber = buttons[with][hight].getText();
            buttons[with][hight].setText("");  // byt knapp istället för namn
            buttons[zeroWidth][zeroHight].setText(saveNumber);

            zeroWidth = with;
            zeroHight = hight;

            updateBoard();
        }*/
    }

   // int [][] tiles = new int [gridSize][gridSize];
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
