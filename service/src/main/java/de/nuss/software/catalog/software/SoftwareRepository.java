package de.nuss.software.catalog.software;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Exposes the person repository as rest resource
 * 
 * @author Thorsten Nuss
 *
 */
@Transactional
public interface SoftwareRepository extends PagingAndSortingRepository<Software, String>, JpaSpecificationExecutor,
		QueryDslPredicateExecutor<Software> {

	/**
	 * Returns the software with the given key.
	 * 
	 * @param key
	 *            key of the software to retrieve
	 * @return Software
	 */
	Software findByKey(String key);

}
