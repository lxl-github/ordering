package com.lxl.ordering.bootstrap;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
@EnableAutoConfiguration(exclude = {
		DataSourceAutoConfiguration.class
})
@ComponentScan(basePackages = "com.lxl.ordering")
public class StartApplication {

	@Bean
	public TomcatEmbeddedServletContainerFactory customizerServletContainer() {
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
			@Override
			public void customize(Connector connector) {
				connector.setProperty("socket.soReuseAddress", "true");
			}
		});
		ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/static/401.html");
		ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/static/404.html");
		ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/static/500.html");
		factory.addErrorPages(error401Page, error404Page, error500Page);
		return factory;
	}

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplicationBuilder(StartApplication.class)
				.bannerMode(Banner.Mode.OFF)
				.registerShutdownHook(true)
				.web(true)
				.application();
		springApplication.run(args);
	}

}
