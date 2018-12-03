package Build;

public class FoolHumanBuild implements BuildHuman {

    Human human;

    public FoolHumanBuild() {
        human = new Human();
    }

    @Override
    public void BuildHead() {
        human.setHead("创造一个傻子的头");
    }

    @Override
    public void BuildBody() {
        human.setBody("创造一个傻子的身体");
    }

    @Override
    public void BuildHand() {
        human.setHand("创造一个傻子的手");
    }

    @Override
    public void BuildFoot() {
        human.setFoot("创造一个傻子的脚");
    }

    @Override
    public Human createHuman() {
        return human;
    }
}
