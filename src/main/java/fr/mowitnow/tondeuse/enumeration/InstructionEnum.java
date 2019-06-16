package fr.mowitnow.tondeuse.enumeration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Instructions enum.
 * 
 * @author Yahya
 * @version 1.0.0
 */
public enum InstructionEnum {

	/**
	 * Rotate to right.
	 */
	D,

	/**
	 * Rotate to left.
	 */
	G,

	/**
	 * Go forward.
	 */
	A;

	/**
	 * Returns values as a string list.
	 * 
	 * @return values as a string list
	 */
	public static List<String> getValues() {
		return Stream.of(InstructionEnum.values()).map(InstructionEnum::name).collect(Collectors.toList());
	}

}
