package de.nuss.software.catalog.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@ConfigurationProperties(prefix = "software-catalog.client")
@Validated
@Data
@Slf4j
public class ClientProperties {

	public ClientProperties() {
		log.info("initialize client properties");
	}

	/**
	 * Url of the software service
	 */
	// @NotNull
	private String url;

	/**
	 * Username which is used for the authentication
	 */
	// @NotNull
	private String username;

	/**
	 * Password which is used for the authentication
	 */
	// @NotNull
	private String password;

}
