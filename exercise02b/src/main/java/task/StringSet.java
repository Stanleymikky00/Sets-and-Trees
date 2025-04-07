package task;

import java.util.NoSuchElementException;

interface StringSet {
	/**
	 * Adds a string to the set
	 * @param s The string to add
	 * @return true if string was successfully added (did not exist yet), or false if the set
	 * 			already contained the string s
	 */
	boolean add(String s);

	/**
	 * Checks whether string s is already contained in set
	 */
	boolean contains(String s);

	/**
	 * Removes an Element s from the set;
	 * Throws a NoSuchElementException if the element s does not exist in the set
	 *
	 * @return The Element to be removed
	 * @throws NoSuchElementException If the Element s does not exist
	 */
	String remove(String s) throws NoSuchElementException;

	/**
	 * Return size of set
	 */
	int size();
}
