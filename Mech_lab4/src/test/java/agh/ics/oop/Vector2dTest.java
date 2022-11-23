package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {

    @Test
    void testEqualsZeroZero(){
        Vector2d v1 = new Vector2d(0, 0);
        assertTrue(v1.equals(new Vector2d(0, 0)));
    }

    @Test
    void testToString(){
        Vector2d v1 = new Vector2d(0, 0);
        assertEquals("(0, 0)", v1.toString());
    }

    @Test
    void testPrecedes(){
        Vector2d v1 = new Vector2d(0, 0);
        Vector2d v2 = new Vector2d(0, 1);
        assertTrue(v1.precedes(v2));
    }

    @Test
    void testPrecedesSelf(){
        Vector2d v1 = new Vector2d(0, 0);
        Vector2d v2 = new Vector2d(0, 0);
        assertTrue(v1.precedes(v2));
    }

    @Test
    void testPrecedesNot(){
        Vector2d v1 = new Vector2d(0, 0);
        Vector2d v2 = new Vector2d(-1, 0);
        assertFalse(v1.precedes(v2));
    }

    @Test
    void testFollows(){
        Vector2d v1 = new Vector2d(0, 0);
        Vector2d v2 = new Vector2d(-1, -11);
        assertTrue(v1.follows(v2));
    }

    @Test
    void testFollowsSelf(){
        Vector2d v1 = new Vector2d(0, 0);
        Vector2d v2 = new Vector2d(0, 0);
        assertTrue(v1.follows(v2));
    }

    @Test
    void testFollowsNot(){
        Vector2d v1 = new Vector2d(0, 0);
        Vector2d v2 = new Vector2d(5, 5);
        assertFalse(v1.follows(v2));
    }

    @Test
    void testUpperRightSelf(){
        Vector2d v1 = new Vector2d(0, 0);
        Vector2d v2 = new Vector2d(-1, -11);
        assertEquals(new Vector2d(0, 0),v1.upperRight(v2));
    }

    @Test
    void testUpperRightNew(){
        Vector2d v1 = new Vector2d(0, 0);
        Vector2d v2 = new Vector2d(1, -1);
        assertEquals(new Vector2d(1, 0),v1.upperRight(v2));
    }

    @Test
    void testLowerLeftSelf(){
        Vector2d v1 = new Vector2d(0, 0);
        Vector2d v2 = new Vector2d(-1, -11);
        assertEquals(new Vector2d(-1, -11),v1.lowerLeft(v2));
    }

    @Test
    void testLowerLeftNew(){
        Vector2d v1 = new Vector2d(0, 0);
        Vector2d v2 = new Vector2d(1, -1);
        assertEquals(new Vector2d(0, -1),v1.lowerLeft(v2));
    }

    @Test
    void testFiveMinOnePlusMinOneMinFive(){
        Vector2d v1 = new Vector2d(5, -1);
        Vector2d v2 = new Vector2d(-1, -5);
        assertEquals(new Vector2d(4, -6),v1.add(v2));
    }

    @Test
    void testTwoTwoPlusOneOne(){
        Vector2d v1 = new Vector2d(2, 2);
        Vector2d v2 = new Vector2d(1, 1);
        assertEquals(new Vector2d(3, 3),v1.add(v2));
    }

    @Test
    void testFiveMinOneMinusMinOneMinFive(){
        Vector2d v1 = new Vector2d(5, -1);
        Vector2d v2 = new Vector2d(-1, -5);
        assertEquals(new Vector2d(6, 4),v1.subtract(v2));
    }

    @Test
    void testMinOneMinFiveMinusFiveMinOne(){
        Vector2d v1 = new Vector2d(-1, -5);
        Vector2d v2 = new Vector2d(5, -1);
        assertEquals(new Vector2d(-6, -4),v1.subtract(v2));
    }

    @Test
    void oppositeZero(){
        Vector2d v1 = new Vector2d(0, 0);
        assertEquals(new Vector2d(0, 0),v1.opposite());
    }

    @Test
    void oppositeMinOneOne(){
        Vector2d v1 = new Vector2d(-1, 1);
        assertEquals(new Vector2d(1, -1),v1.opposite());
    }

    @Test
    void oppositeTwoTwo(){
        Vector2d v1 = new Vector2d(2, 2);
        assertEquals(new Vector2d(-2, -2),v1.opposite());
    }

}
