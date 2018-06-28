import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Stream;

/**
 * @Descript 测试环境
 * @Author fuyuanming
 * @Date 2018-05-17 14:45:41
 * @Version 1.0
 */
public class TsetDemo {

    public static void main(String[] args) {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("redis");
        String host = resourceBundle.getString("redis.host");
        int maxIdle = Integer.parseInt(resourceBundle.getString("redis.maxIdle"));
        System.out.println(maxIdle);

    }

}
