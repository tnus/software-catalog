package de.nuss.software.catalog.software;

import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;

import uk.co.blackpepper.bowman.Client;
import uk.co.blackpepper.bowman.ClientFactory;
import uk.co.blackpepper.bowman.Configuration;

public class SoftwareBowmanHalClient implements SoftwareHalClient {

	private Client<Software> client;

	public SoftwareBowmanHalClient(String baseUrl) {
		ClientFactory factory = Configuration.builder().setBaseUri(baseUrl).build().buildClientFactory();
		factory.create(Software.class);
	}

	@Override
	public PagedResources<Resource<Software>> findAll() {
		// return client.getAll();
		return null;
	}

	@Override
	public PagedResources<Resource<Software>> findAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource<Software> findOne(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource<Software> findByKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
