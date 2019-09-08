package exploring_mars.core;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RocketNavigationTest {

	RocketNavigation navigation;
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void rocketNavigation_setMaximumX_lessThanOne() throws ExploringMarsException {
	
		expectedEx.expect(ExploringMarsException.class);
		expectedEx.expectMessage("x edge must be greater then 0.");
		
		navigation = new RocketNavigation(0, 10);
	}
	
	@Test
	public void rocketNavigation_setMaximumY_lessThanOne() throws ExploringMarsException {
	
		expectedEx.expect(ExploringMarsException.class);
		expectedEx.expectMessage("y edge must be greater then 0.");
		
		navigation = new RocketNavigation(10, 0);
	}
	
}
