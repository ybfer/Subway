package SubwayTest;

import Subway.Core;
import Subway.InputVariables;
import Subway.data.Line;
import Subway.exception.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ExceptionTest {

    @Test
    public void testFileFormatException(){
        boolean isThrowException = false;
        try{
            List<Line> lines = Core.getLines("subway-error.txt");
        }catch (FileFormatException e){
            e.printStackTrace();
            isThrowException = true;
        }

        Assert.assertEquals(true, isThrowException);
    }

    @Test
    public void testFilePathException(){
        boolean isThrowException = false;
        try{
            List<Line> lines = Core.getLines("----------");
        }catch (FilePathException e){
            e.printStackTrace();
            isThrowException = true;
        }

        Assert.assertEquals(true, isThrowException);
    }

    @Test
    public void testNoSuchLineException(){
        boolean isThrowException = false;
        List<Line> lines = Core.getLines("subway.txt");

        try {
            List<String> line = Core.getStations("4号线");
        }catch (NoSuchLineException e){
            e.printStackTrace();
            isThrowException = true;
        }

        Assert.assertEquals(true, isThrowException);
    }

    @Test
    public void NoSuchStationException(){
        boolean isThrowException = false;
        List<Line> lines = Core.getLines("subway.txt");

        try {
            List<String> result = Core.getRoute("山海关", "山海关123");
        }catch (NoSuchStationException e){
            e.printStackTrace();
            isThrowException = true;
        }

        Assert.assertEquals(true, isThrowException);
    }

    @Test
    public void testParameterException1(){
        boolean isThrowException = false;
        String[] args = {"-map", "subway.txt", "-o", "-b", "山海关"};
        try {
            InputVariables inputVariables = new InputVariables(args);
        }catch (ParameterException e){
            e.printStackTrace();
            isThrowException = true;
        }

        Assert.assertEquals(true, isThrowException);
    }

    @Test
    public void testParameterException2(){
        boolean isThrowException = false;
        String[] args = {"subway.txt", "-o", "-b", "山海关"};
        try {
            InputVariables inputVariables = new InputVariables(args);
        }catch (ParameterException e){
            e.printStackTrace();
            isThrowException = true;
        }

        Assert.assertEquals(true, isThrowException);
    }
}
