//hi, in this project i did the gui using swing instead of plain command line
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GradeCalculator extends JFrame {
    private JTextField[] subjectFields;
    private JButton calculateButton;
    private JTextArea resultArea;

    public GradeCalculator() {
        setTitle("Grade Calculator");
        setLayout(null);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // i Set the background color to black
        getContentPane().setBackground(Color.WHITE);

        JLabel subjectLabel = new JLabel("Enter Marks (out of 100) for each subject:");
        subjectLabel.setForeground(Color.WHITE); // Set text color to white
        subjectLabel.setBounds(20, 20, 250, 20);
        add(subjectLabel);

        subjectFields = new JTextField[5];
        for (int i = 0; i < subjectFields.length; i++) {
            subjectFields[i] = new JTextField();
            subjectFields[i].setBounds(20, 50 + i * 30, 50, 20);
            add(subjectFields[i]);
        }

        calculateButton = new JButton("Calculate");
        // i Set the button background color to green
        calculateButton.setBackground(Color.BLUE);
        calculateButton.setForeground(Color.BLACK); // Set text color to black
        calculateButton.setBounds(20, 200, 100, 30);
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateResults();
            }
        });
        add(calculateButton);

        resultArea = new JTextArea();
        resultArea.setBounds(150, 50, 200, 180);
        resultArea.setEditable(false);
        resultArea.setBackground(Color.white);
        resultArea.setForeground(Color.black); // Set text color to white
        add(resultArea);

        // i Set the button and text field background color to black
        for (JTextField field : subjectFields) {
            field.setBackground(Color.white);
            field.setForeground(Color.black); // Set text color to white
        }

        setVisible(true);
    }

    private void calculateResults() {
        int totalMarks = 0;
        int totalSubjects = subjectFields.length;

        for (int i = 0; i < totalSubjects; i++) {
            try {
                int marks = Integer.parseInt(subjectFields[i].getText());
                totalMarks += marks;
            } catch (NumberFormatException ex) {
                resultArea.setText("Invalid input. Please enter numeric values.");
                return;
            }
        }

        double averagePercentage = (double) totalMarks / totalSubjects;
        String grade = calculateGrade(averagePercentage);

        resultArea.setText("Total Marks: " + totalMarks + "\nAverage Percentage: " + averagePercentage + "%\nGrade: " + grade);
    }

    private String calculateGrade(double averagePercentage) {
        // this is my chosen grading logic here,  bit steep but yeah
        // also decided against a switch statement because the implementation doesnt really nedd it
        if (averagePercentage >= 90) {
            return "A";
        } else if (averagePercentage >= 80) {
            return "B";
        } else if (averagePercentage >= 70) {
            return "C";
        } else if (averagePercentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        new GradeCalculator();
    }
}

