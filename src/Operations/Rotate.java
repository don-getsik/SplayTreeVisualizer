package Operations;
import Model.*;

public class Rotate {

    static boolean right(SplayTreeNode node) {
        SplayTreeNode leftChild =  node.getLeft();

        //If LeftChild is null we can't continue
        if (leftChild == null) return false;

        SplayTreeNode father = node.getFather();

        //Set new left child from right left child
        node.setLeft(leftChild.getRight());

        //If new left child isn't null we set new father
        if (node.getLeft() != null)
            node.getLeft().setFather(node);

        //Set child as father
        leftChild.setRight(node);
        leftChild.setFather(father);
        node.setFather(leftChild);

        SetFather(node, leftChild, father);

        return true;
    }

    static boolean left (SplayTreeNode node) {
        SplayTreeNode rightChild = node.getRight();

        //If RightChild is null we can't continue
        if (rightChild == null) return false;

        SplayTreeNode father = node.getFather();

        //set new right child from left right child
        node.setRight(rightChild.getLeft());

        //If new right child isn't null we set new father
        if (node.getRight() != null)
            node.getRight().setFather(node);

        //Set child sa father
        rightChild.setLeft(node);
        rightChild.setFather(father);
        node.setFather(rightChild);

        SetFather(node, rightChild, father);

        return true;
    }

    private static void SetFather(SplayTreeNode node, SplayTreeNode rightChild, SplayTreeNode father) {
        //If node isn't root
        if(father != null) {
            if (father.getRight() == node) father.setRight(rightChild);
            else father.setLeft(rightChild);
        }
        //If node is root
        else Root.set(rightChild);
    }
}
