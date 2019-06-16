package fr.mowitnow.tondeuse.model;

/**
 * Pelouse model
 * 
 * @author Yahya
 * @version 1.0.0
 */
public class PelouseModel {

	private PositionModel bottomLeftCornerPos = new PositionModel(0, 0);

	private PositionModel topRightCornerPos = null;

	public PelouseModel(PositionModel topRightCornerPos) {
		this.topRightCornerPos = topRightCornerPos;
	}

	public PositionModel getBottomLeftCornerPos() {
		return bottomLeftCornerPos;
	}

	public PositionModel getTopRightCornerPos() {
		return topRightCornerPos;
	}

}
