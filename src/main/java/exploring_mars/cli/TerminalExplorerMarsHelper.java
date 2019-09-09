package exploring_mars.cli;

import java.util.ArrayList;
import java.util.List;

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

	public List<Move> readMoves() throws ExploringMarsException {

		System.out.println("Inform movements [L|R|M]");

		List<Move> moves = new ArrayList<Move>();

		String movesLine = stdReader.readLine().trim();

		for (int i = 0; i < movesLine.length(); i++) {
			char c = movesLine.charAt(i);

			if ("L".equalsIgnoreCase(Character.toString(c)))
				moves.add(Move.Left);
			else if ("R".equalsIgnoreCase(Character.toString(c)))
				moves.add(Move.Right);
			else if ("M".equalsIgnoreCase(Character.toString(c)))
				moves.add(Move.Forward);
			else
				throw new ExploringMarsException("Invalid moves.");
		}

		return moves;
	}
	
	public boolean readTryAgain() throws ExploringMarsException {
		
		System.out.println("Try one more rocket? (y/n)");
		
		String tryAgatin = stdReader.readLine().trim();
		
		if (tryAgatin.equalsIgnoreCase("Y"))
			return true;
		else if (tryAgatin.equalsIgnoreCase("N"))
			return false;
		else
			throw new ExploringMarsException("Invalid option.");
	}
}
