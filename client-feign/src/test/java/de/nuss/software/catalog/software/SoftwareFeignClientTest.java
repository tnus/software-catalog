package de.nuss.software.catalog.software;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.hateoas.PagedResources;

import de.nuss.software.catalog.AbstractClientTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Ignore
public class SoftwareFeignClientTest extends AbstractClientTest {

	private SoftwareFeignClient client;

	@Before
	public void setUp() throws Exception {
		client = context.getBean(SoftwareFeignClient.class);
	}

	@Test
	public void findAll() {
		PagedResources<?> result = client.findAll();

		log.debug("total elements: {}", result.getMetadata().getTotalElements());
		log.debug("content elements: {}", result.getContent().size());
		assertTrue(result.getMetadata().getTotalElements() > 0);
		assertTrue(result.getContent().size() > 0);

		log.debug("first entry: {}", result.getContent().iterator().next());
	}

}
