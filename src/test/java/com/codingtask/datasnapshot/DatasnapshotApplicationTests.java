package com.codingtask.datasnapshot;

import com.codingtask.datasnapshot.parser.ReconDataParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class DataSnapshotApplicationTests {
	@Test
	void contextLoads() {
	}

	@Test
	void testConvertCsvLineToObject() throws ParseException {
		String line = "Hey,World,From,2020-05-29 09:09:09";
		assertEquals("Hey",ReconDataParser.parse(line).getId());
	}

	@Test
	void testConvertBadCsvLineToObject() {
		String line = "Hey,World,From,2020-05-2909:09:09";
		assertThrows(ParseException.class,()->{
			ReconDataParser.parse(line);
		});
	}
}
