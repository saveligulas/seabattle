package sagu.uni.seabattle.domain.map;

import sagu.uni.seabattle.domain.Direction;

public class Vector2Int {
    private final int x;
    private final int y;

    public static Vector2Int fromArray(Object[] array) {
        return new Vector2Int(0, array.length);
    }

    public static Vector2Int fromArray(Object[][] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        if (!isUniform(array)) {
            throw new IllegalArgumentException("Array is not uniform");
        }
        return new Vector2Int(array.length, array[0].length);
    }

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

    public boolean fitsIntoInclusivePositive(Vector2Int other) {
        return this.x <= other.x && this.y <= other.y;
    }

    public static boolean isUniform(Object[][] array) {
        int n = array[0].length;
        for (int i = 1; i < array.length; i++) {
            if (array[i].length != n) {
                return false;
            }
        }
        return true;
    }

    public static Vector2Int add(Vector2Int v1, Vector2Int v2) {
        return new Vector2Int(v1.x + v2.x, v1.y + v2.y);
    }

    public static Vector2Int fromDirection(Direction direction, int size) {
        int x = 0;
        int y = 0;

        if (direction == Direction.NORTH || direction == Direction.SOUTH) {
            y = size;
            if (direction == Direction.SOUTH) {
                y = -size;
            }
        }

        if (direction == Direction.EAST || direction == Direction.WEST) {
            x = size;
            if (direction == Direction.WEST) {
                x = -size;
            }
        }

        return new Vector2Int(x, y);
    }
}
