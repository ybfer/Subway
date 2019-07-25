package Subway.data;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import Subway.exception.FileFormatException;
import Subway.exception.FilePathException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DataReader {
	private String dataPath;
	public DataReader(String dataPath) {
		this.dataPath = dataPath;
	}
	
	public List<Line> readData(){
		String jsonStr;
		try {
			jsonStr = readFile();
		} catch (IOException e) {
			jsonStr = "";
			throw new FilePathException(dataPath);
		}
		
		List<Line> lineList;
		try{
			lineList = json2LineList(jsonStr);
		}catch (Exception e) {
			lineList = new ArrayList<Line>();
			throw new FileFormatException();
		}
		
		return lineList;
	}
	
	private String readFile() throws IOException{
		StringBuffer sb = new StringBuffer();
		
		BufferedReader br = new BufferedReader(new FileReader(new File(dataPath)));
		
		String readLine;
		while((readLine = br.readLine()) != null){
			sb.append(readLine);
		}
		
		br.close();
		
		return sb.toString();
	}
	
	private List<Line> json2LineList(String json){
		ArrayList<Line> lineList = new ArrayList<Line>();
		
		if(json.isEmpty()){
			return lineList;
		}
		JSONArray jsonLineList = JSONArray.fromObject(json);
		ListIterator lineIterator = jsonLineList.listIterator();
		while(lineIterator.hasNext()){
			Line line = new Line();
			JSONObject jsonLine = (JSONObject)lineIterator.next();
			line.setName(jsonLine.getString("name"));
			
			//����stationlist
			ArrayList<Station> stationList = new ArrayList<Station>();
			JSONArray jsonStationList = jsonLine.getJSONArray("station_list");
			
			ListIterator stationIterator = jsonStationList.listIterator();
			while(stationIterator.hasNext()){
				JSONObject jsonStation = 
						(JSONObject)stationIterator.next();
				
					stationList.add(new 
							Station(jsonStation.getString("name")));
			}
			
			line.setStationList(stationList);
			lineList.add(line);
		}
		
		return lineList;
	}
}
