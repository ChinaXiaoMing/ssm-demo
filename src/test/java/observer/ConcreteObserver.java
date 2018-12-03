package observer;

public class ConcreteObserver implements Observer {

    private String observerState;

    @Override
    public void update(Subject subject) {
        observerState = ((ConcreteSubject)subject).getState();
        System.out.println("Observer State:" + observerState);
    }
}
