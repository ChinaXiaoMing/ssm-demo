package proxy;

public class UserProxy implements UserDao {

    private UserDao target;

    public UserProxy(UserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("代理对象实现代理保存动作");
        target.save();
    }
}
