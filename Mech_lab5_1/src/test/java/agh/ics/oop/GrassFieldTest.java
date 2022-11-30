package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GrassFieldTest {

    @Test
    public void isOccupiedTest() {
        GrassField map = new GrassField(10);
        map.place(new Animal(map, new Vector2d(7, 22)));
        assertTrue(map.isOccupied(new Vector2d(7, 22)));
        assertFalse(map.isOccupied(new Vector2d(19, 8)));
    }

    @Test
    public void objectAtTest() {
        GrassField map = new GrassField(10);
        assertTrue(map.objectAt(new Vector2d(1, 1)) == null);
        map.place(new Animal(map, new Vector2d(1, 1)));
        assertTrue(map.objectAt(new Vector2d(1, 1)) instanceof Animal);
    }


    @Test
    public void placeTest() {
        GrassField map = new GrassField(10);
        assertTrue(map.place(new Animal(map, new Vector2d(-1, 2))));
        assertTrue(map.place(new Animal(map, new Vector2d(5, 9))));
    }

    @Test
    public void canMoveToTest() {
        GrassField map = new GrassField(8);
        assertTrue(map.canMoveTo(new Vector2d(1, 1)));
        map.place(new Animal(map, new Vector2d(4, 5)));
        assertFalse(map.canMoveTo(new Vector2d(4, 5)));
    }

}
