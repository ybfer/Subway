package Subway;
import java.util.List;

import Subway.command.Command;
import Subway.data.DataReader;
import Subway.data.DataWriter;
import Subway.data.Line;

public class Subway {
	public static void main(String[] args) {
		//��������
		InputVariables inputVariables = new InputVariables(args);
		//���ݼ���
		String dataPath = inputVariables.getInputDataPath();
		DataReader dataLoader = new DataReader(dataPath);
		List<Line> lineList = dataLoader.readData();

		Command command = inputVariables.getCommand();
		if(command != null){
			//ִ������
			List<String> result = command.execute(lineList);

			//д�ļ�
			new DataWriter(inputVariables.getOutputFilePath()).writeResultList(result);
		}else{
			System.out.println(lineList);
		}


	}
}

