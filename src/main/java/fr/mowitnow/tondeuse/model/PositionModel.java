package fr.mowitnow.tondeuse.model;

import fr.mowitnow.tondeuse.enumeration.InstructionEnum;

/**
 * Position model.
 * 
 * @author Yahya
 * @version 1.0.0
 */
public class PositionModel {

	/**
	 * X abscissa.
	 */
	private int x;

	/**
	 * Y abscissa.
	 */
	private int y;

	/**
	 * Current direction.
	 */
	private InstructionEnum direction;

	/**
	 * Constructor.
	 * 
	 * @param x
	 *            abscissa
	 * @param y
	 *            abscissa
	 * @param direction
	 *            current direction
	 */
	public PositionModel(int x, int y, InstructionEnum direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
	}

	/**
	 * Returns x abscissa.
	 * 
	 * @return x abscissa
	 */
	public int getX() {
		return x;
	}

	/**
	 * Returns y abscissa.
	 * 
	 * @return y abscissa
	 */
	public int getY() {
		return y;
	}

	/**
	 * Returns current direction.
	 * 
	 * @return current direction
	 */
	public InstructionEnum getDirection() {
		return direction;
	}

}
