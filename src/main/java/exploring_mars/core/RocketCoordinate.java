package exploring_mars.core;

import java.util.Objects;

public class RocketCoordinate {

	private int x;
	private int y;
	private Direction direction;

	public RocketCoordinate() {
		x = 0;
		y = 0;
		direction = Direction.North;
	}

	public RocketCoordinate(int x, int y, Direction direction) throws ExploringMarsException {
		this.setX(x);
		this.setY(y);
		this.setDirection(direction);
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

	public Direction getDirection() {
		return direction;
	}

	void setDirection(Direction direction) throws ExploringMarsException {
		if (direction == null)
			throw new ExploringMarsException("direction can't be empty.");
		this.direction = direction;
	}

	// TODO: for some reason, == operator is not working.
	//       for now we'll use obj1.equals(obj2); 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		RocketCoordinate other = (RocketCoordinate) obj;
		return direction == other.direction && x == other.x && y == other.y;
	}

}
