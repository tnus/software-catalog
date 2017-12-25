package de.nuss.software.catalog.software;

import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.web.client.RestTemplate;

//@Component
public class SoftwareRestTemplateHalClient implements SoftwareHalClient {

	private RestTemplate restTemplate;

	private String baseUrl;

	public SoftwareRestTemplateHalClient(RestTemplate restTemplate, String baseUrl) {
		this.restTemplate = restTemplate;
		this.baseUrl = baseUrl;
	}

	@Override
	public PagedResources<Resource<Software>> findAll() {
		PagedResources<Resource<Software>> result = restTemplate.getForObject(baseUrl + "/softwares",
				PagedResources.class);
		return result;
	}

	@Override
	public PagedResources<Resource<Software>> findAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resource<Software> findOne(String id) {
		Resource<Software> result = restTemplate.getForObject(baseUrl + "/organisations/" + id, Resource.class);
		return result;
	}

	@Override
	public Resource<Software> findByKey(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	// @Override
	// public PagedResources<Resource<Organisation>> findAll() {
	// PagedResources<Resource<Organisation>> result =
	// restTemplate.getForObject(baseUrl + "/organisations",
	// PagedResources.class);
	// return result;
	// }
	//
	// @Override
	// public Resource<Organisation> findByCimId(String cimId) {
	// // Resource<Organisation> result = restTemplate.getForObject(baseUrl +
	// // "/organisations/" + cimId, Resource.class);
	//
	// ResponseEntity<Resource<Organisation>> result2 =
	// restTemplate.exchange(baseUrl + "/organisations/" + cimId,
	// HttpMethod.GET, null, new
	// ParameterizedTypeReference<Resource<Organisation>>() {
	// });
	//
	// return result2.getBody();
	// }
	//
	// @Override
	// public Resources<Organisation> findRevisions(String cimId) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// public PagedResources<Resource<Organisation>> findAll(int page, int size) {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
