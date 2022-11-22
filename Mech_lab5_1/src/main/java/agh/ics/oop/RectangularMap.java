package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap {
    private final Vector2d upperRightCorner;
    private final Vector2d lowerLeftCorner;

    public RectangularMap(int width, int height) {
        this.upperRightCorner = new Vector2d(width, height);
        this.lowerLeftCorner = new Vector2d(0, 0);
    }

    @Override
    public Vector2d getUpperRight() {
        return this.upperRightCorner;
    }

    @Override
    public Vector2d getLowerLeft() {
        return this.lowerLeftCorner;
    }




}
