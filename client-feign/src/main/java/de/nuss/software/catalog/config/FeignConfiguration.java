package de.nuss.software.catalog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.feign.support.ResponseEntityDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.hal.Jackson2HalModule;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Logger;
import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;
import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableConfigurationProperties(ClientProperties.class)
@Slf4j
public class FeignConfiguration {

	@Autowired
	private ClientProperties clientProperties;

	public FeignConfiguration() {
		log.info("create feign configuration");
	}

	@Bean
	Logger.Level feignLoggerLevel() {
		return Logger.Level.FULL;
	}

	@Bean
	public Decoder feignDecoder() {
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.registerModule(new Jackson2HalModule());
		return new ResponseEntityDecoder(new JacksonDecoder(mapper));
	}

	// @Bean
	// public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
	// String username = clientProperties.getUsername();
	// String password = clientProperties.getPassword();
	// log.info("create basic auth interceptor with user {}", username);
	// return new BasicAuthRequestInterceptor(username, password);
	// }
}
