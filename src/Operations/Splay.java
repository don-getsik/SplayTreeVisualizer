package Operations;

import Model.Root;
import Model.SplayTreeNode;

public class Splay {

    public Splay (Integer key) {
        SplayTreeNode  x = Root.get();
        SplayTreeNode tmp = null;

        if (null == x) return;
        do {
            if(x.getValue().equals(key)) break;
            tmp = x;                // Zapamiętujemy adres węzła
            x = key < x.getValue() ? x.getLeft(): x.getRight();
        } while(x != null);

        if(x == null) x = tmp;
        // bierzemy bezpośredni następnik lub poprzednik
        while(x.getFather() != null)    {
            // Ojcem x jest korzeń. Wykonujemy ZIG i kończymy
            if(x.getFather().getFather() != null) {
                if(x.getFather().getLeft() == x) new Rotate(x.getFather(), Rotate.RotateType.RIGHT);
                else new Rotate(x.getFather(), Rotate.RotateType.LEFT);
                return;
            }
            // prawy ZIG-ZIG
            if((x.getFather().getFather().getLeft() == x.getFather()) && (x.getFather().getLeft() == x)) {
                new Rotate (x.getFather().getFather(), Rotate.RotateType.RIGHT);
                new Rotate (x.getFather(), Rotate.RotateType.RIGHT);
            }
            // lewy ZIG-ZIG
            else if((x.getFather().getFather().getRight() == x.getFather()) && (x.getFather().getRight() == x)) {
                new Rotate (x.getFather().getFather(), Rotate.RotateType.LEFT);
                new Rotate (x.getFather(), Rotate.RotateType.LEFT);
            }
            // lewy ZIG, prawy ZAG
            else if(x.getFather().getRight() == x) {
                new Rotate (x.getFather(), Rotate.RotateType.LEFT);
                new Rotate (x.getFather(), Rotate.RotateType.RIGHT);
            }
            // prawy ZIG, lewy ZAG
            else {
                new Rotate (x.getFather(), Rotate.RotateType.RIGHT);
                new Rotate (x.getFather(), Rotate.RotateType.LEFT);
            }
        }
    }
}
