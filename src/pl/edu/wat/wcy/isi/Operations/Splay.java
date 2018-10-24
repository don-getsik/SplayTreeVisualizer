package pl.edu.wat.wcy.isi.Operations;

import pl.edu.wat.wcy.isi.Model.SplayTreeNode;

public class Splay {

    public Splay (Integer key, SplayTreeNode root) {
        SplayTreeNode x = root;
        SplayTreeNode tmp = null;

        if (x == null) return;
        do {
            if(x.getValue().equals(key)) break;
            tmp = x;                // Zapamiętujemy adres węzła
            x = (key < x.getValue() ? x.getLeft(): x.getRight());
        } while(x != null);

        if(x == null) x = tmp;
        // bierzemy bezpośredni następnik lub poprzednik
        while(x.getFather() != null)    {
            // Ojcem x jest korzeń. Wykonujemy ZIG i kończymy
            if(x.getFather().getFather() == null) {
                if(x.getFather().getLeft() == x) new Rotate(x.getFather(), Rotate.RotateType.RIGHT, root);
                else new Rotate(x.getFather(), Rotate.RotateType.LEFT, root);
                return;
            }
            // prawy ZIG-ZIG
            if((x.getFather().getFather().getLeft() == x.getFather()) && (x.getFather().getLeft() == x)) {
                new Rotate (x.getFather().getFather(), Rotate.RotateType.RIGHT, root);
                new Rotate (x.getFather(), Rotate.RotateType.RIGHT, root);
                continue;
            }
            // lewy ZIG-ZIG
            if((x.getFather().getFather().getRight() == x.getFather()) && (x.getFather().getRight() == x)) {
                new Rotate (x.getFather().getFather(), Rotate.RotateType.LEFT, root);
                new Rotate (x.getFather(), Rotate.RotateType.LEFT, root);
                continue;
            }
            // lewy ZIG, prawy ZAG
            if(x.getFather().getRight() == x) {
                new Rotate (x.getFather(), Rotate.RotateType.LEFT, root);
                new Rotate (x.getFather(), Rotate.RotateType.RIGHT, root);
            }
            // prawy ZIG, lewy ZAG
            else {
                new Rotate (x.getFather(), Rotate.RotateType.RIGHT, root);
                new Rotate (x.getFather(), Rotate.RotateType.LEFT, root);
            }
        }
    }
}
