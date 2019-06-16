package fr.mowitnow.tondeuse.application;

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
	 * "Tondeuse" model.
	 */
	private TondeuseModel tondeuseModel;
	
	/**
	 * No args constructor.
	 */
	public TondeuseExecutor() {}

	/**
	 * Constructor.
	 * 
	 * @param tondeuseModel
	 *            "Tondeuse" model
	 */
	public TondeuseExecutor(TondeuseModel tondeuseModel) {
		this.tondeuseModel = tondeuseModel;
	}

	/**
	 * Executes the next instruction.
	 * 
	 * @return current {@link PositionModel} after executing instruction
	 */
	public PositionModel executeNextInstruction() {

		return null;
	}

	/**
	 * Execute all instructions.
	 */
	public void executeInstructions() {
	}

	/**
	 * Sets the "Tondeuse" model.
	 * 
	 * @param tondeuseModel "Tondeuse" model
	 */
	public void setTondeuseModel(TondeuseModel tondeuseModel) {
		this.tondeuseModel = tondeuseModel;
	}
	
	
}
