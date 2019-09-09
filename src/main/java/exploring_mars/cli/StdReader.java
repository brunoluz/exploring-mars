package exploring_mars.cli;

import java.util.Scanner;

public class StdReader {

	Scanner in = new Scanner(System.in);
	
	public String readLine() {
		return in.nextLine();
	}

}
