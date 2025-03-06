package sg.uni.seabattle.domain.map;

public class Vector2Int {
    private final int x;
    private final int y;

    public Vector2Int(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getMultiplicity() {
        return Math.multiplyExact(x, y);
    }
}
