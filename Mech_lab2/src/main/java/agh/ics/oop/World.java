package agh.ics.oop;

import java.util.Scanner;
import java.lang.*;

public class World {

    public static void run(Directions[] directions) {

        for(Directions direction: directions){
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

    public static Directions[] string_to_enum(String[] directions) {

        Directions[] EnumDirections = new Directions[directions.length];

        for(int i = 0; i < directions.length; i++){
            String text =  switch(directions[i]){
                case "f"-> "FORWARD";
                case "b"->"BACKWARD";
                case "l"->"LEFT";
                case "r"->"RIGHT";
                default -> "";
            };
            EnumDirections[i] = Directions.valueOf(text);
        }

        return EnumDirections;
    }



    public static void main(String[] args) {

        System.out.println("Wpisz litery reprezentujące ruchy zwierzaka, oddzielone spacją: ");
        Scanner input = new Scanner(System.in);
        String moves = input.nextLine();
        String[] directions = moves.split(" ");

        System.out.println("system wystartował");
        System.out.println();

        string_to_enum(directions);
        run(string_to_enum(directions));

        System.out.println("system zakończył działanie");

        System.out.println();

    }
}