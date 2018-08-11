package Operations;

import Model.Root;

public class Get {

    private boolean result;

    public Get (Integer key) {
        new Splay(key);
        result = Root.get().getValue().equals(key);
    }

    public boolean getResult () {return result;}
}
