package fr.mowitnow.tondeuse.application;

import fr.mowitnow.tondeuse.enumeration.DirectionEnum;
import fr.mowitnow.tondeuse.enumeration.InstructionEnum;
import fr.mowitnow.tondeuse.model.PelouseModel;
import fr.mowitnow.tondeuse.model.PositionDirectionModel;
import fr.mowitnow.tondeuse.model.PositionModel;
import fr.mowitnow.tondeuse.model.TondeuseModel;

/**
 * Executes the "Todeuse"'s instructions.
 * 
 * @author Yahya
 * @version 1.0.0
 */
public class TondeuseExecutor {

	/**
	 * "Pelouse" model.
	 */
	private PelouseModel pelouseModel;

	/**
	 * "Tondeuse" model.
	 */
	private TondeuseModel tondeuseModel;


	/**
	 * Constructor.
	 * 
	 * @param pelouseModel
	 *            "Pelouse" model
	 * @param tondeuseModel
	 *            "Tondeuse" model
	 */
	public TondeuseExecutor(PelouseModel pelouseModel, TondeuseModel tondeuseModel) {
		this.pelouseModel = pelouseModel;
		this.tondeuseModel = tondeuseModel;
	}

	/**
	 * Executes the next instruction.
	 * 
	 * @return current {@link PositionDirectionModel} after executing
	 *         instruction
	 */
	public PositionDirectionModel executeNextInstruction() {
		PositionDirectionModel currentPositionDirection = tondeuseModel.getCurrentPositionDirection();
		InstructionEnum instruction = tondeuseModel.getNextInstruction();
		switch (instruction) {
		case D:
			return new PositionDirectionModel(currentPositionDirection.getPositionModel(),
					rotateTondeuseToRight(currentPositionDirection.getDirection()));
		case G:
			return new PositionDirectionModel(currentPositionDirection.getPositionModel(),
					rotateTondeuseToLeft(currentPositionDirection.getDirection()));
		case A:
			PositionModel newPosition = moveTondeuse(currentPositionDirection);
			if (newPosition != null) {
				return new PositionDirectionModel(newPosition, currentPositionDirection.getDirection());
			}
		}
		return currentPositionDirection;

	}

	/**
	 * Execute all instructions.
	 */
	public void executeInstructions() {
		PositionDirectionModel newPositionDirectionModel = null;
		while (tondeuseModel.hasInstruction()) {
			newPositionDirectionModel = executeNextInstruction();
			if (newPositionDirectionModel != null) {
				tondeuseModel.setCurrentPositionDirection(newPositionDirectionModel);
			}
		}
		tondeuseModel.setFinalPosition(tondeuseModel.getCurrentPositionDirection());
	}

	private DirectionEnum rotateTondeuseToRight(DirectionEnum currentDirection) {
		switch (currentDirection) {
		case N:
			return DirectionEnum.E;
		case E:
			return DirectionEnum.S;
		case S:
			return DirectionEnum.W;
		case W:
			return DirectionEnum.N;
		}
		return currentDirection;
	}

	private DirectionEnum rotateTondeuseToLeft(DirectionEnum currentDirection) {
		switch (currentDirection) {
		case N:
			return DirectionEnum.W;
		case W:
			return DirectionEnum.S;
		case S:
			return DirectionEnum.E;
		case E:
			return DirectionEnum.N;
		}
		return currentDirection;
	}

	private PositionModel moveTondeuse(PositionDirectionModel currentPositionDirection) {
		PositionModel currentPosition = currentPositionDirection.getPositionModel();
		PositionModel newPosition = null;
		switch (currentPositionDirection.getDirection()) {
		case N:
			if (currentPosition.getY() < pelouseModel.getTopRightCornerPos().getY()) {
				newPosition = new PositionModel(currentPosition.getX(), currentPosition.getY() + 1);
			}
			break;
		case W:
			if (currentPosition.getX() > pelouseModel.getBottomLeftCornerPos().getX()) {
				newPosition = new PositionModel(currentPosition.getX() - 1, currentPosition.getY());
			}
			break;
		case S:
			if (currentPosition.getY() > pelouseModel.getBottomLeftCornerPos().getY()) {
				newPosition = new PositionModel(currentPosition.getX(), currentPosition.getY() - 1);
			}
			break;
		case E:
			if (currentPosition.getX() < pelouseModel.getTopRightCornerPos().getX()) {
				newPosition = new PositionModel(currentPosition.getX() + 1, currentPosition.getY());
			}
			break;
		}
		return newPosition;
	}

	/**
	 * Sets the "Tondeuse" model.
	 * 
	 * @param tondeuseModel
	 *            "Tondeuse" model
	 */
	public void setTondeuseModel(TondeuseModel tondeuseModel) {
		this.tondeuseModel = tondeuseModel;
	}

}
