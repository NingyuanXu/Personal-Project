package main.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI4 extends JFrame {
    private JPanel panel1;
    private JButton returnButton;

    public GUI4() {
        JFrame frame = new JFrame("GUI4");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);

                new GUI();
            }
        });
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        final JLabel label1 = new JLabel();
        label1.setHorizontalAlignment(0);
        label1.setText("Show all the assignments in the Todo List");
        panel1.add(label1, BorderLayout.NORTH);
        returnButton = new JButton();
        returnButton.setText("Return ");
        panel1.add(returnButton, BorderLayout.SOUTH);
        final JLabel label2 = new JLabel();
        label2.setText("");
        panel1.add(label2, BorderLayout.CENTER);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}
