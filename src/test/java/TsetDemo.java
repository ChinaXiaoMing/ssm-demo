import java.util.ArrayList;
import java.util.List;

/**
 * @Descript 测试环境
 * @Author fuyuanming
 * @Date 2018-05-17 14:45:41
 * @Version 1.0
 */
public class TsetDemo {

    public static void main(String[] args) throws CloneNotSupportedException {

        long start = System.currentTimeMillis();
        Object object = new Object();
        List<Object> list = new ArrayList<Object>();
        int N = 10000;
        for (int i = 0; i < N; i++) {
            list.add(object);
        }
        System.out.println(System.currentTimeMillis() - start);

        long start2 = System.currentTimeMillis();
        List<Object> list2 = new ArrayList<Object>();
        ((ArrayList<Object>) list2).ensureCapacity(N);
        for (int i = 0; i < N; i++) {
            list.add(object);
        }
        System.out.println(System.currentTimeMillis() - start2);


    }

}
