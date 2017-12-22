package de.nuss.software.catalog.software;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "SG_T_SOFTWARE")
@JsonInclude(Include.NON_EMPTY)
@Data
@NoArgsConstructor
public class Software {

	/** The id. */
	@Id
	@Column(name = "C_ID")
	private String id;

	/**
	 * Unique Software Key
	 */
	@Column(name = "C_KEY")
	private String key;

	/**
	 * Name of this software
	 */
	@Column(name = "C_NAME")
	private String name;

	/**
	 * Software description
	 */
	@Column(name = "C_DESCRIPTION")
	private String description;

	/**
	 * Link to the software
	 */
	@Column(name = "C_URL")
	private String url;

	public Software(String key, String name) {
		super();
		this.id = key;
		this.key = key;
		this.name = name;
	}

}
