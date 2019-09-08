package exploring_mars.core;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;


public class RocketCoordinateTest {

	RocketCoordinate coordinate;
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Before
	public void before() {
		coordinate = new RocketCoordinate();
	}
	

	@Test
	public void rocketCoordinateTest_setX_zeroValue() throws ExploringMarsException {
		coordinate.setX(0);
		Assert.assertEquals(0, coordinate.getX());
	}
	
	@Test
	public void rocketCoordinateTest_setX_positiveValue() throws ExploringMarsException {
		coordinate.setX(10);
		Assert.assertEquals(10, coordinate.getX());
	}
	
	@Test
	public void rocketCoordinateTest_setX_negativeValue() throws ExploringMarsException {
		expectedEx.expect(ExploringMarsException.class);
		expectedEx.expectMessage("x value must be equal or greater than zero");
		
		coordinate.setX(-1);
	}
	
	@Test
	public void rocketCoordinateTest_setY_zeroValue() throws ExploringMarsException {
		coordinate.setY(0);
		Assert.assertEquals(0, coordinate.getY());
	}
	
	@Test
	public void rocketCoordinateTest_setY_positiveValue() throws ExploringMarsException {
		coordinate.setY(10);
		Assert.assertEquals(10, coordinate.getY());
	}

	@Test
	public void rocketCoordinateTest_setY_negativeValue() throws ExploringMarsException {
		expectedEx.expect(ExploringMarsException.class);
		expectedEx.expectMessage("y value must be equal or greater than zero");
		
		coordinate.setY(-1);
	}
	
	@Test
	public void rocketCoordinateTest_setDirection_nullValue() throws ExploringMarsException {
		expectedEx.expect(ExploringMarsException.class);
		expectedEx.expectMessage("direction can't be null");
		
		coordinate.setDirection(null);
	}
	
	@Test
	public void rocketCoordinateTest_setDirection_validValue() throws ExploringMarsException {
		coordinate.setDirection(Direction.East);
		Assert.assertEquals(Direction.East, coordinate.getDirection());
	}

	
}
