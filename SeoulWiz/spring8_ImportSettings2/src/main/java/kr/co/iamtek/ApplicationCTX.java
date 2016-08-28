package kr.co.iamtek;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class ApplicationCTX {
	
	@Value("${admin.id}")
	private String adminId;
	@Value("${admin.pw}")
	private String adminPw;
	@Value("${subadmin.id}")
	private String subAdminId;
	@Value("${subadmin.pw}")
	private String subAdminPw;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySources() {
		System.out.println("propertySources()");
		PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
		Resource[] locations = new Resource[2];
		locations[0] = new ClassPathResource("admin.properties");
		locations[1] = new ClassPathResource("subadmin.properties");
		configurer.setLocations(locations);
		return configurer;
	}
	
	@Bean
	public AdminConnection adminConnection() {
		System.out.println("adminConnection()");
		AdminConnection adminConnection = new AdminConnection();
		adminConnection.setAdminId(adminId);
		adminConnection.setAdminPw(adminPw);
		adminConnection.setSubAdminId(subAdminId);
		adminConnection.setSubAdminPw(subAdminPw);
		return adminConnection;
	}

}
