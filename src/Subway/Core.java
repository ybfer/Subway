package Subway;


import Subway.command.PlaneCommand;
import Subway.command.QueryCommand;
import Subway.data.DataReader;
import Subway.data.Line;

import java.util.List;

public class Core {
    private static List<Line> lineList;

    public static List<Line> getLines(String filePath){
        DataReader dataReader = new DataReader(filePath);
        lineList = dataReader.readData();
        return lineList;
    }


    public static List<String> getStations(String lineName){
        QueryCommand queryCommand = new QueryCommand(lineName);
        return queryCommand.execute(lineList);
    }


    public static List<String> getRoute(String start, String end){
        PlaneCommand command = new PlaneCommand(start, end);
        return command.execute(lineList);
    }


}
