package exploring_mars.cli;

import java.util.Scanner;

public class TerminalExplorerMarsHelper {
	
	private Scanner scanner;
	
	public TerminalExplorerMarsHelper(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public Boundaries readBoundaries() {
		
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Inform mars boundaries (X, Y)");
		
		String boundariesLine = scanner.next().trim();
		String[] boundaries = boundariesLine.split(" ");
		
		
		return new Boundaries(0, 0);
	}

}
