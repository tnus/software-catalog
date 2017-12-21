package de.nuss.software.catalog.software;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Entity
@Table(name = "SG_T_SOFTWARE")
@JsonInclude(Include.NON_EMPTY)
@Data
public class Software {

	/**
	 * Unique Software Number
	 */
	private String number;

	/**
	 * Name of this software
	 */
	private String name;

	/**
	 * Software description
	 */
	private String description;

	/**
	 * Link to the software
	 */
	private String url;
}
