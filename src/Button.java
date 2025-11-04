import javax.swing.*;

public class Button extends JButton {
    private int number;

    public Button(int number) {
        this.number = number;
        if (number == 0) {
            setText("");
        } else
            setText(String.valueOf(number));
        setSize(100, 100);
    }

    public void setNumber(int number) {
        this.number = number;
        if (number == 0) {
            setText("");
        } else
            setText(String.valueOf(number));
    }

    public void newGame() {
        Rand
    }
}
