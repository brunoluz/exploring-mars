package exploring_mars.core;

import java.util.ArrayList;
import java.util.List;

public class RocketNavigation {

	List<RocketCoordinate> navigationHistory = new ArrayList<>();

	int maximumX;

	int maximumY;

	public RocketNavigation(int maximumX, int maximumY) throws ExploringMarsException {

		if (maximumX < 1)
			throw new ExploringMarsException("x edge must be greater then 0.");

		if (maximumY < 1)
			throw new ExploringMarsException("y edge must be greater then 0.");

		this.maximumX = maximumX;
		this.maximumY = maximumY;
		this.navigationHistory.add(new RocketCoordinate());
	}

	public RocketCoordinate getCurrentCoordinate() {
		return navigationHistory.get(navigationHistory.size() - 1);
	}

}
