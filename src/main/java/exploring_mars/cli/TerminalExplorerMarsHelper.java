package exploring_mars.cli;

import exploring_mars.core.Direction;
import exploring_mars.core.ExploringMarsException;
import exploring_mars.core.RocketCoordinate;

public class TerminalExplorerMarsHelper {

	private StdReader stdReader;

	public TerminalExplorerMarsHelper(StdReader stdReader) {
		this.stdReader = stdReader;
	}

	public Boundaries readBoundaries() throws ExploringMarsException {

		System.out.println("Inform mars boundaries (X Y)");

		int x;
		int y;
		String[] boundaries;

		try {
			String boundariesLine = stdReader.readLine().trim();
			boundaries = boundariesLine.split(" ");

			x = Integer.parseInt(boundaries[0]);
			y = Integer.parseInt(boundaries[1]);
		} catch (Exception e) {
			throw new ExploringMarsException("Invalid boundaires.");
		}

		if (boundaries.length > 2)
			throw new ExploringMarsException("Invalid boundaires.");

		return new Boundaries(x, y);
	}

	public RocketCoordinate readRocketCoordinates() throws ExploringMarsException {

		System.out.println("Inform rocket coordinate (X Y D)");

		int x;
		int y;
		Direction direction;
		String strDirection;

		try {
			String coordinatesLine = stdReader.readLine().trim();
			String[] coordinates = coordinatesLine.split(" ");

			x = Integer.parseInt(coordinates[0]);
			y = Integer.parseInt(coordinates[1]);
			strDirection = coordinates[2];
		} catch (Exception e) {
			throw new ExploringMarsException("Invalid coordinates.");
		}
		
		if (strDirection.equalsIgnoreCase("N"))
			direction = Direction.North;
		else if (strDirection.equalsIgnoreCase("W"))
			direction = Direction.West;
		else if (strDirection.equalsIgnoreCase("S"))
			direction = Direction.South;
		else if (strDirection.equalsIgnoreCase("E"))
			direction = Direction.East;
		else
			throw new ExploringMarsException("Invalid coordinates.");
		
		return new RocketCoordinate(x, y, direction);
	}

}
