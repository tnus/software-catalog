package de.nuss.software.catalog.bootstrap;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import de.nuss.software.catalog.software.Software;
import de.nuss.software.catalog.software.SoftwareRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TestDataApplicationRunner implements ApplicationRunner {

	@Autowired
	private SoftwareRepository softwareRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("create test data");

		IntStream.range(0, 10).parallel().forEach(i -> {
			log.info("create software {}", i);
			Software software = new Software("TEST_DATA_SOFTWARE_" + i, "Test Data Software " + i);
			softwareRepository.save(software);
		});

	}

}
