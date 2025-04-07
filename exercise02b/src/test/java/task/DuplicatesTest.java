package task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static task.Duplicates.findDuplicates;

class DuplicatesTest {
	@Test
	void testFindDuplicates() {

		String t1 = "In Ulm! und um Ulm! und um Ulm herum!";

		StringSet s1 = findDuplicates(t1);
		System.out.println(s1);

		assertEquals(3, s1.size());  // Ulm und um
		assertTrue(s1.contains("Ulm"));
		assertTrue(s1.contains("und"));
		assertTrue(s1.contains("um"));
		assertFalse(s1.contains("In"));
		assertFalse(s1.contains("herum"));
		assertFalse(s1.contains("Ulm!"));  // keine Satzzeichen!

		String t2 = "An aristocratic monkey";
		StringSet s2 = findDuplicates(t2);

		assertEquals(0, s2.size());

		String t3 = "Wenn Fliegen hinter Fliegen fliegen?";
		StringSet s3 = findDuplicates(t3);

		assertEquals(1, s3.size());
		assertTrue(s3.contains("Fliegen"));
		assertFalse(s3.contains("fliegen"));
	}
}