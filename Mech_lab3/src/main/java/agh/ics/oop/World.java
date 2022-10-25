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

        Animal leia = new Animal();

        System.out.println(leia.getPosition());
        System.out.println(leia.getOrientation());

        OptionsParser p1 = new OptionsParser();

        String[] navigation = new String[]{"b", "g"};

        MoveDirection[] DirectionsTable = p1.parse(navigation);

        for(int i=0; i<DirectionsTable.length; i++){
            leia.move(DirectionsTable[i]);
        }

        System.out.println(leia.getPosition());
        System.out.println(leia.getOrientation());


        //Odpowiedz na pytanie: jak zaimplementować mechanizm, który wyklucza pojawienie się dwóch zwierząt w tym samym miejscu.
        //Można zapisywać w tablicy wszystkie zajęte pozycje i gdy zwierzak chce się poruszyć sprawdzać, czy dana pozycja jest wolna

    }
}