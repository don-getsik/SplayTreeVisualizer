package pl.edu.wat.wcy.isi.Operations;

import pl.edu.wat.wcy.isi.Model.SplayTreeNode;

public class Get {

    private boolean result;

    public Get (Integer key) {
        new Splay(key, SplayTreeNode.getRoot());
        if (SplayTreeNode.isRoot())result = SplayTreeNode.getRoot().getValue().equals(key);
    }

    public boolean getResult () {return result;}
}
