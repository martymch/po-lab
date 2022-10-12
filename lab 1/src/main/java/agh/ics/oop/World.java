package agh.ics.oop;


import java.util.Arrays;
import java.util.Scanner;
import java.lang.*;

public class World {

    public static void run(Directions[] directions) {

        // przecinki wersja jeden
//        for(i=0; i<directions.length-1; i++){
//            System.out.println("zwierzak idzie w " + directions[i]);
//        }
//        System.out.println(directions[directions.length -1]);

//        String joinedDirection = String.join(", ", directions);
//        System.out.print(joinedDirection);


        for(Directions direction: directions){
            String text =  switch(direction){
                case FORWARD-> "Zwierzak idzie do przodu";
                case BACKWARD->"Zwierzak idzie do tyłu";
                case LEFT->"Zwierzak idzie w lewo";
                case RIGHT->"Zwierzak idzie w prawo";
                default -> "";
                };
            System.out.println(text);
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