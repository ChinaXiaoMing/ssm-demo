package Build;

public class TestBuild {

    public static void main(String[] args) {

        Director director = new Director();
        Human human = director.createHumanDirector(new FoolHumanBuild());
        System.out.println(human.toString());

    }

}
