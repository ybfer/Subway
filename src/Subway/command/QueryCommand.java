package Subway.command;

import java.util.ArrayList;
import java.util.List;

import Subway.data.Line;
import Subway.data.Station;
import Subway.exception.NoSuchLineException;

public class QueryCommand extends Command{
	public static final String name = "query";
	private String lineName;
	public QueryCommand(String lineName) {
		this.lineName = lineName;
	}
	public String getLineName() {
		return lineName;
	}
	
	@Override
	public List<String> execute(List<Line> lineList) {
		Line resultLine = null;
		for (Line line : lineList) {
			System.out.println(lineName);
			if(line.getName().equals(lineName)){
				resultLine = line;
				break;
			}
		}
		
		if(resultLine != null){
//			//Ð´ÎÄ¼þ
//			DataWriter writer = new DataWriter(outputPath);
//
			ArrayList<String> result = new ArrayList<String>();
			ArrayList<Station> stationList = resultLine.getStationList();
			for (Station station : stationList) {
				result.add(station.getName());
			}
//
//			writer.writeResultList(result);
			return result;
		}else{
			throw new NoSuchLineException(this.lineName);
		}

	}
}
