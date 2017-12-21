package de.nuss.software.cataloque;

import java.time.ZonedDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping(path = "/")
	public String hello() {
		return "Hello World, " + ZonedDateTime.now();
	}
}
