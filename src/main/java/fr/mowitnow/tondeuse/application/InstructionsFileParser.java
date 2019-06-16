package fr.mowitnow.tondeuse.application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

import fr.mowitnow.tondeuse.enumeration.DirectionEnum;
import fr.mowitnow.tondeuse.enumeration.InstructionEnum;
import fr.mowitnow.tondeuse.model.PositionDirectionModel;
import fr.mowitnow.tondeuse.model.PositionModel;
import fr.mowitnow.tondeuse.model.TondeuseModel;

/**
 * The processor that reads the instructions file and transforms its content to
 * a model.
 * 
 * @author Yahya
 * @version 1.0.0
 * 
 */
public class InstructionsFileParser {

	private PositionModel topRightCornerPosition = null;;

	private List<TondeuseModel> tondeuseModelList = new ArrayList<>();

	public final void parseInstructionsFile() throws FileNotFoundException, IOException {
		File instructionsFile = new File(Application.class.getClassLoader().getResource("instructions.txt").getFile());
		try (BufferedReader br = new BufferedReader(new FileReader(instructionsFile))) {
			// Get top right corner coordinates.
			String topRightCornerCoordinatesLine = br.readLine();
			int[] topRightCornerCoordinates = Arrays.stream(topRightCornerCoordinatesLine.trim().split(" "))
					.mapToInt(Integer::parseInt).toArray();
			topRightCornerPosition = new PositionModel(topRightCornerCoordinates[0], topRightCornerCoordinates[1]);

			// Build the "Tondeuse" models.
			String initialPosDirLine, instructionLine;
			while ((initialPosDirLine = br.readLine()) != null && (instructionLine = br.readLine()) != null) {
				String[] initialCoordinates = initialPosDirLine.trim().split(" ");
				PositionModel initialPositionModel = new PositionModel(Integer.valueOf(initialCoordinates[0]),
						Integer.valueOf(initialCoordinates[1]));
				PositionDirectionModel initialPositionDirection = new PositionDirectionModel(initialPositionModel,
						DirectionEnum.valueOf(initialCoordinates[2]));

				List<InstructionEnum> instructionList = Arrays.stream(instructionLine.trim().split(""))
						.map(instStr -> InstructionEnum.valueOf(instStr)).collect(Collectors.toList());
				Deque<InstructionEnum> instructionDeque = new ArrayDeque<>(instructionList);
				TondeuseModel tondeuseModel = new TondeuseModel(initialPositionDirection, instructionDeque);
				tondeuseModelList.add(tondeuseModel);
			}
		}
	}

	public PositionModel getTopRightCornerPosition() {
		return topRightCornerPosition;
	}

	public List<TondeuseModel> getTondeuseModelList() {
		return tondeuseModelList;
	}

}
