package pl.edu.wat.wcy.isi.Operations;

import pl.edu.wat.wcy.isi.Model.SplayTreeNode;

public class Insert {

    private boolean result;

    public Insert (Integer key) {
        new Splay (key, SplayTreeNode.getRoot());
        SplayTreeNode root = SplayTreeNode.getRoot();
        if(root == null) {
            SplayTreeNode.setRoot(new SplayTreeNode(key));
            result = true;
        }
        else if (root.getValue().equals(key))
            result = false;
        else if(root.getValue().compareTo(key) < 0) {
            SplayTreeNode tmp = root.getRight();
            SplayTreeNode newNode = new SplayTreeNode(key);
            newNode.setLeft(root);
            newNode.getLeft().setFather(newNode);
            root.setRight(null);
            if (tmp != null) {
                newNode.setRight(tmp);
                newNode.getRight().setFather(newNode);
            }
            SplayTreeNode.setRoot(newNode);
            result = true;
        }
        else if(root.getValue().compareTo(key) > 0) {
            SplayTreeNode tmp = root.getLeft();
            SplayTreeNode newNode = new SplayTreeNode(key);
            newNode.setRight(root);
            newNode.getRight().setFather(newNode);
            root.setLeft(null);
            if (tmp != null) {
                newNode.setLeft(tmp);
                newNode.getLeft().setFather(newNode);
            }
            SplayTreeNode.setRoot(newNode);
            result = true;
        }
    }

    public boolean getResult () {return result;}
}
