package agh.ics.oop;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {
    private List<Grass> grassList = new ArrayList<>();

    public GrassField(int grassNo){
        Random rand = new Random();
        int square = (int) sqrt(grassNo*10);

        for(int i=0; i < grassNo; i++){

            Vector2d position = new Vector2d(rand.nextInt(square), rand.nextInt(square));

            while(this.objectAt(position) != null && this.objectAt(position) instanceof Grass){
                rand = new Random();
                position = new Vector2d(rand.nextInt(square), rand.nextInt(square));
            }

            grassList.add(new Grass(position));
        }
    }

    public boolean canMoveTo(Vector2d position) {
        Object obj = this.objectAt(position);
        return obj == null || obj instanceof Grass;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if (super.objectAt(position) != null) {
            return super.objectAt(position);
        }
        else {
            for (Grass grass: grassList) {
                if (grass.getGrassPosition().equals(position)){
                    return grass;
                }
        }
            return null;
        }
    }

    @Override
    public Vector2d getUpperRight() {

        Vector2d upperBound = grassList.get(0).getGrassPosition();

        for(Animal animal: animals.values()){
            upperBound = upperBound.upperRight(animal.getPosition());
        }

        for(Grass grass: grassList){
            upperBound = upperBound.upperRight(grass.getGrassPosition());
        }

        return upperBound;
    }

    @Override
    public Vector2d getLowerLeft() {

        Vector2d lowerBound = grassList.get(0).getGrassPosition();

        for(Animal animal: animals.values()){
            lowerBound = lowerBound.lowerLeft(animal.getPosition());
        }

        for(Grass grass: grassList){
            lowerBound = lowerBound.lowerLeft(grass.getGrassPosition());
        }

        return lowerBound;
    }


}