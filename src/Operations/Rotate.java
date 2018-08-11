package Operations;
import Model.*;

class Rotate {

    public enum RotateType {LEFT, RIGHT}

    Rotate(SplayTreeNode node, RotateType type) {
        boolean result;
        if (type == RotateType.LEFT) result = left(node);
        else result = right(node);

        if (result) SetFather(node);
    }

    private boolean right(SplayTreeNode node) {
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

        return true;
    }

    private boolean left (SplayTreeNode node) {
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

        return true;
    }

    private void SetFather(SplayTreeNode node) {
        SplayTreeNode child = node.getFather();
        SplayTreeNode father = child.getFather();

        //If node isn't root
        if(father != null) {
            if (father.getRight() == node) father.setRight(child);
            else father.setLeft(child);
        }
        //If node is root
        else Root.set(child);
    }
}
