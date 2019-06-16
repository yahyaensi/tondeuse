package fr.mowitnow.tondeuse.application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.javatuples.Pair;

import fr.mowitnow.tondeuse.model.PelouseModel;
import fr.mowitnow.tondeuse.model.PositionDirectionModel;
import fr.mowitnow.tondeuse.model.TondeuseModel;

public class Application {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File instructionsFile = new File(Application.class.getClassLoader().getResource("instructions.txt").getFile());
		Pair<PelouseModel, List<TondeuseModel>> modelPair = InstructionsFileParser
				.parseInstructionsFile(instructionsFile);
		PelouseModel pelouseModel = modelPair.getValue0();
		List<TondeuseModel> tondeuseModelList = modelPair.getValue1();
		List<PositionDirectionModel> tondeuseFinalPositionList = new ArrayList<>();
		tondeuseModelList.forEach(tondeuseModel -> {
			TondeuseExecutor executor = new TondeuseExecutor(pelouseModel, tondeuseModel);
			tondeuseFinalPositionList.add(executor.executeInstructions());
		});

		tondeuseFinalPositionList.forEach(System.out::println);

	}

}
