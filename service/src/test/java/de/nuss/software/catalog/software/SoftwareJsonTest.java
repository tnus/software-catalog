package de.nuss.software.catalog.software;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@JsonTest
@Ignore
public class SoftwareJsonTest {

	@Autowired
	private JacksonTester<Software> json;

	@Test
	public void testSerialize() throws Exception {
		Software software = new Software("key1", "Software 1");
		// Assert against a `.json` file in the same package as the test
		// assertThat(this.json.write(software)).isEqualToJson("expected.json");
		// Or use JSON path based assertions
		assertThat(this.json.write(software)).hasJsonPathStringValue("@.key");
		assertThat(this.json.write(software)).extractingJsonPathStringValue("@.make").isEqualTo("key1");
	}
	//
	// @Test
	// public void testDeserialize() throws Exception {
	// String content = "{\"make\":\"Ford\",\"model\":\"Focus\"}";
	// assertThat(this.json.parse(content)).isEqualTo(new VehicleDetails("Ford",
	// "Focus"));
	// assertThat(this.json.parseObject(content).getMake()).isEqualTo("Ford");
	// }
}
