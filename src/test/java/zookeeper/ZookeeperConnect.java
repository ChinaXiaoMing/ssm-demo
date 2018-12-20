package zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import static org.apache.zookeeper.CreateMode.EPHEMERAL;

/**
 * zookeeper连接工具类
 */
public class ZookeeperConnect {
    final CountDownLatch countDownLatch = new CountDownLatch(1);
    String host = "127.0.0.1:2181";
    int sessionTimeout = 60000;
    ZooKeeper zooKeeper = null;

    /**
     * 连接zookeeper
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public ZooKeeper connect() throws IOException, InterruptedException {
        zooKeeper = new ZooKeeper(host, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if (watchedEvent.getState() == Event.KeeperState.SyncConnected) {
                    countDownLatch.countDown();
                }
            }
        });
        countDownLatch.await();
        return zooKeeper;
    }

    /**
     * 关闭zookeeper
     * @throws InterruptedException
     */
    public void close() throws InterruptedException {
        zooKeeper.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZookeeperConnect connect = new ZookeeperConnect();

        ZooKeeper zooKeeper = connect.connect();
        byte[] bytes = zooKeeper.getData("/FirstZnode", false, new Stat());
        System.out.println(new String(bytes));
        String path = "/FirstZnode";
        byte[] data = "first znode data".getBytes("utf8");
        List<ACL> acl = zooKeeper.getACL("/", new Stat());
//        String success = zooKeeper.create(path, data, acl, CreateMode.PERSISTENT);
//        System.out.println(success);
        List<String> list = zooKeeper.getChildren("/", false);
        list.stream().forEach(x -> System.out.println(x));
        zooKeeper.setData("/FirstZnode", "new znode data".getBytes(), zooKeeper.exists("/FirstZnode", false).getVersion());
        Stat stat =zooKeeper.exists("/FirstZnode", false);
        System.out.println(stat);
    }


}
