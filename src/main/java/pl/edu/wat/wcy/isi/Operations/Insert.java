package pl.edu.wat.wcy.isi.Operations;

import pl.edu.wat.wcy.isi.Model.SplayTreeContainer;
import pl.edu.wat.wcy.isi.Model.SplayTreeNode;
import java.awt.*;

public class Insert {

    public Insert (Integer key) {
        SplayTreeContainer.get().addTree("Wykoywanie opracji dodawania węzła " + key);
        new Splay (key, SplayTreeNode.getRoot());
        SplayTreeNode root = SplayTreeNode.getRoot();
        if(root == null) {
            SplayTreeNode.setRoot(new SplayTreeNode(key));
            SplayTreeContainer.get().addTree("Drzewo jest puste, więc dodajemy bez dodatkowych operacji");
        }
        else if (root.getValue().equals(key))
            SplayTreeContainer.get().addTree("W drzewie znajduje się już węzeł " + key);
        else if(root.getValue().compareTo(key) < 0) {
            adAsLeftRoot(key, root);
        }
        else if(root.getValue().compareTo(key) > 0) {
            adAsRightRoot(key, root);
        }
    }

    private void adAsRightRoot(Integer key, SplayTreeNode root) {
        SplayTreeNode tmp = root.getLeft();

        SplayTreeNode newNode = preConfigure(key, root, tmp);
        SplayTreeContainer.get().addTree("Korzeń jest większy od dodawanego węzła, " +
                "więc korzeń stanie się jego prawym potomkiem");
        newNode.setRight(root);
        newNode.getRight().setFather(newNode);
        root.setLeft(null);
        if (tmp != null) {
            newNode.setLeft(tmp);
            newNode.getLeft().setFather(newNode);
        }
        afterConfigure(key, newNode);
    }

    private void adAsLeftRoot(Integer key, SplayTreeNode root) {
        SplayTreeNode tmp = root.getRight();

        SplayTreeNode newNode = preConfigure(key, root, tmp);
        SplayTreeContainer.get().addTree("Korzeń jest mniejszy od dodawanego węzła, " +
                "więc korzeń stanie się jego lewym potomkiem");
        newNode.setLeft(root);
        newNode.getLeft().setFather(newNode);
        root.setRight(null);
        if (tmp != null) {
            newNode.setRight(tmp);
            newNode.getRight().setFather(newNode);
        }

        afterConfigure(key, newNode);
    }

    private SplayTreeNode preConfigure(Integer key, SplayTreeNode root, SplayTreeNode tmp) {
        SplayTreeNode newNode = new SplayTreeNode(key);
        if (tmp != null) tmp.setColor(Color.BLUE);
        newNode.setColor(Color.CYAN);
        root.setColor(Color.RED);
        return newNode;
    }

    private void afterConfigure(Integer key, SplayTreeNode newNode) {
        SplayTreeNode.setRoot(newNode);
        SplayTreeContainer.get().addTree("Zakończono proces dodawania węzła "+ key);
        SplayTreeNode.setAllColorsBlack();
        SplayTreeContainer.get().addTree("");
    }
}
