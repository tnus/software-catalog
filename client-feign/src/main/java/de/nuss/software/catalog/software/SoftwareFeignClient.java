package de.nuss.software.catalog.software;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import feign.Headers;

//@FeignClient(name = SoftwareFeignClient.SERVICE_NAME, url = "${software-catalog.client.url}", path = "/softwares")
@FeignClient(name = SoftwareFeignClient.SERVICE_NAME, url = "http://localhost:8080")
@Headers("Accept: application/hal+json")
public interface SoftwareFeignClient extends SoftwareHalClient {

	public static final String SERVICE_NAME = "software-service";

	// @RequestLine("GET /softwares")
	@RequestMapping(method = RequestMethod.GET, value = "/softwares")
	PagedResources<Resource<Software>> findAll();

	// @RequestLine("GET /softwares?page={page}&size={size}")
	@RequestMapping(method = RequestMethod.GET, value = "/softwares")
	PagedResources<Resource<Software>> findAll(@RequestParam("page") int page, @RequestParam("size") int size);

	@Override
	@RequestMapping(method = RequestMethod.GET, value = "/softwares/{id}")
	Resource<Software> findOne(String id);

}
