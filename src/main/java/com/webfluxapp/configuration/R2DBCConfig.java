package com.webfluxapp.configuration;

import static io.r2dbc.pool.PoolingConnectionFactoryProvider.MAX_SIZE;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;

@Configuration
@ConfigurationProperties(prefix = "r2dbc")
public class R2DBCConfig {

	private String driver;
	private String host;
	private int port;
	private String user;
	private String password;
	private String name;
	private int poolMaxSize;

	@Bean
	public ConnectionFactory connectionFactory() {
		return ConnectionFactories
				.get(ConnectionFactoryOptions.builder().option(ConnectionFactoryOptions.DRIVER, driver)
						.option(ConnectionFactoryOptions.HOST, host).option(ConnectionFactoryOptions.PORT, port)
						.option(ConnectionFactoryOptions.USER, user).option(ConnectionFactoryOptions.PASSWORD, password)
						.option(ConnectionFactoryOptions.DATABASE, name).option(MAX_SIZE, poolMaxSize).build());
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPoolMaxSize(int poolMaxSize) {
		this.poolMaxSize = poolMaxSize;
	}

}
