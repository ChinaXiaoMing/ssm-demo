package Build;

public class SmartHumanBuild implements BuildHuman {

    Human human;

    public SmartHumanBuild() {
        human = new Human();
    }

    @Override
    public void BuildHead() {
        human.setHead("创造一个高智商人的头");
    }

    @Override
    public void BuildBody() {
        human.setBody("创造一个高智商人的身体");
    }

    @Override
    public void BuildHand() {
        human.setHand("创造一个高智商人的手");
    }

    @Override
    public void BuildFoot() {
        human.setFoot("创造一个高智商人的脚");
    }

    @Override
    public Human createHuman() {
        return human;
    }

}
