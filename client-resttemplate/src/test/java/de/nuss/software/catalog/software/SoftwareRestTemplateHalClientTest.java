package de.nuss.software.catalog.software;

import static org.junit.Assert.assertTrue;

import java.util.Collections;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.hal.Jackson2HalModule;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Ignore
public class SoftwareRestTemplateHalClientTest {

	private SoftwareRestTemplateHalClient client;

	@Before
	public void setup() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.registerModule(new Jackson2HalModule());

		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(MediaType.parseMediaTypes("application/hal+json"));
		converter.setObjectMapper(mapper);

		RestTemplate restTemplate = new RestTemplate(Collections.<HttpMessageConverter<?>>singletonList(converter));

		client = new SoftwareRestTemplateHalClient(restTemplate, "http://localhost:8080");
		// client = new
		// OrganisationRestTemplateClient("http://localhost:8080/api");
	}

	@Test
	public void findAll() {
		PagedResources<Resource<Software>> result = client.findAll();
		assertTrue(result.getMetadata().getTotalElements() > 0);
		assertTrue(result.getContent().size() > 0);
		assertTrue(result.getLinks().size() > 0);

		log.info("content: {}", result.getContent());
		log.info("links: {}", result.getLinks());
	}
}
