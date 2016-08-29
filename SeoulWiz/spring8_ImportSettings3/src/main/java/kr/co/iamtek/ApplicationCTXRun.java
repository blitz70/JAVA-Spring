package kr.co.iamtek;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("run")
@Configuration
public class ApplicationCTXRun {
	
	@Bean
	public ServerInfo serverInfo() {
		ServerInfo si = new ServerInfo();
		si.setIpNum("123.140.187.157");
		si.setPortNum("80");
		return si;
	}

}
