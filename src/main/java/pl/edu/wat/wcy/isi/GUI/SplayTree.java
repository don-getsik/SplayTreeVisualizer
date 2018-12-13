package pl.edu.wat.wcy.isi.GUI;

import pl.edu.wat.wcy.isi.Model.SplayTreeContainer;
import pl.edu.wat.wcy.isi.Model.SplayTreeNode;
import pl.edu.wat.wcy.isi.Operations.*;
import javax.swing.*;
import java.util.Random;

public class SplayTree {
    private JPanel windowPanel;
    private JButton addButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JTextField numberTextField;
    private JCheckBox animationCheckBox;
    private JButton prevButton;
    private JButton playButton;
    private JButton nextButton;
    private JButton addRandomButton;
    private JButton deleteAllButton;
    private JPanel treePanel;
    private JTextField minTextField;
    private JTextField maxTextField;
    private JTextField sizeTextField;
    private JTextArea InstructionArea;
    private JPanel settingsPanel;
    private JPanel buttonsPanel;
    private JSlider timeSlider;
    private JCheckBox autoplayCheckBox;
    private JPanel minPanel;
    private JPanel maxPanel;
    private JPanel sizePanel;
    private JButton splayButton;
    private JButton stateButton;
    private Timer timer;

    private SplayTree() {
        addButton.addActionListener(e -> {
            setLastTree();
            try {
                if (Integer.parseInt(numberTextField.getText()) > 100) {
                    JOptionPane.showMessageDialog(null, "Wprowadzono za dużą liczbę");
                } else if (Integer.parseInt(numberTextField.getText()) < 0) {
                    JOptionPane.showMessageDialog(null, "Wprowadzono za małą liczbę");
                } else {
                    new Insert(Integer.parseInt(numberTextField.getText()));
                }
            }catch (NumberFormatException ex) { JOptionPane.showMessageDialog(null, "Wprowadzono nieprawidłową liczbę");
            } finally {endDrawTree(); }
        });

        deleteButton.addActionListener(e -> {
            setLastTree();
            try {
                if (Integer.parseInt(numberTextField.getText()) > 100) {
                    JOptionPane.showMessageDialog(null, "Wprowadzono za dużą liczbę");
                } else if (Integer.parseInt(numberTextField.getText()) < 0) {
                    JOptionPane.showMessageDialog(null, "Wprowadzono za małą liczbę");
                } else {
                    new Delete(Integer.parseInt(numberTextField.getText()));
                }
            }catch (NumberFormatException ex) { JOptionPane.showMessageDialog(null, "Wprowadzono nieprawidłową liczbę");
            } finally { endDrawTree(); }
        });

        splayButton.addActionListener(e -> {
            setLastTree();
            try {
                if (Integer.parseInt(numberTextField.getText()) > 100) {
                    JOptionPane.showMessageDialog(null, "Wprowadzono za dużą liczbę");
                } else if (Integer.parseInt(numberTextField.getText()) < 0) {
                    JOptionPane.showMessageDialog(null, "Wprowadzono za małą liczbę");
                } else {
                    new Splay(Integer.parseInt(numberTextField.getText()), SplayTreeNode.getRoot());
                }
            }catch (NumberFormatException ex) { JOptionPane.showMessageDialog(null, "Wprowadzono nieprawidłową liczbę");
            } finally {endDrawTree(); }
        });

        searchButton.addActionListener(e -> {
            setLastTree();
            try {
                if (Integer.parseInt(numberTextField.getText()) > 100) {
                    JOptionPane.showMessageDialog(null, "Wprowadzono za dużą liczbę");
                } else if (Integer.parseInt(numberTextField.getText()) < 0) {
                    JOptionPane.showMessageDialog(null, "Wprowadzono za małą liczbę");
                } else {
                    new Get(Integer.parseInt(numberTextField.getText()));
                }
            }catch (NumberFormatException ex) { JOptionPane.showMessageDialog(null, "Wprowadzono nieprawidłową liczbę");
            } finally {endDrawTree(); }
        });

        addRandomButton.addActionListener(e -> {
            setLastTree();
            int size, min, max;
            try {
                size = Integer.parseInt(sizeTextField.getText());
                min = Integer.parseInt(minTextField.getText());
                max = Integer.parseInt(maxTextField.getText());

                Random random = new Random();
                while (size-- >= 0) {
                    new Insert(random.nextInt(max - min)+min);
                }
            }catch (NumberFormatException ex) { System.out.print("Nie wpisano liczby!");
            }finally {
                setLastTree();
                sizeTextField.setText("");
                minTextField.setText("");
                maxTextField.setText("");
            }
        });

        animationCheckBox.addChangeListener(e-> {
            if(!animationCheckBox.isSelected()) {
                autoplayCheckBox.setSelected(false);
                autoplayCheckBox.setEnabled(false);
            }
            else {
                autoplayCheckBox.setEnabled(true);
            }
        });

        stateButton.addActionListener(e -> {
            SplayTreeNode root = SplayTreeContainer.get().getTree().getRoot();
            new StateMessage(root);
        });

        timeSlider.addChangeListener(e -> timer.setDelay(timeSlider.getValue()*500));

        nextButton.addActionListener(e -> {
            SplayTreeContainer.get().nextTree();
            InstructionArea.setText(SplayTreeContainer.get().getTree().getInstruction());
            treePanel.repaint();
        });

        prevButton.addActionListener(e -> {
            SplayTreeContainer.get().prevTree();
            InstructionArea.setText(SplayTreeContainer.get().getTree().getInstruction());
            treePanel.repaint();
        });

        deleteAllButton.addActionListener(e -> {
            SplayTreeNode.deleteAll();
            setLastTree();
        });

        playButton.addActionListener(e -> {
            if(timer.isRunning()) stopTimer();
            else playTimer();
        });
    }

    private void setLastTree() {
        SplayTreeContainer.get().setLastTree();
        InstructionArea.setText(SplayTreeContainer.get().getTree().getInstruction());
        treePanel.repaint();
    }

    private void endDrawTree() {
        SplayTreeNode.setAllColorsBlack();
        if(animationCheckBox.isSelected()) SplayTreeContainer.get().nextTree();
        else SplayTreeContainer.get().setLastTree();
        InstructionArea.setText(SplayTreeContainer.get().getTree().getInstruction());
        treePanel.repaint();
        numberTextField.setText("");
        sizeTextField.setText("");
        minTextField.setText("");
        maxTextField.setText("");
        if(autoplayCheckBox.isSelected()) playTimer();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SplayTree");
        frame.setContentPane(new SplayTree().windowPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);

        System.setProperty("awt.useSystemAAFontSettings","on");
        System.setProperty("swing.aatext", "true");
        System.setProperty("prism.lcdtext", "false");

        frame.setVisible(true);
    }

    private void createUIComponents() {
        treePanel = new TreeJPanel();
        timer = new Timer(5000, e-> play());
        timer.stop();
    }

    private void stopTimer() {
        timer.stop();
        playButton.setText("▶");
    }

    private void playTimer() {
        timer.start();
        playButton.setText("❚❚");
    }

    private void play() {
        if (SplayTreeContainer.get().isNextTree()) {
            SplayTreeContainer.get().nextTree();
            InstructionArea.setText(SplayTreeContainer.get().getTree().getInstruction());
            treePanel.repaint();
        }
        else stopTimer();
    }
}
