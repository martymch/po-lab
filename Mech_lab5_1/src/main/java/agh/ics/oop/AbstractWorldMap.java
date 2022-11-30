package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractWorldMap implements IWorldMap {
    private MapVisualizer map = new MapVisualizer(this);
    protected List<Animal> animals = new ArrayList<>();
    public abstract Vector2d getUpperRight();
    public abstract Vector2d getLowerLeft();

    public String toString() {
        return this.map.draw(getLowerLeft(), getUpperRight());
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return (this.objectAt(position) != null);
    }

    public Object objectAt(Vector2d position) {

        return animals.stream()
                .filter(animal -> animal.isAt(position))
                .findFirst().orElse(null);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(this.isOccupied(position)) {
            return false;
        }
        return position.precedes(getUpperRight()) && position.follows(getLowerLeft());
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
    public void run(MoveDirection[] directions) {

        int numberOfAnimals = animals.size();

        for (int index = 0; index < directions.length; index++) {
            Animal animalOnMap = animals.get(index % numberOfAnimals);
            animalOnMap.move(directions[index]);
            animals.set(index % numberOfAnimals, animalOnMap);
        }
    }


}
