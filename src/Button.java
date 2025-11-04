import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public void newGame() { // Det här känns inte rätt men jag återkommer imorgon,
        // jag komplicerade jättemycket och kom fram till att vi redan hade dom två metoderna som fanns.
      /*  newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RandomiseBoard();
                updateBoard();
            }

            private void updateBoard() {
            }

            private void RandomiseBoard() {
            }
        });

       */
    }
}
