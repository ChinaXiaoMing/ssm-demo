import com.nexwise.service.ProduceService;
import org.apache.xbean.spring.context.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

public class ActivemqTest {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-activemq.xml");
        ProduceService produceService = applicationContext.getBean(ProduceService.class);
        for (int i = 0; i < 100; i++) {
            produceService.sendMessage("test" + i);
        }
        ((ClassPathXmlApplicationContext) applicationContext).close();

    }

}
