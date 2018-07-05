package Model;

public class Root {

    static private SplayTreeNode node;

    private Root () {
        node = new SplayTreeNode();
    }

    public static SplayTreeNode get () {return node;}
    public static void set (SplayTreeNode root) {node = root;}
}
