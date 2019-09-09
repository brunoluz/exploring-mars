package exploring_mars.core;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;
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

	@Test
	public void rocketNavigation_validEdges() throws ExploringMarsException {
		navigation = new RocketNavigation(10, 15);

		Assert.assertEquals(10, navigation.getMaximumX());
		Assert.assertEquals(15, navigation.getMaximumY());
		Assert.assertEquals(new RocketCoordinate(0, 0, Direction.North), this.navigation.getCurrentCoordinate());
	}

	@Test
	public void rocketNavigation_turnLeftOneTime() throws ExploringMarsException {
		navigation = new RocketNavigation(10, 10);

		for (int i = 0; i < 1; i++)
			navigation.turnLeft();

		Assert.assertEquals(new RocketCoordinate(0, 0, Direction.West), this.navigation.getCurrentCoordinate());
	}

	@Test
	public void rocketNavigation_turnLeftTwoTimes() throws ExploringMarsException {
		navigation = new RocketNavigation(10, 10);

		for (int i = 0; i < 2; i++)
			navigation.turnLeft();

		Assert.assertEquals(new RocketCoordinate(0, 0, Direction.South), this.navigation.getCurrentCoordinate());
	}

	@Test
	public void rocketNavigation_turnLeftThreeTimes() throws ExploringMarsException {
		navigation = new RocketNavigation(10, 10);

		for (int i = 0; i < 3; i++)
			navigation.turnLeft();

		Assert.assertEquals(new RocketCoordinate(0, 0, Direction.East), this.navigation.getCurrentCoordinate());
	}

	@Test
	public void rocketNavigation_turnLeftFourTimes() throws ExploringMarsException {
		navigation = new RocketNavigation(10, 10);

		for (int i = 0; i < 4; i++)
			navigation.turnLeft();

		Assert.assertEquals(new RocketCoordinate(0, 0, Direction.North), this.navigation.getCurrentCoordinate());
	}

	@Test
	public void rocketNavigation_turnRightOneTime() throws ExploringMarsException {
		navigation = new RocketNavigation(10, 10);

		for (int i = 0; i < 1; i++)
			navigation.turnRight();

		Assert.assertEquals(new RocketCoordinate(0, 0, Direction.East), this.navigation.getCurrentCoordinate());
	}

	@Test
	public void rocketNavigation_turnRightTwoTimes() throws ExploringMarsException {
		navigation = new RocketNavigation(10, 10);

		for (int i = 0; i < 2; i++)
			navigation.turnRight();

		Assert.assertEquals(new RocketCoordinate(0, 0, Direction.South), this.navigation.getCurrentCoordinate());
	}

	@Test
	public void rocketNavigation_turnRightThreeTimes() throws ExploringMarsException {
		navigation = new RocketNavigation(10, 10);

		for (int i = 0; i < 3; i++)
			navigation.turnRight();

		Assert.assertEquals(new RocketCoordinate(0, 0, Direction.West), this.navigation.getCurrentCoordinate());
	}

	@Test
	public void rocketNavigation_turnRightFourTimes() throws ExploringMarsException {
		navigation = new RocketNavigation(10, 10);

		for (int i = 0; i < 4; i++)
			navigation.turnRight();

		Assert.assertEquals(new RocketCoordinate(0, 0, Direction.North), this.navigation.getCurrentCoordinate());
	}

	@Test
	public void rocketNavigation_moveAboveMaximumX() throws ExploringMarsException {

		expectedEx.expect(ExploringMarsException.class);
		expectedEx.expectMessage("You've reached the boundaries of mars.");

		navigation = new RocketNavigation(10, 10);
		for (int i = 0; i < 11; i++)
			navigation.move();
	}

	@Test
	public void rocketNavigation_moveBelowZeroX() throws ExploringMarsException {

		expectedEx.expect(ExploringMarsException.class);
		expectedEx.expectMessage("You've reached the boundaries of mars.");

		navigation = new RocketNavigation(10, 10);
		navigation.turnLeft();
		navigation.turnLeft();
		navigation.move();
	}

	@Test
	public void rocketNavigation_moveAboveMaximumY() throws ExploringMarsException {

		expectedEx.expect(ExploringMarsException.class);
		expectedEx.expectMessage("You've reached the boundaries of mars.");

		navigation = new RocketNavigation(10, 10);
		navigation.turnRight();

		for (int i = 0; i < 11; i++)
			navigation.move();
	}

	@Test
	public void rocketNavigation_moveBelowZeroY() throws ExploringMarsException {

		expectedEx.expect(ExploringMarsException.class);
		expectedEx.expectMessage("You've reached the boundaries of mars.");

		navigation = new RocketNavigation(10, 10);
		navigation.turnLeft();
		navigation.move();
	}
	
	public void rocketNavigation_invalidInitialPositionX() throws ExploringMarsException {

		expectedEx.expect(ExploringMarsException.class);
		expectedEx.expectMessage("Invalid initial position.");
		
		RocketCoordinate invalidCoordinate = new RocketCoordinate(15, 0, Direction.North);
		navigation = new RocketNavigation(10, 10, invalidCoordinate);
	}
	
	public void rocketNavigation_invalidInitialPositionY() throws ExploringMarsException {

		expectedEx.expect(ExploringMarsException.class);
		expectedEx.expectMessage("Invalid initial position.");
		
		RocketCoordinate invalidCoordinate = new RocketCoordinate(0, 15, Direction.North);
		navigation = new RocketNavigation(10, 10, invalidCoordinate);
	}

}
