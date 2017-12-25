package de.nuss.software.catalog.software;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import de.nuss.software.catalog.AbstractIntegrationTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class SoftwareRepositoryTest extends AbstractIntegrationTest {

	@Autowired
	private SoftwareRepository repository;

	@Test
	public void crud() {
		log.info("save software");
		Software software = new Software("SOF1", "Sample Software 1");
		Software saved = repository.save(software);
		assertEquals("SOF1", saved.getKey());

		saved.setDescription("Sample description for the software!");
		Software updated = repository.save(saved);
		assertNotNull(updated.getDescription());

		repository.delete(updated);

		Software deleted = repository.findOne(saved.getId());
		assertNull(deleted);
	}

	@Test
	public void count() {
		log.info("{} software entities are present!", repository.count());
		assertTrue(repository.count() > 0);
	}

	@Test
	public void findByKey() {
		Software software = repository.findByKey("TEST_DATA_SOFTWARE_1");
		assertNotNull(software);
	}

	/**
	 * Test if a software with duplicate key can be saved
	 */
	@Test
	public void saveDuplicateKey() {
		repository.save(new Software("duplicateKey", "Duplicate Key 1"));
		repository.save(new Software("duplicateKey", "Duplicate Key 2"));
	}
}
