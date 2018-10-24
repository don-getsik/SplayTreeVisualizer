package pl.edu.wat.wcy.isi.Operations;

import pl.edu.wat.wcy.isi.Model.SplayTreeNode;

public class Delete {

    private boolean result;

    public Delete (Integer key) {
        new Splay (key);
        SplayTreeNode root = SplayTreeNode.getRoot();
        if(root == null) result = false;
        else if (root.getValue().equals(key)) {
            SplayTreeNode right = root.getRight();
            SplayTreeNode.setRoot(root.getLeft());
            root.setFather(null);
            new Splay(Integer.MAX_VALUE);
            root.setRight(right);
            right.setFather(root);
            result = true;
        }
        else result = false;
    }
}
