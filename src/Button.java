import javax.swing.*;

public class Button extends JButton {
    public Button(int number) {
        super(String.valueOf(number));
        setSize(100, 100);
    }
}
