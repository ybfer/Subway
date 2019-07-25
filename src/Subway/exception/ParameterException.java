package Subway.exception;

public class ParameterException extends RuntimeException{
    @Override
    public void printStackTrace() {
        System.err.println("ÊäÈë²ÎÊı´íÎó");
    }
}
