package com.cts.spring.springboot.propertysourceexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;


@Configuration
@PropertySource(value="resources/config.properties",ignoreResourceNotFound=true)
public class PropertySourceDemo implements InitializingBean{

	private static final Logger LOGGER = LoggerFactory.getLogger(PropertySourceDemo.class);
	@Value("${jdbc.driver}")
	private String driver;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Value("${jdbc.username}")
	private String username;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Autowired
	Environment env;

	@Override
	public void afterPropertiesSet() throws Exception {
		LOGGER.info(driver);
		LOGGER.info(url);
		LOGGER.info(username);
		LOGGER.info(password);
		
		setDatabaseConfig();
	}
	private void setDatabaseConfig() {
		DataSourceConfig config = new DataSourceConfig();
		config.setDriver(env.getProperty("jdbc.driver"));
		 config.setUrl(env.getProperty("jdbc.url"));
		  config.setUsername(env.getProperty("jdbc.username"));
		  config.setPassword(env.getProperty("jdbc.password"));
		  System.out.println("-------------------------");
		  System.out.println(config.toString());
		  System.out.println("-------------------------");
		
	}
	

}
