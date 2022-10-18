package agh.ics.oop;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(%d, %d)".formatted(x, y);
    }

    boolean precedes(Vector2d other) {
        if (x <= other.x & y <= other.y) return true;
        else return false;
    }

    boolean follows(Vector2d other) {
        if (x >= other.x & y >= other.y) return true;
        else return false;
    }

    Vector2d add(Vector2d other) {

        return new Vector2d(x + other.x, y + other.y);
    }

    Vector2d subtract(Vector2d other) {

        return new Vector2d(x - other.x, y - other.y);
    }

    Vector2d upperRight(Vector2d other) {

        return new Vector2d(max(x, other.x), max(y, other.y));
    }

    Vector2d lowerLeft(Vector2d other) {

        return new Vector2d(min(x, other.x), min(y, other.y));
    }

    Vector2d opposite() {

        return new Vector2d(-x, -y);
    }

    @Override
    public boolean equals(Object other) {

        if (other == this) {
            return true;
        }

        if (!(other instanceof Vector2d)) {
            return false;
        }

        Vector2d other_vector = (Vector2d) other;

        return follows(other_vector) && precedes(other_vector);
    }

    public static void main(String[] args) {
        Vector2d position1 = new Vector2d(1, 2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2, 1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
    }
}

