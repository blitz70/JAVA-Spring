package kr.co.iamtek;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJava {

	public static void main(String[] args) {
		
		String config = null;
		System.out.println("Environment is (dev/run)?");
		Scanner scan = new Scanner(System.in);
		if (scan.hasNext()) config = scan.next();
		scan.close();
		
		if (config.equals("dev") || config.equals("run")) {
			AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
			ctx.getEnvironment().setActiveProfiles(config);
			ctx.register(ApplicationCTXDev.class, ApplicationCTXRun.class);
			ctx.refresh();
			ServerInfo serverInfo = ctx.getBean("serverInfo", ServerInfo.class);
			System.out.println("Env : " + config + ", Ip : " + serverInfo.getIpNum() + ", Port : " + serverInfo.getPortNum());
			ctx.close();
		}

	}

}
