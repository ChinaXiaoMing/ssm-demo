package ChainOfResposibility;

public class Request {

    private ResultType resultType;

    private String name;

    public Request(ResultType resultType, String name) {
        this.resultType = resultType;
        this.name = name;
    }

    public ResultType getResultType() {
        return resultType;
    }

    public void setResultType(ResultType resultType) {
        this.resultType = resultType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
