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
    //String host = "47.106.88.138:2181";
    //String host = "45.32.217.231:2181";
    String host = "45.32.217.231:2181,54.168.84.250:2181,47.106.88.138:2181";
    int sessionTimeout = 60000;
    ZooKeeper zooKeeper = null;

    /**
     * 连接zookeeper
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public ZooKeeper connect() throws IOException {
        zooKeeper = new ZooKeeper(host, sessionTimeout, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("触发监控事件类型：" + watchedEvent.getType());
            }
        });
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
//        String path = "/FirstZnode";
//        byte[] data = "first znode data".getBytes("utf8");
//        byte[] data1 = "first znode data1".getBytes("utf8");
//        List<ACL> acl = ZooDefs.Ids.OPEN_ACL_UNSAFE;
//
//        String success1 = null;
//        try {
//            String success = zooKeeper.create(path, data, acl, CreateMode.EPHEMERAL_SEQUENTIAL);
//            success1 = zooKeeper.create(path, data1, acl, CreateMode.PERSISTENT_SEQUENTIAL);
//            System.out.println(success);
//            System.out.println(success1);
//        } catch (KeeperException e) {
//            e.printStackTrace();
//        }
        List<String> list = zooKeeper.getChildren("/", false);
        list.stream().forEach(x -> System.out.println(x));
//        zooKeeper.setData("/FirstZnode", "new znode data".getBytes(), zooKeeper.exists("/FirstZnode", false).getVersion());
//        Stat stat =zooKeeper.exists("/FirstZnode", false);
    }


}
