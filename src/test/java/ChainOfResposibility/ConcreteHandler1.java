package ChainOfResposibility;

public class ConcreteHandler1 extends Handler {

    public ConcreteHandler1 (Handler successor) {
        super(successor);
    }

    @Override
    protected void handlerRequest(Request request) {
        if (request.getResultType() == ResultType.type1) {
            System.out.println(request.getName() + " is handler by ConcreteHandler1");
            return;
        }
        if (successor != null) {
            successor.handlerRequest(request);
        }
    }
}
