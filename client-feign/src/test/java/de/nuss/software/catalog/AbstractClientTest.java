package de.nuss.software.catalog;

import org.junit.BeforeClass;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.hateoas.config.EnableHypermediaSupport;

import de.nuss.software.catalog.config.ClientProperties;
import de.nuss.software.catalog.config.FeignConfiguration;

@PropertySource("classpath:application.properties")
@EnableAutoConfiguration
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
@EnableFeignClients(defaultConfiguration = FeignConfiguration.class)
@EnableConfigurationProperties(ClientProperties.class)
public class AbstractClientTest {

	protected static ApplicationContext context;

	@BeforeClass
	public static void beforeClass() throws Exception {
		if (context == null) {
			context = new AnnotationConfigApplicationContext(AbstractClientTest.class);
		}
	}
}
