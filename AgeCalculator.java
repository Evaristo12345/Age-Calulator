import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator extends JFrame {

    private JLabel dateofbirthLabel;
    private JTextField dateofbirthField;
    private JButton calculateButton;
    private JLabel resultLabel;
    private JPanel panel;

    public AgeCalculator() {
        super("How old are you? Age Calculator");

        dateofbirthLabel = new JLabel("Enter Your Birth Date (YYYY-MM-DD):");
        dateofbirthField = new JTextField(12);
        calculateButton = new JButton("Find your age");
        resultLabel = new JLabel(""); 
        panel = new JPanel();

        panel.add(dateofbirthLabel);
        panel.add(dateofbirthField);
        panel.add(calculateButton);
        panel.add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dateofbirthString = dateofbirthField.getText();
                try {
                    LocalDate dateofbirth = LocalDate.parse(dateofbirthString);
                    LocalDate today = LocalDate.now();
                    Period period = Period.between(dateofbirth, today);
                    resultLabel.setText("Your age is: " + period.getYears() + " years old");
                } catch (Exception ex) {
                    resultLabel.setText("Invalid date format");
                }
            }
        });

        add(panel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new AgeCalculator();
    }
}