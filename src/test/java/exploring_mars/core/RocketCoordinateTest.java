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
	public void rocketCoordinate_setX_zeroValue() throws ExploringMarsException {
		coordinate.setX(0);
		Assert.assertEquals(0, coordinate.getX());
	}

	@Test
	public void rocketCoordinate_setX_positiveValue() throws ExploringMarsException {
		coordinate.setX(10);
		Assert.assertEquals(10, coordinate.getX());
	}

	@Test
	public void rocketCoordinate_setX_negativeValue() throws ExploringMarsException {
		expectedEx.expect(ExploringMarsException.class);
		expectedEx.expectMessage("x value must be equal or greater than zero.");

		coordinate.setX(-1);
	}

	@Test
	public void rocketCoordinate_setY_zeroValue() throws ExploringMarsException {
		coordinate.setY(0);
		Assert.assertEquals(0, coordinate.getY());
	}

	@Test
	public void rocketCoordinate_setY_positiveValue() throws ExploringMarsException {
		coordinate.setY(10);
		Assert.assertEquals(10, coordinate.getY());
	}

	@Test
	public void rocketCoordinate_setY_negativeValue() throws ExploringMarsException {
		expectedEx.expect(ExploringMarsException.class);
		expectedEx.expectMessage("y value must be equal or greater than zero.");

		coordinate.setY(-1);
	}

	@Test
	public void rocketCoordinate_setDirection_nullValue() throws ExploringMarsException {
		expectedEx.expect(ExploringMarsException.class);
		expectedEx.expectMessage("direction can't be empty.");

		coordinate.setDirection(null);
	}

	@Test
	public void rocketCoordinate_setDirection_validValue() throws ExploringMarsException {
		coordinate.setDirection(Direction.East);
		Assert.assertEquals(Direction.East, coordinate.getDirection());
	}

	@Test
	public void rocketCoordinate_equals_nullValues() throws ExploringMarsException {
		Object that = null;
		Assert.assertFalse(this.coordinate.equals(that));
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void rocketCoordinate_equals_diferentTypes() throws ExploringMarsException {
		String that = "rocket string!";
		Assert.assertFalse(this.coordinate.equals(that));
	}
	
	@Test
	public void rocketCoordinate_equals_diferentValues() throws ExploringMarsException {
		RocketCoordinate that = new RocketCoordinate(1, 1, Direction.West);
		Assert.assertFalse(this.coordinate.equals(that));
	}
	
	@Test
	public void rocketCoordinate_equals_diferentX() throws ExploringMarsException {
		RocketCoordinate that = new RocketCoordinate(1, 0, Direction.North);
		Assert.assertFalse(this.coordinate.equals(that));
	}
	
	@Test
	public void rocketCoordinate_equals_diferentY() throws ExploringMarsException {
		RocketCoordinate that = new RocketCoordinate(0, 1, Direction.North);
		Assert.assertFalse(this.coordinate.equals(that));
	}
	
	@Test
	public void rocketCoordinate_equals_diferentDirection() throws ExploringMarsException {
		RocketCoordinate that = new RocketCoordinate(0, 0, Direction.South);
		Assert.assertFalse(this.coordinate.equals(that));
	}
	
	@Test
	public void rocketCoordinate_equals_sameValues() throws ExploringMarsException {
		RocketCoordinate that = new RocketCoordinate(0, 0, Direction.North);
		Assert.assertTrue(this.coordinate.equals(that));
	}
	
	@Test
	public void rocketCoordinate_equals_sameObject() throws ExploringMarsException {
		RocketCoordinate that = this.coordinate;
		Assert.assertTrue(this.coordinate.equals(that));
	}


}
