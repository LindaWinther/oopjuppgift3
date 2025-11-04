import javax.swing.*;

public class Button extends JButton {
    public Button(int number) {
        if (number == 0) {
            setText("");
        } else
            setText(String.valueOf(number));
        setSize(100, 100);
    }
}
