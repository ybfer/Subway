package Subway;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

import Subway.exception.ParameterException;
import org.apache.commons.lang.ArrayUtils;

import Subway.command.Command;
import Subway.command.PlaneCommand;
import Subway.command.QueryCommand;

public class InputVariables{
	private HashMap<String, String> commands;
	private String[] commandStr = {"-map", "-o", "-a", "-b"};
	private boolean isCommandError = false;
	
	public InputVariables(String[] args) {
		commands = new HashMap<String, String>();
		
		List<String> stringCommand = Arrays.asList(args);
		ListIterator<String> iterator = stringCommand.listIterator();
		
		while(iterator.hasNext()){
			String command = iterator.next();
			if(!ArrayUtils.contains(commandStr, command) || !iterator.hasNext()){
				isCommandError = true;
				break;
			}
			
			String nextCommand = iterator.next();
			if(ArrayUtils.contains(commandStr, nextCommand)){
				isCommandError = true;
				break;
			}
			if(command.equals("-map")){
				commands.put("input", nextCommand);
			}else if(command.equals("-o")){
				commands.put("output", nextCommand);
			}else if(command.equals("-a")){
				commands.put("query", nextCommand);
			}else if(command.equals("-b")){
				String stations = nextCommand + "_" + iterator.next();
				commands.put("plane", stations);
			}
		}
		
		//如果命令解析错误则赋给默认值
		if(isCommandError){
			commands.clear();
			commands.put("input", "subway.txt");
			commands.put("output", "station.txt");
			commands.put("query", "1号线");

			throw new ParameterException();
		}
		
	}
	
	public String getInputDataPath(){
		return commands.get("input");
	}
	
	public String getOutputFilePath(){
		return commands.get("output");
	}
	
	public Command getCommand(){
		String lineName = commands.get("query");
		
		Command command;
		if(lineName != null){
			command = new QueryCommand(lineName);
		}else{
			String stations = commands.get("plane");
			command = new PlaneCommand(stations.split("_")[0],
					stations.split("_")[1]);
		}
		return command;
	}

}
