package exploring_mars.cli;

import java.util.ArrayList;

import exploring_mars.core.ExploringMarsException;
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

	public RocketNavigation exploreMars() throws ExploringMarsException {

		Boundaries boundaries = helper.readBoundaries();
		
		return new RocketNavigation(boundaries.getX(), boundaries.getY());

	}
}
