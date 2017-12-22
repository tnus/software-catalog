package de.nuss.software.catalog.software;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import de.nuss.software.catalog.AbstractIntegrationTest;

public class SoftwareRepositoryTest extends AbstractIntegrationTest {

	@Autowired
	private SoftwareRepository repository;

	@Test
	public void crud() {
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
}
