package de.nuss.software.cataloque.software;

import lombok.Data;

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
