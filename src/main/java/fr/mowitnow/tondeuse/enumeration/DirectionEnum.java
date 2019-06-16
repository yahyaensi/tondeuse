package fr.mowitnow.tondeuse.enumeration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Direstions enum.
 * 
 * @author Yahya
 * @version 1.0.0
 */
public enum DirectionEnum {
	
	/**
	 * North.
	 */
	N,
	
	/**
	 * East.
	 */
	E,
	
	/**
	 * South.
	 */
	S,
	
	/**
	 * West
	 */
	W;
	
	/**
	 * Returns values as a string list.
	 * 
	 * @return values as a string list
	 */
	public static List<String> getValues() {
		return Stream.of(DirectionEnum.values()).map(DirectionEnum::name).collect(Collectors.toList());
	}

}
