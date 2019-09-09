package exploring_mars.core;

import java.util.ArrayList;
import java.util.List;

public class RocketNavigation {

	List<RocketCoordinate> navigationHistory = new ArrayList<RocketCoordinate>();
	private final int maximumX;
	private final int maximumY;

	public RocketNavigation(int maximumX, int maximumY) throws ExploringMarsException {

		validateMaximumEdges(maximumX, maximumY);
		this.maximumX = maximumX;
		this.maximumY = maximumY;
		
		this.navigationHistory.add(new RocketCoordinate());
	}

	
	public RocketNavigation(int maximumX, int maximumY, RocketCoordinate initialCoordinate) throws ExploringMarsException {
		
		validateMaximumEdges(maximumX, maximumY);
		this.maximumX = maximumX;
		this.maximumY = maximumY;
		
		if (initialCoordinate.getX() > this.maximumX || initialCoordinate.getY() > this.maximumY)
			throw new ExploringMarsException("Invalid initial position.");
	}
	
	private void validateMaximumEdges(int maximumX, int maximumY) throws ExploringMarsException {
		if (maximumX < 1)
			throw new ExploringMarsException("x edge must be greater then 0.");

		if (maximumY < 1)
			throw new ExploringMarsException("y edge must be greater then 0.");
	}
	
	public RocketCoordinate getCurrentCoordinate() {
		return navigationHistory.get(navigationHistory.size() - 1);
	}

	int getMaximumX() {
		return maximumX;
	}

	int getMaximumY() {
		return maximumY;
	}

	public RocketCoordinate turnLeft() throws ExploringMarsException {

		RocketCoordinate currentCoordinate = this.getCurrentCoordinate();
		RocketCoordinate nextCoordinate;

		Direction currentDirection = currentCoordinate.getDirection();

		if (currentDirection == Direction.North)
			nextCoordinate = new RocketCoordinate(currentCoordinate.getX(), currentCoordinate.getY(), Direction.West);
		else if (currentDirection == Direction.West)
			nextCoordinate = new RocketCoordinate(currentCoordinate.getX(), currentCoordinate.getY(), Direction.South);
		else if (currentDirection == Direction.South)
			nextCoordinate = new RocketCoordinate(currentCoordinate.getX(), currentCoordinate.getY(), Direction.East);
		else // West
			nextCoordinate = new RocketCoordinate(currentCoordinate.getX(), currentCoordinate.getY(), Direction.North);

		this.navigationHistory.add(nextCoordinate);

		return nextCoordinate;
	}

	public RocketCoordinate turnRight() throws ExploringMarsException {

		RocketCoordinate currentCoordinate = this.getCurrentCoordinate();
		RocketCoordinate nextCoordinate;

		Direction currentDirection = currentCoordinate.getDirection();

		if (currentDirection == Direction.North)
			nextCoordinate = new RocketCoordinate(currentCoordinate.getX(), currentCoordinate.getY(), Direction.East);
		else if (currentDirection == Direction.East)
			nextCoordinate = new RocketCoordinate(currentCoordinate.getX(), currentCoordinate.getY(), Direction.South);
		else if (currentDirection == Direction.South)
			nextCoordinate = new RocketCoordinate(currentCoordinate.getX(), currentCoordinate.getY(), Direction.West);
		else // West
			nextCoordinate = new RocketCoordinate(currentCoordinate.getX(), currentCoordinate.getY(), Direction.North);

		this.navigationHistory.add(nextCoordinate);

		return nextCoordinate;
	}

	public RocketCoordinate move() throws ExploringMarsException {

		RocketCoordinate currentCoordinate = this.getCurrentCoordinate();

		Direction currentDirection = currentCoordinate.getDirection();
		int currentX = currentCoordinate.getX();
		int currentY = currentCoordinate.getY();
		int nextX;
		int nextY;

		if (currentDirection == Direction.North) {
			nextX = currentX + 1;
			nextY = currentY;
		} else if (currentDirection == Direction.East) {
			nextX = currentX;
			nextY = currentY + 1;
		} else if (currentDirection == Direction.South) {
			nextX = currentX - 1;
			nextY = currentY;
		} else { // West
			nextX = currentX;
			nextY = currentY - 1;
		}

		if (nextX < 0 || nextX > maximumX || nextY < 0 || nextY > maximumY)
			throw new ExploringMarsException("You've reached the boundaries of mars.");

		RocketCoordinate nextCoordinate = new RocketCoordinate(nextX, nextY, currentDirection);
		this.navigationHistory.add(nextCoordinate);

		return nextCoordinate;
	}

}
