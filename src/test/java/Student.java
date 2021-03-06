import java.util.Optional;

/**
 * @Descript 学生类
 * @Author fuyuanming
 * @Date 2018-05-17 15:24:10
 * @Version 1.0
 */
public class Student implements Cloneable{

    String name;
    int age;

    public Student() {

    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public String hello(Optional<String> name1, Optional<String> name2) {
        return name1.get() + name2.get();
    }

    public String hello() {
        return "hello world";
    }

}
