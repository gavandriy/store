package com.epam.spring.configuration;

import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.format.FormatterRegistry;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.epam.spring.converter.ParticipantConverter;
import com.epam.spring.converter.ParticipantRoleConverter;
import com.epam.spring.converter.ParticipantStatusConverter;
import com.epam.spring.converter.UserConverter;

import javax.sql.DataSource;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.epam.spring.*")
@PropertySources({ @PropertySource("classpath:app.properties"), @PropertySource("classpath:messages.properties") })
@EnableAsync
@EnableTransactionManagement
@EnableScheduling
@EnableAspectJAutoProxy
@EntityScan(basePackages = { "com.epam.spring.model" })
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

	@Value("${dateFormat}")
	private String dateFormat;

	@Value("${db.host}")
	private String dbHost;

	@Value("${db.name}")
	private String dbName;

	@Value("${db.port}")
	private String port;

	@Value("${db.username}")
	private String username;

	@Value("${db.password}")
	private String password;

	@Autowired
	private ApplicationContext context;

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(context.getBean(ParticipantConverter.class));
		registry.addConverter(new ParticipantRoleConverter());
        registry.addConverter(new ParticipantStatusConverter());
        registry.addConverter(context.getBean(UserConverter.class));
		// converterAutoscanner(registry);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
	}

	/*
	 * @SuppressWarnings("rawtypes") private void
	 * converterAutoscanner(FormatterRegistry formatterRegistry) { Reflections
	 * reflections = new Reflections("com.epam.spring.converter"); Set<Class<?
	 * extends Converter>> allClasses =
	 * reflections.getSubTypesOf(Converter.class); allClasses.forEach(s -> { try
	 * { formatterRegistry.addConverter(s.newInstance()); } catch (Exception e)
	 * { e.printStackTrace(); } }); }
	 */

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(
				"jdbc:mysql://" + dbHost + ":" + port + "/" + dbName + "?autoReconnect=true&useSSL=false&create=true");
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	@Bean
	public DataSourceTransactionManager getTransactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}


	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
		return new TomcatEmbeddedServletContainerFactory();

	}

	@Bean
	public Executor taskExecutor() {
		return new SimpleAsyncTaskExecutor();
	}

}
