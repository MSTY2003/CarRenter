package config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.software212.car.service.TestService;

public class TestJDBC {
    public static void main(String[] args){
        AnnotationConfigApplicationContext appCon = new AnnotationConfigApplicationContext(SpringJDBCConfig.class);
        TestService ts = appCon.getBean(TestService.class);
        System.out.println(ts.getCarInfo());
        appCon.close();
    }
}
