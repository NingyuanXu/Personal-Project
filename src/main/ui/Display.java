package main.ui;

import main.model.Assignment;
import main.model.TodoList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Display extends JFrame {
    private JPanel panel1;
    private JButton returnButton;
    private JTextArea textArea1;
    private JList list1;

    public Display(TodoList todoList) {

        JFrame frame = new JFrame("Display");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        DefaultListModel model = new DefaultListModel();
        list1.setModel(model);

        DefaultListModel<String> listModel = (DefaultListModel) list1.getModel();
        for (Assignment a : todoList.getTodoList()) {
            listModel.addElement(a.toString());
        }


        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);

            }
        });
        list1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
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
        textArea1 = new JTextArea();
        panel1.add(textArea1, BorderLayout.EAST);
        final JLabel label2 = new JLabel();
        label2.setText("");
        panel1.add(label2, BorderLayout.WEST);
        list1 = new JList();
        panel1.add(list1, BorderLayout.CENTER);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }
}