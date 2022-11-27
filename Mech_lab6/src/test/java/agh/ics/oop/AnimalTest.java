package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnimalTest {

    IWorldMap map = new RectangularMap(10, 10);

    @Test
    void testOrientation(){
        IWorldMap map = new RectangularMap(10, 10);

        Animal testAnimal = new Animal(map);

        testAnimal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.WEST, testAnimal.getOrientation());

        testAnimal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.SOUTH, testAnimal.getOrientation());

        testAnimal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.EAST, testAnimal.getOrientation());

        testAnimal.move(MoveDirection.FORWARD);
        assertEquals(MapDirection.EAST, testAnimal.getOrientation());

        testAnimal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.SOUTH, testAnimal.getOrientation());

        testAnimal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.WEST, testAnimal.getOrientation());
    }

    @Test
    void testOrientationNonDefault(){
        IWorldMap map = new RectangularMap(10, 10);
        Animal testAnimal = new Animal(map, new Vector2d(1, 1));

        testAnimal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.WEST, testAnimal.getOrientation());

        testAnimal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.NORTH, testAnimal.getOrientation());

        testAnimal.move(MoveDirection.BACKWARD);
        assertEquals(MapDirection.NORTH, testAnimal.getOrientation());
    }

    @Test
    void testMovement(){
        IWorldMap map = new RectangularMap(10, 10);
        Animal testAnimal = new Animal(map, new Vector2d(2, 1));

        testAnimal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2, 2), testAnimal.getPosition());

        testAnimal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2, 3), testAnimal.getPosition());

        testAnimal.move(MoveDirection.LEFT);
        testAnimal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(1, 3), testAnimal.getPosition());

    }

    @Test
    void testOutOfMap(){
        IWorldMap map = new RectangularMap(4, 4);
        Animal testAnimal = new Animal(map, new Vector2d(4, 4));
        testAnimal.move(MoveDirection.RIGHT);
        Animal otherTestAnimal = new Animal(map, new Vector2d(0, 0));
        otherTestAnimal.move(MoveDirection.LEFT);
        otherTestAnimal.move(MoveDirection.LEFT);

        testAnimal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(4, 4), testAnimal.getPosition());

        testAnimal.move(MoveDirection.BACKWARD);
        assertEquals(new Vector2d(3, 4), testAnimal.getPosition());

        testAnimal.move(MoveDirection.LEFT);
        testAnimal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(3, 4), testAnimal.getPosition());

        otherTestAnimal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(0, 0), otherTestAnimal.getPosition());

        otherTestAnimal.move(MoveDirection.RIGHT);
        otherTestAnimal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(0, 0), otherTestAnimal.getPosition());

    }

    @Test
    void testParseTable(){

        OptionsParser TestParser = new OptionsParser();
        String[] TestTable = new String[]{"b", "forward", "cos"};
        MoveDirection[] AnswerTable = new MoveDirection[]{MoveDirection.BACKWARD, MoveDirection.FORWARD};
        MoveDirection[] SuspectTable = TestParser.parse(TestTable);

        assertEquals(MoveDirection.BACKWARD, TestParser.parse(TestTable)[0]);
        assertEquals(MoveDirection.FORWARD, TestParser.parse(TestTable)[1]);
        assertEquals(2, TestParser.parse(TestTable).length);

    }

}