package agh.ics.oop;

import java.util.ArrayList;

public class OptionsParser {
    public OptionsParser() {
    }

    public MoveDirection[] parse(String[] directions){

        ArrayList<MoveDirection> DirectionsList = new ArrayList<MoveDirection>();

        for(int i=0; i<directions.length; i++){
            switch(directions[i]){
                case "b", "backward" -> DirectionsList.add(MoveDirection.BACKWARD);
                case "f", "forward" -> DirectionsList.add(MoveDirection.FORWARD);

            }
        }

        MoveDirection[] DirectionsTable = new MoveDirection[DirectionsList.size()];

        for(int i = 0; i < DirectionsList.size(); i++){
            DirectionsTable[i] = DirectionsList.get(i);
        }

        return DirectionsTable;
    }



}
