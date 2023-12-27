package lt.zebieksts.xmas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class XmasApplication {

  public static void main(String[] args) {
    SpringApplication.run(lt.zebieksts.xmas.XmasApplication.class, args);
  }
}
