package agh.ics.oop;

public class Grass {

    private Vector2d grassPosition;

    public Grass(Vector2d grassPosition) {
        this.grassPosition = grassPosition;
    }

    public Vector2d getGrassPosition() {
        return grassPosition;
    }

    @Override
    public String toString() {
        return "*";
    }
}
