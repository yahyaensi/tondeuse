package fr.mowitnow.tondeuse.model;

import java.util.Deque;

import fr.mowitnow.tondeuse.enumeration.InstructionEnum;

/**
 * Model of the "Tondeuse".
 * 
 * @author Yahya
 * @version 1.0.0
 */
public class TondeuseModel {

	/**
	 * Initial position and direction of the "Tondeuse".
	 */
	private PositionDirectionModel initialPositionDirection;

	/**
	 * current position and direction of the "Tondeuse".
	 */
	private PositionDirectionModel currentPositionDirection;

	/**
	 * Instructions chain that the "Tondeuse" should do.
	 */
	private Deque<InstructionEnum> instructionDeque;

	/**
	 * Final position and direction of the "Tondeuse".
	 */
	private PositionDirectionModel finalPositionDirection;

	/**
	 * Constructor.
	 * 
	 * @param initialPositionDirection
	 *            Initial position and direction of the "Tondeuse"
	 * @param instructionDeque
	 *            Instructions that the "Tondeuse" should do
	 */
	public TondeuseModel(PositionDirectionModel initialPositionDirection, Deque<InstructionEnum> instructionDeque) {
		this.initialPositionDirection = initialPositionDirection;
		this.currentPositionDirection = initialPositionDirection;
		this.instructionDeque = instructionDeque;
	}

	/**
	 * Returns the next instruction to execute.
	 * 
	 * @return the next instruction {@link InstructionEnum} to execute
	 */
	public InstructionEnum getNextInstruction() {
		return instructionDeque.pop();
	}

	/**
	 * Returns <code>true</code> if there is still instructions to execute,
	 * <ode>false</code> otherwise.
	 * 
	 * @return <code>true</code> if there is still instructions to execute,
	 *         <ode>false</code> otherwise
	 */
	public boolean hasInstruction() {
		return !instructionDeque.isEmpty();
	}

	/**
	 * Returns the initial position and direction of the "Tondeuse".
	 * 
	 * @return the initial position and direction of the "Tondeuse".
	 */
	public PositionDirectionModel getInitialPositionDirection() {
		return initialPositionDirection;
	}

	/**
	 * Returns the current position and direction of the "Tondeuse".
	 * 
	 * @return the current position and direction of the "Tondeuse".
	 */
	public PositionDirectionModel getCurrentPositionDirection() {
		return currentPositionDirection;
	}

	/**
	 * Sets the current position and direction of the "Tondeuse"
	 * 
	 * @param currentPositionDirection
	 *            current position and direction
	 */
	public void setCurrentPositionDirection(PositionDirectionModel currentPositionDirection) {
		this.currentPositionDirection = currentPositionDirection;
	}

	/**
	 * Returns the final position and direction of the "Tondeuse".
	 * 
	 * @return the final {@link PositionModel} of the "Tondeuse"
	 */
	public PositionDirectionModel getFinalPositionDirection() {
		return finalPositionDirection;
	}

	/**
	 * Sets the final position and direction of the "Tondeuse"
	 * 
	 * @param finalPositionDirection
	 *            final position and direction
	 */
	public void setFinalPosition(PositionDirectionModel finalPositionDirection) {
		this.finalPositionDirection = finalPositionDirection;
	}

}
