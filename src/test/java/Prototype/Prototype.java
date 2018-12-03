package Prototype;

import java.util.ArrayList;

public class Prototype implements Cloneable {

    private ArrayList list = new ArrayList();

    public Prototype clone() {
        Prototype prototype = null;
        try {
            prototype = (Prototype)super.clone();
            //深拷贝
            prototype.list = (ArrayList) this.list.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return prototype;
    }

}
