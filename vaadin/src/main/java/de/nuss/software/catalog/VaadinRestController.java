package de.nuss.software.catalog;

import java.time.ZonedDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VaadinRestController {

	@GetMapping(path = "/")
	public String hello() {
		return "Hello Vaadin, " + ZonedDateTime.now();
	}
}
