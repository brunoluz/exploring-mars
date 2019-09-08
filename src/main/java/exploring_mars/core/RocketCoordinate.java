package exploring_mars.core;

public class RocketCoordinate {

	private int x;

	private int y;

	Direction direction;

	int getX() {
		return x;
	}

	void setX(int x) throws ExploringMarsException {

		if (x < 0)
			throw new ExploringMarsException("x value must be equal or greater than zero");

		this.x = x;
	}

	int getY() {
		return y;
	}

	void setY(int y) throws ExploringMarsException {

		if (y < 0)
			throw new ExploringMarsException("y value must be equal or greater than zero");

		this.y = y;
	}

}
