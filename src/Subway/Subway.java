package Subway;
import java.util.List;

import Subway.command.Command;
import Subway.data.DataReader;
import Subway.data.Line;

public class Subway {
	public static void main(String[] args) {
		

		//��������
		InputVariables inputVariables = new InputVariables(args);
		//���ݼ���
		String dataPath = inputVariables.getInputDataPath();
		DataReader dataLoader = new DataReader(dataPath);
		List<Line> lineList = dataLoader.readData();
		
		//ִ������
		Command command = inputVariables.getCommand();
		//command.execute(lineList, inputVariables.getOutputFilePath());
		
	}
}

