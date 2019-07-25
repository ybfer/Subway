package Subway.command;

import java.util.List;

import Subway.data.Line;

public abstract class Command{
	public static final String name = "";
	
	
	public abstract List<String> execute(List<Line> lineList);
}
