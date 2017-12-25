package de.nuss.software.catalog.software;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Component;

/**
 * This class provides access to the remote organisations
 * 
 * @author Thorsten Nuss
 *
 */
@Component
public class SoftwareClient {

	private SoftwareHalClient halClient;

	public SoftwareClient(SoftwareHalClient softwareHalClient) {
		this.halClient = softwareHalClient;
	}

	public Software findByKey(String key) {
		return halClient.findByKey(key).getContent();
	}

	public Collection<Software> findAll() {
		PagedResources<Resource<Software>> result = halClient.findAll(0, Integer.MAX_VALUE);
		List<Software> entities = new ArrayList<>();
		for (Resource<Software> resource : result) {
			entities.add(resource.getContent());
		}
		return entities;
	}

	public long count() {
		return halClient.findAll().getMetadata().getTotalElements();
	}

}
