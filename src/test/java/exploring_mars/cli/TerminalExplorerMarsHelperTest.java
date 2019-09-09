package exploring_mars.cli;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.*;

import exploring_mars.core.Direction;
import exploring_mars.core.ExploringMarsException;
import exploring_mars.core.RocketCoordinate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;

public class TerminalExplorerMarsHelperTest {

	StdReader stdReader;
	TerminalExplorerMarsHelper helper;

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Before
	public void before() {
		stdReader = Mockito.mock(StdReader.class);
		helper = new TerminalExplorerMarsHelper(stdReader);
	}

	@Test
	public void TerminalExplorerMarsHelper_readBoundaries_validBoundaries() throws ExploringMarsException {

		Mockito.when(stdReader.readLine()).thenReturn("10 15");

		Boundaries boundaries = helper.readBoundaries();

		Assert.assertEquals(10, boundaries.getX());
		Assert.assertEquals(15, boundaries.getY());
	}

	@Test
	public void TerminalExplorerMarsHelper_readBoundaries_onlyX() throws ExploringMarsException {

		expectedEx.expect(ExploringMarsException.class);
		expectedEx.expectMessage("Invalid boundaires.");

		Mockito.when(stdReader.readLine()).thenReturn("10");

		helper.readBoundaries();
	}

	@Test
	public void TerminalExplorerMarsHelper_readBoundaries_multipleSpaces() throws ExploringMarsException {

		expectedEx.expect(ExploringMarsException.class);
		expectedEx.expectMessage("Invalid boundaires.");

		Mockito.when(stdReader.readLine()).thenReturn("10 15 20");

		helper.readBoundaries();
	}

	@Test
	public void TerminalExplorerMarsHelper_readBoundaries_nomNumbers() throws ExploringMarsException {

		expectedEx.expect(ExploringMarsException.class);
		expectedEx.expectMessage("Invalid boundaires.");

		Mockito.when(stdReader.readLine()).thenReturn("a b");

		helper.readBoundaries();
	}

	@Test
	public void TerminalExplorerMarsHelper_readRocketCoordinates_nomNumbers() throws ExploringMarsException {

		expectedEx.expect(ExploringMarsException.class);
		expectedEx.expectMessage("Invalid coordinates.");

		Mockito.when(stdReader.readLine()).thenReturn("a b c");

		helper.readRocketCoordinates();
	}

	@Test
	public void TerminalExplorerMarsHelper_readRocketCoordinates_invalidNumbers() throws ExploringMarsException {

		expectedEx.expect(ExploringMarsException.class);
		expectedEx.expectMessage("Invalid coordinates.");

		Mockito.when(stdReader.readLine()).thenReturn("a b W");

		helper.readRocketCoordinates();
	}

	@Test
	public void TerminalExplorerMarsHelper_readRocketCoordinates_invalidDirection() throws ExploringMarsException {

		expectedEx.expect(ExploringMarsException.class);
		expectedEx.expectMessage("Invalid coordinates.");

		Mockito.when(stdReader.readLine()).thenReturn("5 5 a");

		helper.readRocketCoordinates();
	}

	@Test
	public void TerminalExplorerMarsHelper_readRocketCoordinates_northDirection() throws ExploringMarsException {

		Mockito.when(stdReader.readLine()).thenReturn("5 5 N");
		RocketCoordinate coordinate = helper.readRocketCoordinates();

		Assert.assertEquals(Direction.North, coordinate.getDirection());
	}

	@Test
	public void TerminalExplorerMarsHelper_readRocketCoordinates_southDirection() throws ExploringMarsException {

		Mockito.when(stdReader.readLine()).thenReturn("5 5 S");
		RocketCoordinate coordinate = helper.readRocketCoordinates();

		Assert.assertEquals(Direction.South, coordinate.getDirection());
	}

	@Test
	public void TerminalExplorerMarsHelper_readRocketCoordinates_eastDirection() throws ExploringMarsException {

		Mockito.when(stdReader.readLine()).thenReturn("5 5 E");
		RocketCoordinate coordinate = helper.readRocketCoordinates();

		Assert.assertEquals(Direction.East, coordinate.getDirection());
	}
	
	@Test
	public void TerminalExplorerMarsHelper_readRocketCoordinates_westDirection() throws ExploringMarsException {

		Mockito.when(stdReader.readLine()).thenReturn("5 5 W");
		RocketCoordinate coordinate = helper.readRocketCoordinates();

		Assert.assertEquals(Direction.West, coordinate.getDirection());
	}
	
	@Test
	public void TerminalExplorerMarsHelper_readRocketCoordinates_validCoordinate() throws ExploringMarsException {

		Mockito.when(stdReader.readLine()).thenReturn("4 5 W");
		RocketCoordinate coordinate = helper.readRocketCoordinates();

		Assert.assertTrue(coordinate.equals(new RocketCoordinate(4, 5, Direction.West)));
	}

}
