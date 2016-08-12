package my.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestRESTControllerConfiguration {


	@Bean
	public TestRESTController testRESTController() {
		return new TestRESTController();
	}
	
}
