package agh.ics.oop;

import java.util.Vector;

class Animal {

    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    public Animal(MapDirection orientation, Vector2d position) {
        this.orientation = orientation;
        this.position = position;
    }

    public Animal() {

    }

    public Vector2d getPosition() {
        return position;
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    @Override
    public String toString() {
        String orient = orientation.toString();
        String posit = position.toString();

        return orient+posit;
    }

    boolean isAt(Vector2d position){
        return position.equals(this.position);
    }

    public void move(MoveDirection direction) {

        Vector2d pos = this.getPosition();
        MapDirection ort = this.getOrientation();

        if(ort.equals(MapDirection.NORTH)){
            switch(direction){
                case RIGHT -> this.orientation = MapDirection.EAST;
                case LEFT -> this.orientation = MapDirection.WEST;
                case FORWARD -> {if(pos.getY()<4){
                    this.position = pos.add(new Vector2d(0, 1));
                }else{
                }}
                case BACKWARD -> {if(pos.getY()>0){
                    this.position = pos.add(new Vector2d(0, -1));
                }else{}}
                }
            }
        if(ort.equals(MapDirection.SOUTH)){
            switch(direction){
                case RIGHT -> this.orientation = MapDirection.WEST;
                case LEFT -> this.orientation = MapDirection.EAST;
                case FORWARD -> {if(pos.getY()>0){
                    this.position = pos.add(new Vector2d(0, -1));
                }else{;}}
                case BACKWARD -> {if(pos.getY()<4){
                    this.position = pos.add(new Vector2d(0, 1));
                }else{;}}
            }
        }
        if(ort.equals(MapDirection.EAST)){
            switch(direction){
                case RIGHT -> this.orientation = MapDirection.SOUTH;
                case LEFT -> this.orientation = MapDirection.NORTH;
                case FORWARD -> {if(pos.getX()<4){
                    this.position = pos.add(new Vector2d(1, 0));
                }else{;}}
                case BACKWARD -> {if(pos.getX()>0){
                    this.position = pos.add(new Vector2d(-1, 0));
                }else{;}}
            }
        }
        if(ort.equals(MapDirection.WEST)){
            switch(direction){
                case RIGHT -> this.orientation = MapDirection.NORTH;
                case LEFT -> this.orientation = MapDirection.SOUTH;
                case FORWARD -> {if(pos.getX()>0){
                    this.position = pos.add(new Vector2d(-1, 0));
                }else{;}}
                case BACKWARD -> {if(pos.getX()<4){
                    this.position = pos.add(new Vector2d(1, 0));
                }else{;}}
            }
        }

    }

}
