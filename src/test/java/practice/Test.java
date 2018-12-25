package practice;

public class Test {

    public static void main(String[] args) {
        String host = "http://45.32.217.231:2181";
        int index = host.indexOf(47);
        if (index > 0) {
            System.out.println(host.substring(0, index));
        }

    }


}
