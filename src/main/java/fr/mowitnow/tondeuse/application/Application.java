package fr.mowitnow.tondeuse.application;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {

	private static TondeuseExecutor executor = new TondeuseExecutor();

	public static void main(String[] args) throws FileNotFoundException, IOException {
		InstructionsFileParser InstFileParser = new InstructionsFileParser();
		InstFileParser.parseInstructionsFile();
	}

}
