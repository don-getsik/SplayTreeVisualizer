package Operations;

import Model.Root;
import Model.SplayTreeNode;

public class Delete {

    private boolean result;

    public Delete (Integer key) {
        new Splay (key);
        if (Root.get().getValue().equals(key)) {
            SplayTreeNode right = Root.get().getRight();
            Root.set(Root.get().getLeft());
            Root.get().setFather(null);
            new Splay(Integer.MAX_VALUE);
            Root.get().setRight(right);
            right.setFather(Root.get());
            result = true;
        }
        else result = false;
    }
}
