package Subway.command;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import Subway.Floyd;
import Subway.data.Line;
import Subway.data.Station;

public class PlaneCommand extends Command{
	public static final String name = "plane";
	private String startStationName;
	private String endStationName;
	public PlaneCommand(String startStationName, String endStationName) {
		this.startStationName = startStationName;
		this.endStationName = endStationName;
	}
	public String getStartStationName() {
		return startStationName;
	}
	public String getEndStationName() {
		return endStationName;
	}
	
	@Override
	public List<String> execute(List<Line> lineList) {
		Floyd floyd = new Floyd();
		List<String> route = floyd.planeShortestPath(lineList, startStationName, 
				endStationName);

//		DataWriter writer = new DataWriter(outputPath);
		List<String> result = new ArrayList<String>();
		
		List<String> previous = null, after;
		ListIterator<String> listIterator = route.listIterator();
		boolean isFirst = true;
		while(listIterator.hasNext()){
			String station = listIterator.next();
			boolean isExchangeStation = false;
			String exchangeLineName = null;

			List<String> lineNames = findLineName(lineList, station);//站点所在的线路名
			
			if(lineNames.size() == 1){
				previous = lineNames;
				if(isFirst){
//					result.add(lineNames.get(0));
					result.add(route.size() + "");
					isFirst = false;					
				}
			}else{
				//判断是否换乘
				after = findLineName(lineList, listIterator.next());
				listIterator.previous();
				
				if(after != null && after.size() == 1){
					if(!previous.get(0).equals(after.get(0))){
						//是换乘站
//						result.add(after.get(0));
						isExchangeStation = true;
						exchangeLineName = after.get(0);
					}
				}
			}
			result.add(station);
			if (isExchangeStation){
				result.add(exchangeLineName);
				isExchangeStation = false;
			}
		}
//		writer.writeResultList(result);
		return result;
	}
	
	private List<String> findLineName(List<Line> lineList, String stationName){
		List<String> result = new ArrayList<String>();
		
		for (Line line : lineList) {
			for (Station station : line.getStationList()) {
				if(station.getName().equals(stationName)){
						result.add(line.getName());
				}
			}
		}
		
		return result;
	}
}
