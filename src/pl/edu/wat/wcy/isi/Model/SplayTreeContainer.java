package pl.edu.wat.wcy.isi.Model;

import java.util.ArrayList;

public class SplayTreeContainer {

    private ArrayList<SplayTree> splayTrees;
    private int actualTreeNumber;

    private static SplayTreeContainer splayTreeContainer;

    public SplayTree getTree() {return splayTrees.get(actualTreeNumber);}

    public void nextTree() {if (actualTreeNumber < splayTrees.size()-1) actualTreeNumber++;}
    public void prevTree() {if (actualTreeNumber > 0) actualTreeNumber--;}

    public SplayTree getNextTree() {
        return actualTreeNumber < splayTrees.size() ? splayTrees.get(actualTreeNumber++) : null;
    }

    public SplayTree getPrevTree() {
        return actualTreeNumber > 0 ? splayTrees.get(actualTreeNumber--) : null;
    }

    public void addTree(String instruction) {
        splayTrees.add(new SplayTree(instruction));
    }

    public void setLastTree () {
        actualTreeNumber = splayTrees.size()-1;
    }

    public SplayTree getLastTree() {
        return splayTrees.get(splayTrees.size()-1);
    }

    private SplayTreeContainer() {
        this.splayTrees = new ArrayList<>();
        this.addTree("");
        this.actualTreeNumber = 0;
    }

    public static SplayTreeContainer get() {
        if (splayTreeContainer==null) splayTreeContainer = new SplayTreeContainer();
        return splayTreeContainer;
    }
}
