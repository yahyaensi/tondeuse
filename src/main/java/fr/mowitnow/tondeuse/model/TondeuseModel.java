package fr.mowitnow.tondeuse.model;

import java.util.Deque;
import java.util.List;

import fr.mowitnow.tondeuse.enumeration.InstructionEnum;

/**
 * Model of the "Tondeuse".
 * 
 * @author Yahya
 * @version 1.0.0
 */
public class TondeuseModel {

	/**
	 * Initial position of the "Tondeuse".
	 */
	private PositionModel initialPosition;

	/**
	 * Instructions chain that the "Tondeuse" should do.
	 */
	private Deque<InstructionEnum> instructionDeque;

	/**
	 * Final position of the "Tondeuse".
	 */
	private PositionModel finalPosition;

	/**
	 * Constructor.
	 * 
	 * @param initialPosition
	 *            Initial position of the "Tondeuse"
	 * @param instructionChain
	 *            Instructions chain that the "Tondeuse" should do
	 */
	public TondeuseModel(PositionModel initialPosition, List<String> instructionChain) {
		this.initialPosition = initialPosition;
		// this.instructionChain = instructionChain;
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
	 * Returns the initial position of the "Tondeuse".
	 * 
	 * @return
	 */
	public PositionModel getInitialPosition() {
		return initialPosition;
	}

	/**
	 * Returns the final position of the "Tondeuse".
	 * 
	 * @return the final {@link PositionModel} of the "Tondeuse"
	 */
	public PositionModel getFinalPosition() {
		return finalPosition;
	}

	/**
	 * Sets the final position of the "Tondeuse"
	 * 
	 * @param finalPosition
	 *            final position
	 */
	public void setFinalPosition(PositionModel finalPosition) {
		this.finalPosition = finalPosition;
	}

}
