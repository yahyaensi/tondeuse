package fr.mowitnow.tondeuse.application;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import org.junit.Before;
import org.junit.Test;

import fr.mowitnow.tondeuse.enumeration.DirectionEnum;
import fr.mowitnow.tondeuse.enumeration.InstructionEnum;
import fr.mowitnow.tondeuse.model.PelouseModel;
import fr.mowitnow.tondeuse.model.PositionDirectionModel;
import fr.mowitnow.tondeuse.model.PositionModel;
import fr.mowitnow.tondeuse.model.TondeuseModel;

public class TondeuseExecutorTest {

	private TondeuseExecutor tondeuseExecutor = null;

	private PelouseModel pelouseModel = null;

	private TondeuseModel tondeuseModel = null;

	@Before
	public void setup() throws IOException, URISyntaxException {
		pelouseModel = new PelouseModel(new PositionModel(5, 5));
	}

	@Test
	public void rotate_tondeuse_to_left() {
		Deque<InstructionEnum> instructionDeque = new ArrayDeque<>(Arrays.asList(InstructionEnum.G));
		tondeuseModel = new TondeuseModel(new PositionDirectionModel(new PositionModel(0, 0), DirectionEnum.N),
				instructionDeque);
		tondeuseExecutor = new TondeuseExecutor(pelouseModel, tondeuseModel);
		tondeuseExecutor.executeInstructions();
		assertEquals("x coordinate shouldn't change", 0,
				tondeuseModel.getFinalPositionDirection().getPositionModel().getX());
		assertEquals("y coordinate shouldn't change", 0,
				tondeuseModel.getFinalPositionDirection().getPositionModel().getY());
		assertEquals("direction should be west", DirectionEnum.W,
				tondeuseModel.getFinalPositionDirection().getDirection());
	}

	@Test
	public void rotate_tondeuse_to_rigt() {
		Deque<InstructionEnum> instructionDeque = new ArrayDeque<>(Arrays.asList(InstructionEnum.D));
		tondeuseModel = new TondeuseModel(new PositionDirectionModel(new PositionModel(0, 0), DirectionEnum.N),
				instructionDeque);
		tondeuseExecutor = new TondeuseExecutor(pelouseModel, tondeuseModel);
		tondeuseExecutor.executeInstructions();
		assertEquals("x coordinate shouldn't change", 0,
				tondeuseModel.getFinalPositionDirection().getPositionModel().getX());
		assertEquals("y coordinate shouldn't change", 0,
				tondeuseModel.getFinalPositionDirection().getPositionModel().getY());
		assertEquals("direction should be east", DirectionEnum.E,
				tondeuseModel.getFinalPositionDirection().getDirection());
	}

	@Test
	public void move_tondeuse_forward_to_north() {
		move_tondeuse_forward(DirectionEnum.N, 2, 2);
		assertEquals("x coordinate shouldn't change", 2,
				tondeuseModel.getFinalPositionDirection().getPositionModel().getX());
		assertEquals("y coordinate shouldn change", 3,
				tondeuseModel.getFinalPositionDirection().getPositionModel().getY());
		assertEquals("direction should be west", DirectionEnum.N,
				tondeuseModel.getFinalPositionDirection().getDirection());
	}

	@Test
	public void move_tondeuse_forward_to_east() {
		move_tondeuse_forward(DirectionEnum.E, 2, 2);
		assertEquals("x coordinate should change", 3,
				tondeuseModel.getFinalPositionDirection().getPositionModel().getX());
		assertEquals("y coordinate shouldn't change", 2,
				tondeuseModel.getFinalPositionDirection().getPositionModel().getY());
		assertEquals("direction should be west", DirectionEnum.E,
				tondeuseModel.getFinalPositionDirection().getDirection());
	}

	@Test
	public void move_tondeuse_forward_to_west() {
		move_tondeuse_forward(DirectionEnum.W, 2, 2);
		assertEquals("x coordinate should change", 1,
				tondeuseModel.getFinalPositionDirection().getPositionModel().getX());
		assertEquals("y coordinate shouldn't change", 2,
				tondeuseModel.getFinalPositionDirection().getPositionModel().getY());
		assertEquals("direction should be west", DirectionEnum.W,
				tondeuseModel.getFinalPositionDirection().getDirection());
	}

	@Test
	public void move_tondeuse_forward_to_south() {
		move_tondeuse_forward(DirectionEnum.S, 2, 2);
		assertEquals("x coordinate should't change", 2,
				tondeuseModel.getFinalPositionDirection().getPositionModel().getX());
		assertEquals("y coordinate should change", 1,
				tondeuseModel.getFinalPositionDirection().getPositionModel().getY());
		assertEquals("direction should be south", DirectionEnum.S,
				tondeuseModel.getFinalPositionDirection().getDirection());
	}

	@Test
	public void ignore_move_instruction_if_next_move_to_north_is_outside_pelouse() {
		ignore_move_instruction_if_next_move_is_outside_pelouse_generic_test(DirectionEnum.N, 0, 5);
	}

	@Test
	public void ignore_move_instruction_if_next_move_to_south_is_outside_pelouse() {
		ignore_move_instruction_if_next_move_is_outside_pelouse_generic_test(DirectionEnum.S, 0, 0);
	}

	@Test
	public void ignore_move_instruction_if_next_move_to_east_is_outside_pelouse() {
		ignore_move_instruction_if_next_move_is_outside_pelouse_generic_test(DirectionEnum.E, 5, 0);
	}

	@Test
	public void ignore_move_instruction_if_next_move_to_west_is_outside_pelouse() {
		ignore_move_instruction_if_next_move_is_outside_pelouse_generic_test(DirectionEnum.W, 0, 0);
	}

	@Test
	public void move_tondeuse_to_final_position_first_case() {
		Deque<InstructionEnum> instructionDeque = new ArrayDeque<>(
				Arrays.asList(InstructionEnum.G, InstructionEnum.A, InstructionEnum.G, InstructionEnum.A,
						InstructionEnum.G, InstructionEnum.A, InstructionEnum.G, InstructionEnum.A, InstructionEnum.A));
		tondeuseModel = new TondeuseModel(new PositionDirectionModel(new PositionModel(1, 2), DirectionEnum.N),
				instructionDeque);
		tondeuseExecutor = new TondeuseExecutor(pelouseModel, tondeuseModel);
		tondeuseExecutor.executeInstructions();
		assertEquals("x coordinate should be 1", 1,
				tondeuseModel.getFinalPositionDirection().getPositionModel().getX());
		assertEquals("y coordinate should be 3", 3,
				tondeuseModel.getFinalPositionDirection().getPositionModel().getY());
		assertEquals("direction should be north", DirectionEnum.N,
				tondeuseModel.getFinalPositionDirection().getDirection());
	}

	@Test
	public void move_tondeuse_to_final_position_second_case() {
		Deque<InstructionEnum> instructionDeque = new ArrayDeque<>(Arrays.asList(InstructionEnum.A, InstructionEnum.A,
				InstructionEnum.D, InstructionEnum.A, InstructionEnum.A, InstructionEnum.D, InstructionEnum.A,
				InstructionEnum.D, InstructionEnum.D, InstructionEnum.A));
		tondeuseModel = new TondeuseModel(new PositionDirectionModel(new PositionModel(3, 3), DirectionEnum.E),
				instructionDeque);
		tondeuseExecutor = new TondeuseExecutor(pelouseModel, tondeuseModel);
		tondeuseExecutor.executeInstructions();
		assertEquals("x coordinate should be 5", 5,
				tondeuseModel.getFinalPositionDirection().getPositionModel().getX());
		assertEquals("y coordinate should be 1", 1,
				tondeuseModel.getFinalPositionDirection().getPositionModel().getY());
		assertEquals("direction should be east", DirectionEnum.E,
				tondeuseModel.getFinalPositionDirection().getDirection());
	}

	private void move_tondeuse_forward(DirectionEnum initialDirection, int initialX, int initialY) {
		Deque<InstructionEnum> instructionDeque = new ArrayDeque<>(Arrays.asList(InstructionEnum.A));
		tondeuseModel = new TondeuseModel(
				new PositionDirectionModel(new PositionModel(initialX, initialY), initialDirection), instructionDeque);
		tondeuseExecutor = new TondeuseExecutor(pelouseModel, tondeuseModel);
		tondeuseExecutor.executeInstructions();
	}

	private void ignore_move_instruction_if_next_move_is_outside_pelouse_generic_test(DirectionEnum initialDirection,
			int initialX, int initialY) {
		Deque<InstructionEnum> instructionDeque = new ArrayDeque<>(Arrays.asList(InstructionEnum.A));
		tondeuseModel = new TondeuseModel(
				new PositionDirectionModel(new PositionModel(initialX, initialY), initialDirection), instructionDeque);
		tondeuseExecutor = new TondeuseExecutor(pelouseModel, tondeuseModel);
		tondeuseExecutor.executeInstructions();
		assertEquals("x coordinate shouldn't change", initialX,
				tondeuseModel.getFinalPositionDirection().getPositionModel().getX());
		assertEquals("y coordinate shouldn't change", initialY,
				tondeuseModel.getFinalPositionDirection().getPositionModel().getY());
		assertEquals("direction shouldn't change", initialDirection,
				tondeuseModel.getFinalPositionDirection().getDirection());

	}

}
