package proxy;

public class User implements UserDao {
    @Override
    public void save() {
        System.out.println("目标对象实现保存动作");
    }
}
