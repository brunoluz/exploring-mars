package exploring_mars.core;

public class RocketCoordinate {

	private int x;

	private int y;

	private Direction direction;

	public RocketCoordinate() {
		x = 0;
		y = 0;
		direction = Direction.North;
	}

	int getX() {
		return x;
	}

	void setX(int x) throws ExploringMarsException {

		if (x < 0)
			throw new ExploringMarsException("x value must be equal or greater than zero.");

		this.x = x;
	}

	int getY() {
		return y;
	}

	void setY(int y) throws ExploringMarsException {

		if (y < 0)
			throw new ExploringMarsException("y value must be equal or greater than zero.");

		this.y = y;
	}

	Direction getDirection() {
		return direction;
	}

	void setDirection(Direction direction) throws ExploringMarsException {

		if (direction == null)
			throw new ExploringMarsException("direction can't be empty.");

		this.direction = direction;
	}

}
