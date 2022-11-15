package agh.ics.oop;

import java.util.Scanner;
import java.lang.*;

public class World {

    public static void run(MoveDirection[] directions) {

        for(MoveDirection direction: directions){
            switch (direction) {
                case FORWARD:
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak idzie w prawo");
                    break;
                case LEFT:
                    System.out.println("Zwierzak idzie w lewo");
                    break;
                default:
                    System.out.println("Nieznana komenda");
                    break;
            }
        };
        System.out.println();
    }

    public static MoveDirection[] string_to_enum(String[] directions) {

        MoveDirection[] EnumDirections = new MoveDirection[directions.length];

        for(int i = 0; i < directions.length; i++){
            String text =  switch(directions[i]){
                case "f"-> "FORWARD";
                case "b"->"BACKWARD";
                case "l"->"LEFT";
                case "r"->"RIGHT";
                default -> "";
            };
            EnumDirections[i] = MoveDirection.valueOf(text);
        }

        return EnumDirections;
    }


    public static void main(String[] args) {


        String[] argsm = new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(argsm);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

    }
}