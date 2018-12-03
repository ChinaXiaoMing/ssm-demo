package observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

    private List<Observer> list = new ArrayList<Observer>();

    /**
     * 注册观察者对象
     * @param observer
     */
    public void attach(Observer observer) {
        list.add(observer);
        System.out.println("add an observer");
    }

    /**
     * 删除观察者对象
     * @param observer
     */
    public void detach(Observer observer) {
        list.remove(observer);
        System.out.println("remove an observer");
    }

    /**
     * 通知所有注册的观察者对象
     */
    public void notifyObservers() {
        for (Observer observer : list) {
            observer.update(this);
        }
    }

}
