package pl.edu.wat.wcy.isi.GUI;

import pl.edu.wat.wcy.isi.Model.SplayTreeNode;
import pl.edu.wat.wcy.isi.Operations.Statistics;
import pl.edu.wat.wcy.isi.Operations.TreeOrder;
import javax.swing.*;
import java.awt.*;

class StateMessage extends JFrame {

    private Statistics statistics;
    private TreeOrder treeOrder;

    StateMessage (SplayTreeNode root) {
        this.statistics = new Statistics(root);
        this.treeOrder = new TreeOrder(root);
        setContentPane(crateMessage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        setVisible(true);
    }

    private Container crateMessage() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(addLabel("Ilość węzłów: " + statistics.countNodes()));
        panel.add(addLabel("Ilość liści: " + statistics.getLeafCount()));
        panel.add(addLabel("Maksymalna łębkokość drzewa: " + statistics.treeDepth()));
        panel.add(addLabel("Minimalna głębkokość drzewa: " + statistics.minimumDepth()));
        panel.add(addLabel("Pre order:"));
        panel.add(addLabel(arrayToString(treeOrder.getPreOrder())));
        panel.add(addLabel("In order:"));
        panel.add(addLabel(arrayToString(treeOrder.getInOrder())));
        panel.add(addLabel("Post order:"));
        panel.add(addLabel(arrayToString(treeOrder.getPostOrder())));
        panel.add(addLabel("Sumy poziomów:"));
        panel.add(addLabel(statistics.VerticalSumMain()));
        return panel;
    }

    private String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int a: array) {
            sb.append(" ").append(a).append(" ");
        }
        return sb.toString();
    }

    private JLabel addLabel(String string){
        JLabel label = new SmoothLabel(string);
        Font newFont = new Font("serif", Font.PLAIN, 20);
        label.setFont(newFont);
        return label;
    }
}
