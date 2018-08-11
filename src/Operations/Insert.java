package Operations;

import Model.Root;
import Model.SplayTreeNode;

public class Insert {

    private boolean result;

    public Insert (Integer key) {
        new Splay (key);
        if (Root.get().getValue().equals(key))
            result = false;
        else if(Root.get().getValue().compareTo(key) < 0) {
            SplayTreeNode tmp = Root.get().getRight();
            SplayTreeNode newNode = new SplayTreeNode(key);
            newNode.setLeft(Root.get());
            newNode.getLeft().setFather(newNode);
            newNode.setRight(tmp);
            newNode.getRight().setFather(newNode);
            Root.set(newNode);
            result = true;
        }
        else if(Root.get().getValue().compareTo(key) > 0) {
            SplayTreeNode tmp = Root.get().getLeft();
            SplayTreeNode newNode = new SplayTreeNode(key);
            newNode.setRight(Root.get());
            newNode.getRight().setFather(newNode);
            newNode.setLeft(tmp);
            newNode.getLeft().setFather(newNode);
            Root.set(newNode);
            result = true;
        }
    }

    public boolean getResult () {return result;}
}
