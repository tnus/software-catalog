package de.nuss.software.catalog.software;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import de.nuss.software.catalog.AbstractIntegrationTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SoftwareRestRepositoryTest extends AbstractIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void exampleTest() {
		String body = this.restTemplate.getForObject("/softwares", String.class);
		log.info(body);
	}
}
