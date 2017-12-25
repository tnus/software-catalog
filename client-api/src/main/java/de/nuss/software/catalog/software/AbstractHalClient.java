package de.nuss.software.catalog.software;

import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;

public interface AbstractHalClient<E> {

	PagedResources<Resource<E>> findAll();

	PagedResources<Resource<E>> findAll(int page, int size);

	Resource<E> findOne(String id);

}
