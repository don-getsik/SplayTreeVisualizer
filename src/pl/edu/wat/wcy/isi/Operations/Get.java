package pl.edu.wat.wcy.isi.Operations;

import pl.edu.wat.wcy.isi.Model.SplayTreeContainer;
import pl.edu.wat.wcy.isi.Model.SplayTreeNode;

public class Get {


    public Get (Integer key) {
        SplayTreeContainer.get().addTree("Wykoywanie opracji wyszukiwania węzła " + key);
        new Splay(key, SplayTreeNode.getRoot());
        if (SplayTreeNode.isRoot() && SplayTreeNode.getRoot().getValue().equals(key))
            SplayTreeContainer.get().addTree("W drzeiwe znajduje się wezeł " + key);
        else {
            SplayTreeContainer.get().addTree("W drzewie nie ma węzła " + key);
        }
    }

}
