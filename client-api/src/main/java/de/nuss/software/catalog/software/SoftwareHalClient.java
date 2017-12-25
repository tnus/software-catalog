package de.nuss.software.catalog.software;

import org.springframework.hateoas.Resource;

/**
 * This interface defines the client methods. It uses hal as representation
 * 
 * @author Thorsten Nuss
 *
 */
public interface SoftwareHalClient extends AbstractHalClient<Software> {

	Resource<Software> findByKey(String key);

}
