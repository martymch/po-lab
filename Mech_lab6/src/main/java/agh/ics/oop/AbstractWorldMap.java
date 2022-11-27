package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract public class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    private MapVisualizer map = new MapVisualizer(this);
    protected Map<Vector2d, Animal> animals = new HashMap<>();
    public abstract Vector2d getUpperRight();
    public abstract Vector2d getLowerLeft();
    abstract public boolean canMoveTo(Vector2d position);

    public String toString() {
        return this.map.draw(getLowerLeft(), getUpperRight());
    }

    public boolean isOccupied(Vector2d position) {
        return (this.objectAt(position) != null);
    }

    public Object objectAt(Vector2d position) {
        if (animals.containsKey(position)) {
            return animals.get(position);
        }
        return null;
    }

    public boolean place(Animal animal) {
        if(this.isOccupied(animal.getPosition())){
            return false;
        }
        animals.put(animal.getPosition(), animal);
        return true;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animalChanging = this.animals.get(oldPosition);
        this.animals.remove(oldPosition);
        this.animals.put(newPosition, animalChanging);
    }


}
