package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{

    private MoveDirection[] moves;
    private IWorldMap map;
    private Vector2d[] initialPositions;
    public List<Animal> animals;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] initialPositions) {
        this.moves = moves;
        this.map = map;
        this.initialPositions = initialPositions;
        this.animals = new ArrayList<>();

        for (int i = 0; i < initialPositions.length; i++) {
            Vector2d initialPosition = initialPositions[i];
            Animal newAnimal = new Animal(map, initialPosition);
            if (map.place(newAnimal)) {
                animals.add(newAnimal);
            }
        }
    }

    @Override
    public void run() {
        for(int i = 0; i < moves.length; i++){
            int animal_index = i % animals.size();
            animals.get(animal_index).move(moves[i]);
        }

    }
}
