package fr.mowitnow.tondeuse.model;

import fr.mowitnow.tondeuse.enumeration.DirectionEnum;

/**
 * Position and direction model.
 * 
 * @author Yahya
 * @version 1.0.0
 */
public class PositionDirectionModel {

	/**
	 * Position model.
	 */
	private PositionModel positionModel;

	/**
	 * Current direction.
	 */
	private DirectionEnum direction;

	/**
	 * Constructor.
	 * 
	 * @param positionModel
	 *            position model
	 * @param direction
	 *            current direction
	 */
	public PositionDirectionModel(PositionModel positionModel, DirectionEnum direction) {
		this.positionModel = positionModel;
		this.direction = direction;
	}

	/**
	 * Returns position model.
	 * 
	 * @return position model
	 */
	public PositionModel getPositionModel() {
		return positionModel;
	}

	/**
	 * Returns current direction.
	 * 
	 * @return current direction
	 */
	public DirectionEnum getDirection() {
		return direction;
	}

}
