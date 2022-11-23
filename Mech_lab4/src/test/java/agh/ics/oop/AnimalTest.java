package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnimalTest {

    @Test
    void testOrientation(){

        Animal testAnimal = new Animal(MapDirection.NORTH, new Vector2d(2, 2));
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
        Animal testAnimal = new Animal(MapDirection.EAST, new Vector2d(1, 1));

        testAnimal.move(MoveDirection.LEFT);
        assertEquals(MapDirection.NORTH, testAnimal.getOrientation());

        testAnimal.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST, testAnimal.getOrientation());

        testAnimal.move(MoveDirection.BACKWARD);
        assertEquals(MapDirection.EAST, testAnimal.getOrientation());
    }

    @Test
    void testMovement(){

        Animal testAnimal = new Animal(MapDirection.EAST, new Vector2d(2, 1));

        testAnimal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(3, 1), testAnimal.getPosition());

        testAnimal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(4, 1), testAnimal.getPosition());

        testAnimal.move(MoveDirection.LEFT);
        testAnimal.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(4, 2), testAnimal.getPosition());

    }

    @Test
    void testOutOfMap(){

        Animal testAnimal = new Animal(MapDirection.EAST, new Vector2d(4, 4));
        Animal otherTestAnimal = new Animal(MapDirection.SOUTH, new Vector2d(0, 0));

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
