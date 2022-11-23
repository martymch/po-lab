package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private final Vector2d upperRightCorner;
    private final Vector2d lowerLeftCorner;
    private final List<Animal> animals = new ArrayList<>();
    private final MapVisualizer visual = new MapVisualizer(this);

    public RectangularMap(int width, int height) {
        this.upperRightCorner = new Vector2d(width, height);
        this.lowerLeftCorner = new Vector2d(0, 0);
    }

    public String toString(){
        return this.visual.draw(lowerLeftCorner, upperRightCorner);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(this.isOccupied(position)) {
            return false;
        }
        return position.precedes(upperRightCorner) && position.follows(lowerLeftCorner);
    }

    @Override
    public boolean place(Animal animal) {
        if(this.isOccupied(animal.getPosition())){
            return false;
        }
        animals.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {

        for(int i = 0; i < animals.size(); i++){
            if(animals.get(i).getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {

        for(int i = 0; i < animals.size(); i++){
            if(animals.get(i).getPosition().equals(position)){
                return animals.get(i);
            }
        }
        return null;
    }

}
