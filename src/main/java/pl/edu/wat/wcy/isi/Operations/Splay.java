package pl.edu.wat.wcy.isi.Operations;

import pl.edu.wat.wcy.isi.Model.SplayTreeContainer;
import pl.edu.wat.wcy.isi.Model.SplayTreeNode;

import java.awt.*;

public class Splay {

    public Splay(Integer key, SplayTreeNode root) {
        SplayTreeContainer.get().addTree("Rozpoczęcie procesu splay");
        SplayTreeNode x = root;
        SplayTreeNode tmp = null;

        if (x == null) {
            SplayTreeContainer.get().addTree("Drzewo jest puste. Kończenie procesu Splay");
            return;
        }
        SplayTreeContainer.get().addTree("Wyszukiwanie węzła do ustawienia jako korzeń");
        do {
            if(x.getValue().equals(key)) break;
            tmp = x;                // Remember node adress
            x = (key < x.getValue() ? x.getLeft(): x.getRight());
        } while(x != null);

        if(x == null) x = tmp;
        SplayTreeContainer.get().addTree("Wezęł " + x.getValue() + " będzie obiektem naszych działań");
        // get next or prev
        while(x.getFather() != null)    {
            // x father is root
            if(x.getFather().getFather() == null) {
                zig(root, x);
                return;
            }
            // right ZIG-ZIG
            if((x.getFather().getFather().getLeft() == x.getFather()) && (x.getFather().getLeft() == x)) {
                rightZigZig(root, x);
                continue;
            }
            // left ZIG-ZIG
            if((x.getFather().getFather().getRight() == x.getFather()) && (x.getFather().getRight() == x)) {
                leftZigZig(root, x);
                continue;
            }
            // left ZIG, right ZAG
            if(x.getFather().getRight() == x)leftZigRightZag(root, x);
            // left ZIG, right ZAG
            else rightZigLeftZag(root, x);
        }
        SplayTreeContainer.get().addTree("Zakończenie działania algorytmu Splay");
    }

    private void rightZigLeftZag(SplayTreeNode root, SplayTreeNode x) {
        SplayTreeContainer.get().addTree("Wykonywanie operacji prawy ZIG, lwey ZAG na węźle " + x.getValue());
        SplayTreeNode father = x.getFather();

        x.setColor(Color.BLUE);
        father.setColor(Color.RED);
        SplayTreeContainer.get().addTree("Wykonywanie rotacji w prawo na węźle " + father.getValue());

        new Rotate(x.getFather(), Rotate.RotateType.RIGHT, root);
        SplayTreeContainer.get().addTree("Wykonywanie rotacji w lewo na węźle " + father.getValue());

        new Rotate (x.getFather(), Rotate.RotateType.LEFT, root);
        SplayTreeContainer.get().addTree("Zakończono wykonywanie operacji ZIG-ZAG na węźle " + x.getValue());

        x.colorBlack(x, father);
    }

    private void leftZigRightZag(SplayTreeNode root, SplayTreeNode x) {
        SplayTreeContainer.get().addTree("Wykonywanie operacji lewy ZIG, prawy ZAG na węźle " + x.getValue());
        SplayTreeNode father = x.getFather();

        x.setColor(Color.BLUE);
        father.setColor(Color.RED);
        SplayTreeContainer.get().addTree("Wykonywanie rotacji w lewo na węźle " + father.getValue());

        new Rotate(x.getFather(), Rotate.RotateType.LEFT, root);
        SplayTreeContainer.get().addTree("Wykonywanie rotacji w prawo na węźle " + father.getValue());

        new Rotate (x.getFather(), Rotate.RotateType.RIGHT, root);
        SplayTreeContainer.get().addTree("Zakończono wykonywanie operacji ZIG-ZAG na węźle " + x.getValue());

        x.colorBlack(x, father);
    }

    private void leftZigZig(SplayTreeNode root, SplayTreeNode x) {
        SplayTreeContainer.get().addTree("Wykonywanie operacji lewy ZIG-ZIG na węźle " + x.getValue());
        SplayTreeNode father = x.getFather(), grandpa = x.getFather().getFather();

        x.setColor(Color.BLUE);
        father.setColor(Color.RED);
        grandpa.setColor(Color.GREEN);
        SplayTreeContainer.get().addTree("Wykonywanie rotacji w lewo na węźle " + grandpa.getValue());

        new Rotate(x.getFather().getFather(), Rotate.RotateType.LEFT, root);
        SplayTreeContainer.get().addTree("Wykonywanie rotacji w lewo na węźle " + grandpa.getValue());

        new Rotate (x.getFather(), Rotate.RotateType.LEFT, root);
        SplayTreeContainer.get().addTree("Zakończono wykonywanie operacji ZIG-ZIG na węźle " + x.getValue());

        x.colorBlack(x, father, grandpa);
    }

    private void rightZigZig(SplayTreeNode root, SplayTreeNode x) {
        SplayTreeContainer.get().addTree("Wykonywanie operacji prawy ZIG-ZIG na węźle " + x.getValue());
        SplayTreeNode father = x.getFather(), grandpa = x.getFather().getFather();

        x.setColor(Color.BLUE);
        father.setColor(Color.RED);
        grandpa.setColor(Color.GREEN);
        SplayTreeContainer.get().addTree("Wykonywanie rotacji w prawo na węźle " + grandpa.getValue());

        new Rotate(grandpa, Rotate.RotateType.RIGHT, root);
        SplayTreeContainer.get().addTree("Wykonywanie rotacji w prawo na węźle " + grandpa.getValue());

        new Rotate (father, Rotate.RotateType.RIGHT, root);
        SplayTreeContainer.get().addTree("Zakończono wykonywanie operacji ZIG-ZIG na węźle " + x.getValue());

        x.colorBlack(x, father, grandpa);
    }

    private void zig(SplayTreeNode root, SplayTreeNode x) {
        SplayTreeNode father = x.getFather();

        x.setColor(Color.BLUE);
        father.setColor(Color.RED);
        if(x.getFather().getLeft() == x) {
            SplayTreeContainer.get().addTree(
                    "Wykonujemy operację ZIG poprzez rotację w lewo na weźle " + x.getFather().getValue());
            new Rotate(x.getFather(), Rotate.RotateType.RIGHT, root);
        }

        else {
            SplayTreeContainer.get().addTree(
                    "Wykonujemy operację ZIG poprzez rotację w prawo na weźle " + x.getFather().getValue());
            new Rotate(x.getFather(), Rotate.RotateType.LEFT, root);
        }

        SplayTreeContainer.get().addTree("Zakończono wykonywanie oparacji ZIG na węźle " + x.getValue());
        x.setColor(Color.BLACK);
        father.setColor(Color.BLACK);
    }
}
