package com.gzk;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
@RefreshScope
@Configuration
public class ConfigApplication {
	public static void main(String[] args) {
		SpringApplication.run(ConfigApplication.class, args);
	}
	
	@Value("${foo}")
	private String foo;
	@RequestMapping(value="hi")
	public String hi(){
		System.out.println(foo);
		return foo;
	}
	
//	@Value("${spring.rabbitmq.port}")
	@Value("${democonfigclient.message}")
	private String t;
	@RequestMapping(value="t1")
	public String t1(){
		System.out.println(t);
		return t;
	}
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	
	@Bean
	public DataSource dataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setUrl(this.url);
        dataSource.setUsername(this.username);//用户名
        dataSource.setPassword(this.password);//密码
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setInitialSize(2);
        dataSource.setMaxActive(20);
        dataSource.setMinIdle(0);
        dataSource.setMaxWait(60000);
        dataSource.setTestOnBorrow(false);
        dataSource.setTestWhileIdle(true);
        
        return dataSource;
    }
	@Bean
	public JdbcTemplate jdbcTemplate(){
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}
	
}
