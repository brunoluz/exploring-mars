package exploring_mars;

import exploring_mars.cli.TerminalCli;
import exploring_mars.core.ExploringMarsException;

public class App {

	public static void main(String[] args) {
		System.out.println(" \n\n"
				+ "       EXPLORING MARS!       " 
				+ "\n\n"
				+ "                        @@@@ \n"
				+ "                    @@@....@ \n"
				+ "                 @@...  @.@@ \n" 
				+ "               @&.....@%@.@  \n"
				+ "             @@...@  @...@   \n" 
				+ "       @@@@@@...@ @....*@    \n"
				+ "     @@###@...... @...@@     \n" 
				+ "    @@##@@..........@@       \n"
				+ "   @@#@@@........,@&         \n" 
				+ "   @     @@....@@#@@         \n"
				+ "           @@@@###@.         \n" 
				+ "            @###@@           \n"
				+ "           @@@@              \n" 
				+ "\n");

			TerminalCli terminal = new TerminalCli();
			
			try
			{
				terminal.exploreMars();	
				
				System.out.println("Bye.");
			}
			catch (ExploringMarsException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Returning to Earth...");
				System.exit(-1);
			}
			catch (Exception e) {
				System.out.println("unexpected error");
				System.out.println(e.getStackTrace());
				System.exit(-2);
			}
			
		}
		
		
//        
//        int i = in.nextInt();
//        String s = in.next();

		// System.out.println(i);
		// System.out.println(s);

}
