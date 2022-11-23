package agh.ics.oop;

import java.util.Vector;

class Animal {

    private IWorldMap map;
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position;

    public Animal(MapDirection orientation, Vector2d position) {
        this.orientation = orientation;
        this.position = position;
    }

    public Animal(IWorldMap map) {
        this.map = map;
        position = new Vector2d(2, 2);
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
    }

    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public String toString() {

        String orient = switch(this.orientation){
            case EAST -> ">";
            case WEST -> "<";
            case NORTH -> "^";
            case SOUTH -> "v";
            default -> null;
        };

        return orient;
    }

    public boolean isAt(Vector2d position){
        return position.equals(this.position);
    }

    public void move(MoveDirection direction) {

        Vector2d pos = this.getPosition();
        MapDirection ort = this.getOrientation();

        Vector2d ort_unit = this.orientation.toUnitVector();

        switch(direction){
            case RIGHT -> ort.next();
            case LEFT -> ort.previous();
            case FORWARD -> {
                if(map.canMoveTo(pos.add(ort_unit))){
                    this.position = pos.add(ort_unit);
                }
                else{;}}
            case BACKWARD -> {if(map.canMoveTo(pos.subtract(ort_unit))){
                this.position = pos.subtract(ort_unit);
            }
            else{;}}
        }

    }

}
