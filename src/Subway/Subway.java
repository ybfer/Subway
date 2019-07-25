package Subway;
import java.util.List;

import Subway.command.Command;
import Subway.data.DataReader;
import Subway.data.DataWriter;
import Subway.data.Line;

public class Subway {
	public static void main(String[] args) {
		//解析参数
		InputVariables inputVariables = new InputVariables(args);
		//数据加载
		String dataPath = inputVariables.getInputDataPath();
		DataReader dataLoader = new DataReader(dataPath);
		List<Line> lineList = dataLoader.readData();

		Command command = inputVariables.getCommand();
		if(command != null){
			//执行命令
			List<String> result = command.execute(lineList);

			//写文件
			new DataWriter(inputVariables.getOutputFilePath()).writeResultList(result);
		}else{
			System.out.println(lineList);
		}


	}
}

