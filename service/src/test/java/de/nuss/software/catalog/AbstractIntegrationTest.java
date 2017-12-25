package de.nuss.software.catalog;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * This class is the base class for all integration tests. It starts the spring
 * boot context
 * 
 * @author Thorsten Nuss
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
@TestPropertySource(locations = "classpath:application-test.properties")
public abstract class AbstractIntegrationTest {

}
