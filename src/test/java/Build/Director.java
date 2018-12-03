package Build;

public class Director {

    public Human createHumanDirector(BuildHuman buildHuman) {
        buildHuman.BuildHand();
        buildHuman.BuildBody();
        buildHuman.BuildFoot();
        buildHuman.BuildHead();
        return buildHuman.createHuman();
    }

}
