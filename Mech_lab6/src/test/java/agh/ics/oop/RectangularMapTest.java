package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {

    @Test
    public void canMoveToTest() {
        IWorldMap map = new RectangularMap(2, 2);
        assertTrue(map.canMoveTo(new Vector2d(0, 0)));
        assertTrue(map.canMoveTo(new Vector2d(0, 1)));
        assertTrue(map.canMoveTo(new Vector2d(1, 1)));
    }

    @Test
    public void placeTest() {
        IWorldMap map = new RectangularMap(3, 3);
        assertTrue(map.place(new Animal(map, new Vector2d(1, 1))));
    }

    @Test
    public void isOccupiedTest() {
        IWorldMap map = new RectangularMap(5, 5);
        assertFalse(map.isOccupied(new Vector2d(2, 2)));
        map.place(new Animal(map, new Vector2d(2, 2)));
        assertTrue(map.isOccupied(new Vector2d(2, 2)));
    }

    @Test
    public void objectAtTest() {
        IWorldMap map = new RectangularMap(5, 5);
        assertEquals(map.objectAt(new Vector2d(3, 4)), null);
        map.place(new Animal(map, new Vector2d(3, 4)));
        assertTrue(map.objectAt(new Vector2d(3, 4)) instanceof Animal);
        assertEquals(map.objectAt(new Vector2d(1, 5)), null);
        map.place(new Animal(map, new Vector2d(1, 5)));
        assertTrue(map.objectAt(new Vector2d(1, 5)) instanceof Animal);
    }
}