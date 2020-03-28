package edu.fiu.ffqr;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import edu.fiu.ffqr.dataloader.DataLoader;

@Component
@SpringBootApplication
public class FFQUserApplication {

	public static void main(String[] args) throws IOException{
		ApplicationContext ctx = SpringApplication.run(FFQUserApplication.class, args);
		
		String loadDataArg = (String) ctx.getBean("loadUsersEnvVar");
		if (loadDataArg.equalsIgnoreCase("true")) {
			DataLoader loader = (DataLoader)ctx.getBean(DataLoader.class);
			loader.load();
		}

		DataLoader loader = (DataLoader)ctx.getBean(DataLoader.class);
		loader.loadSysUsersService();

	}
	
	@Bean
	public String loadUsersEnvVar(@Value("${mongo.users.load}")String value) {
		return value;
	}
}