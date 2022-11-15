package agh.ics.oop;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Stream;

public class OptionsParser {
    public OptionsParser() {
    }

    public static MoveDirection[] parse(String[] input){

        return Stream.of(input)
                .map(instruction -> switch(instruction){
                case "b", "backward" -> MoveDirection.BACKWARD;
                case "f", "forward" -> MoveDirection.FORWARD;
                case "r", "right" -> MoveDirection.RIGHT;
                case "l", "left" -> MoveDirection.LEFT;
                default -> null;
            }).filter(Objects::nonNull)
                .toArray(MoveDirection[]::new);
        }

    }


