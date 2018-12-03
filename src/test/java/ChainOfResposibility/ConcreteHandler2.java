package ChainOfResposibility;

public class ConcreteHandler2 extends Handler {

    public ConcreteHandler2(Handler successor) {
        super(successor);
    }

    @Override
    protected void handlerRequest(Request request) {
        if (request.getResultType() == ResultType.type2) {
            System.out.println(request.getName() + " is handler by ConcreteHandler2");
            return;
        }
        if (successor != null) {
            successor.handlerRequest(request);
        }
    }
}
