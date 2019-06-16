package fr.mowitnow.tondeuse.model;

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
	 * Constructor.
	 * 
	 * @param x
	 *            abscissa
	 * @param y
	 *            abscissa
	 */
	public PositionModel(int x, int y) {
		this.x = x;
		this.y = y;
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

}
