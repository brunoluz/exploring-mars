package exploring_mars.cli;

import exploring_mars.core.ExploringMarsException;

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

}
