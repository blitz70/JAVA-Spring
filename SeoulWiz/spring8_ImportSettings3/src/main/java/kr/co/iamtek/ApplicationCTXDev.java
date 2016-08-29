package kr.co.iamtek;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("dev")
@Configuration
public class ApplicationCTXDev {

	@Bean
	public ServerInfo serverInfo() {
		ServerInfo si = new ServerInfo();
		si.setIpNum("localhost");
		si.setPortNum("8080");
		return si;
	}
}
