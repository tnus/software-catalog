package de.nuss.software.catalog.software;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import de.nuss.software.catalog.AbstractClientTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SoftwareClientTest extends AbstractClientTest {

	private static SoftwareClient client;

	@Before
	public void setUp() throws Exception {
		SoftwareFeignClient feignClient = context.getBean(SoftwareFeignClient.class);
		client = new SoftwareClient(feignClient);
	}

	@Test
	public void findAll() {
		Collection<Software> result = client.findAll();
		assertTrue(result.size() > 0);
		log.info("{} organisations found", result.size());
	}

	@Test
	public void count() {
		long count = client.count();
		assertTrue(count > 0);
		log.info("{} organisations found", count);
	}
}
