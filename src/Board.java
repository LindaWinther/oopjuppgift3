import javax.swing.*;
import java.awt.*;

public class Board extends JFrame {
    //Måste gå att göra snyggare
    Button button1 = new Button(1);
    Button button2 = new Button(2);
    Button button3 = new Button(3);
    Button button4 = new Button(4);
    Button button5 = new Button(5);
    Button button6 = new Button(6);
    Button button7 = new Button(7);
    Button button8 = new Button(8);
    Button button9 = new Button(9);
    Button button10 = new Button(10);
    Button button11 = new Button(11);
    Button button12 = new Button(12);
    Button button13 = new Button(13);
    Button button14 = new Button(14);
    Button button15 = new Button(15);
    Button button16 = new Button(16);

    public Board() {
        setVisible(true);
        setTitle("15 puzzle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400,400);
        add(button1);
        add(button2);
        add(button3);
        add(button4);
        add(button5);
        add(button6);
        add(button7);
        add(button8);
        add(button9);
        add(button10);
        add(button11);
        add(button12);
        add(button13);
        add(button14);
        add(button15);
        add(button16);
        setLayout(new GridLayout(4, 4));
    }

    public void isSolved (){
    }

    public void RandomiseBoard(){
    }

    public  void createButtons(){
    }

}
