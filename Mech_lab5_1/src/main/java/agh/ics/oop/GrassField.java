package agh.ics.oop;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {
    private List<Grass> grassList = new ArrayList<>();

    private int grassNo;

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

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!(this.objectAt(position) instanceof Animal));
    }

    @Override
    public Object objectAt(Vector2d position) {

        for (Grass grass: grassList) {
            if (grass.getGrassPosition().equals(position)){
                return grass;
            }
        }
        return super.objectAt(position);
    }

    private Vector2d[] getGrassExtremes() {
        Vector2d maxGrass = grassList.get(0).getGrassPosition();
        Vector2d minGrass = grassList.get(0).getGrassPosition();
        Vector2d[] grassExtreme = new Vector2d[2];

        for(Grass grass: grassList) {
            if (grass.getGrassPosition().follows(maxGrass)) {
                maxGrass = grass.getGrassPosition();
            }
            if(grass.getGrassPosition().precedes(minGrass)) {
                minGrass = grass.getGrassPosition();
            }
        }

        grassExtreme[0] = minGrass;
        grassExtreme[1] = maxGrass;

        return grassExtreme;
    }

    private Vector2d[] getAnimalExtremes() {
        Vector2d maxAnimal = animals.get(0).getPosition();
        Vector2d minAnimal = animals.get(0).getPosition();
        Vector2d[] animalExtreme = new Vector2d[2];

        for(Animal animal: animals) {
            if (animal.getPosition().follows(maxAnimal)) {
                maxAnimal = animal.getPosition();
            }
            if(animal.getPosition().precedes(minAnimal)) {
                minAnimal = animal.getPosition();
            }
        }

        animalExtreme[0] = minAnimal;
        animalExtreme[1] = maxAnimal;

        return animalExtreme;
    }

    @Override
    public Vector2d getUpperRight() {
        if(this.getAnimalExtremes()[0].follows(getGrassExtremes()[0])){
            return getAnimalExtremes()[0];
        }
        return getGrassExtremes()[0];
    }

    @Override
    public Vector2d getLowerLeft() {
        if(getAnimalExtremes()[0].precedes(getGrassExtremes()[0])){
            return getAnimalExtremes()[0];
        }
        return getGrassExtremes()[0];
    }


}