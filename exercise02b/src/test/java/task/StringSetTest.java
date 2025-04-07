package task;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class StringSetTest {

	@Test
	void testStringSet() {
		StringSet impl = new StringSetImpl();
		String str = "In Ulm um Ulm und um Ulm herum";

		for (String c : str.split("\\s")) {
			impl.add(c);
		}

		System.out.println(impl);

		// expect unique tokens: In Ulm und um herum
		assertEquals(5, impl.size());

		// check contains for various tokens
		assertTrue(impl.contains("In"));
		assertTrue(impl.contains("Ulm"));
		assertFalse(impl.contains(""));
		assertFalse(impl.contains("Mai"));

		// remove tokens and check if remove on non-existing token throws exception
		assertEquals("Ulm", impl.remove("Ulm"));
		assertEquals("um", impl.remove("um"));
		assertThrows(NoSuchElementException.class, () -> impl.remove("Mai"));

		assertEquals(3, impl.size());

		System.out.println(impl);

		// check contains of various tokens
		assertFalse(impl.contains("Ulm"));
		assertFalse(impl.contains("um"));
		assertFalse(impl.contains("Mai"));

		assertEquals("In", impl.remove("In"));
		assertEquals("und", impl.remove("und"));
		assertEquals("herum", impl.remove("herum"));

		assertEquals(0, impl.size());
	}
}