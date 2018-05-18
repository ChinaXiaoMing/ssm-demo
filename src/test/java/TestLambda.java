/**
 * @Descript Lambda测试接口
 * @Author fuyuanming
 * @Date 2018-05-17 14:44:44
 * @Version 1.0
 */
@FunctionalInterface
public interface TestLambda<T,V> {
    int compare(T num, V other);
}
