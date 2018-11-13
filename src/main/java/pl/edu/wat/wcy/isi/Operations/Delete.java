package pl.edu.wat.wcy.isi.Operations;

import pl.edu.wat.wcy.isi.Model.SplayTreeContainer;
import pl.edu.wat.wcy.isi.Model.SplayTreeNode;

import java.awt.*;

public class Delete {

    public Delete (Integer key) {
        SplayTreeContainer.get().addTree("Rozpoczęcie procesu usuwania węzła");
        new Splay (key, SplayTreeNode.getRoot());
        SplayTreeNode root = SplayTreeNode.getRoot();
        if(root == null) {
            SplayTreeContainer.get().addTree("Drzewo jest puste. Brak możliwości usunięcia węxła");
        }
        else if (root.getValue().equals(key)) {
            deleteOperation(root);
        }
        else SplayTreeContainer.get().addTree("W drzewie nie ma węzła " + key);
    }

    private void deleteOperation(SplayTreeNode root) {
        root.setColor(Color.PINK);
        root.getRight().setColor(Color.CYAN);
        SplayTreeContainer.get().addTree("Podmiana węzła " + root.getValue() + " za największy element z lewego poddrzewa");

        SplayTreeNode right = root.getRight();
        SplayTreeNode.setRoot(root.getLeft());
        root = SplayTreeNode.getRoot();
        root.setFather(null);

        new Splay(Integer.MAX_VALUE, root);
        root = SplayTreeNode.getRoot();
        SplayTreeContainer.get().addTree("Dołączenie prawgo poddrzewa");

        root.setRight(right);
        right.setFather(root);
        SplayTreeContainer.get().addTree("Zakończenie opreracji Delete");

        root.setColor(Color.BLACK);
        right.setColor(Color.BLACK);
        SplayTreeContainer.get().addTree("");
    }
}
