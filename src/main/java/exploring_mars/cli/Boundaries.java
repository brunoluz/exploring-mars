package exploring_mars.cli;

public class Boundaries {

    private final int x;
    private final int y;

    public Boundaries(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getFirst() {
        return x;
    }

    public int getSecond() {
        return y;
    }
	
}
