import redis.clients.jedis.Jedis;

public class JedisTest {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("47.106.88.138", 6379);
        //jedis.auth("123456");
        System.out.println(jedis.get("userList"));
        jedis.close();

    }

}
