package my.test.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.map.repository.config.EnableMapRepositories;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import my.test.EnableTestRESTController;
import my.test.MyPermissionEvaluator;
import my.test.ResourceConfig;
import my.test.TestI;
import my.test.TestObject;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled=true)
@Import({ResourceConfig.class})
@EnableMapRepositories("my.test")
@EnableTestRESTController
public class Application {

    public static void main(String[] args) throws Exception {
    	ApplicationContext context = SpringApplication.run(new Class[]{Application.class}, args);
     }

	@Bean
	public TestI testI() {
		return new TestObject();
	}

	@Bean
	protected PermissionEvaluator aclPermissionEvaluator() {
		return new MyPermissionEvaluator();
	}
	
	/*@Autowired
	public void see(TestRecordRepository test) {
	    System.out.println("This is my value ====================== " + test);
	}*/

	/**
	 * UNCOMMENT the below to have @PreAuthorize stop working
	 * COMMENT OUT the below to have @PreAuthorize work as expected
	 */
	//@Autowired
	//private TestRecordRepository testRecordRepository;

}
