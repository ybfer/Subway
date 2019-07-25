package Subway;
import java.util.List;

import Subway.command.Command;
import Subway.data.DataReader;
import Subway.data.Line;

public class Subway {
	public static void main(String[] args) {
		

		//解析参数
		InputVariables inputVariables = new InputVariables(args);
		//数据加载
		String dataPath = inputVariables.getInputDataPath();
		DataReader dataLoader = new DataReader(dataPath);
		List<Line> lineList = dataLoader.readData();
		
		//执行命令
		Command command = inputVariables.getCommand();
		//command.execute(lineList, inputVariables.getOutputFilePath());
		
	}
}

