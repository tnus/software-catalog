package de.nuss.software.catalog.software;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(Include.NON_EMPTY)
@Data
@NoArgsConstructor
public class Software {

	/**
	 * Unique Software Key
	 */
	private String key;

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

	public Software(String key, String name) {
		super();
		this.key = key;
		this.name = name;
	}

}
