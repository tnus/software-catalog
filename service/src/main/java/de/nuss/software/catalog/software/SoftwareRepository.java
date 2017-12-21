package de.nuss.software.catalog.software;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Exposes the person repository as rest resource
 * 
 * @author Thorsten Nuss
 *
 */
public interface SoftwareRepository extends PagingAndSortingRepository<Software, String>, JpaSpecificationExecutor,
		QueryDslPredicateExecutor<Software> {

}
