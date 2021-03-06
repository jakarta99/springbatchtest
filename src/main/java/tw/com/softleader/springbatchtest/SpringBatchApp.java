package tw.com.softleader.springbatchtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBatchApp {
	public static void main(String[] args) {
		SpringApplication.run(SpringBatchApp.class, args);
	}
}
