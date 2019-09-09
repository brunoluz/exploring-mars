package exploring_mars.cli;

import java.util.ArrayList;
import java.util.List;

import exploring_mars.core.Direction;
import exploring_mars.core.ExploringMarsException;
import exploring_mars.core.RocketCoordinate;
import exploring_mars.core.RocketNavigation;

public class TerminalCli {

	private StdReader reader;
	private ArrayList<RocketNavigation> navigations;
	private TerminalExplorerMarsHelper helper;

	public TerminalCli() {
		navigations = new ArrayList<RocketNavigation>();
		reader = new StdReader();
		helper = new TerminalExplorerMarsHelper(reader);
	}

	public void exploreMars() throws ExploringMarsException {

		Boundaries boundaries = helper.readBoundaries();

		boolean tryOneMore = true;

		while (tryOneMore) {

			RocketCoordinate coordinate = helper.readRocketCoordinates();
			RocketNavigation navigation = new RocketNavigation(boundaries.getX(), boundaries.getY(), coordinate);

			List<Move> moves = helper.readMoves();
			applyMoves(navigation, moves);
			navigations.add(navigation);

			tryOneMore = helper.readTryAgain();
		}

		printNavigations();

	}

	private void applyMoves(RocketNavigation navigation, List<Move> moves) throws ExploringMarsException {
		for (int i = 0; i < moves.size(); i++) {
			if (moves.get(i) == Move.Forward)
				navigation.move();
			else if (moves.get(i) == Move.Left)
				navigation.turnLeft();
			else // right
				navigation.turnRight();
		}
	}

	private void printNavigations() {

		for (int i = 0; i < navigations.size(); i++) {

			RocketNavigation navigation = navigations.get(i);

			System.out.println("" 
					+ String.valueOf(navigation.getCurrentCoordinate().getX()) + " "
					+ String.valueOf(navigation.getCurrentCoordinate().getY()) + " "
					+ directionToString(navigation.getCurrentCoordinate().getDirection()));
		}
	}

	private String directionToString(Direction direction) {

		if (direction == Direction.East)
			return "E";
		else if (direction == Direction.West)
			return "W";
		else if (direction == Direction.South)
			return "S";
		else
			return "N";
	}
}
