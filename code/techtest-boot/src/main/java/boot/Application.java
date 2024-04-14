package boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EnableJpaRepositories("com.bcnc.techtest")
@ComponentScan(basePackages = {"com.bcnc.techtest"})
@EntityScan("com.bcnc.techtest")

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
