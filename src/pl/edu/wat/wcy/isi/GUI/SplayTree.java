package pl.edu.wat.wcy.isi.GUI;

import pl.edu.wat.wcy.isi.Model.SplayTreeNode;
import pl.edu.wat.wcy.isi.Operations.*;

import javax.swing.*;

public class SplayTree {
    private JPanel windowPanel;
    private JButton addButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JButton splayButton;
    private JTextField numberTextField;
    private JCheckBox entableAnimationCheckBox;
    private JButton prevButton;
    private JButton playButton;
    private JButton nextButton;
    private JButton addRandomButton;
    private JTextField randomNumberTextField;
    private JTextField maxRandomTextField;
    private JTextField manRandomTextField;
    private JButton deleteAllButton;
    private JPanel treePanel;

    private SplayTree() {
        addButton.addActionListener(e -> {
            try {
                new Insert(Integer.parseInt(numberTextField.getText()));
            }catch (NumberFormatException ex) {
                System.out.print("Nie wpisano liczby!");
            } finally {
                treePanel.repaint();
                numberTextField.setText("");
            }
        });
        deleteButton.addActionListener(e -> {
            try {
                new Delete(Integer.parseInt(numberTextField.getText()));
            }catch (NumberFormatException ex) {
                System.out.print("Nie wpisano liczby!");
            } finally {
                treePanel.repaint();
                numberTextField.setText("");
            }
        });
        searchButton.addActionListener(e -> {
            try {
                new Get(Integer.parseInt(numberTextField.getText()));
            }catch (NumberFormatException ex) {
                System.out.print("Nie wpisano liczby!");
            } finally {
                treePanel.repaint();
                numberTextField.setText("");
            }
        });
        splayButton.addActionListener(e -> {
            try {
                new Splay(Integer.parseInt(numberTextField.getText()));
            }catch (NumberFormatException ex) {
                System.out.print("Nie wpisano liczby!");
            } finally {
                treePanel.repaint();
                numberTextField.setText("");
            }
        });

        deleteAllButton.addActionListener(e -> SplayTreeNode.deleteAll());

        playButton.addActionListener(e -> SplayTreeNode.paintTree());
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SplayTree");
        frame.setContentPane(new SplayTree().windowPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    private void createUIComponents() {
            treePanel = new TreeJPanel();
    }
}
