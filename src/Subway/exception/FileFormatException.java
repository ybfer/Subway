package Subway.exception;

public class FileFormatException extends RuntimeException{
    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.err.println("文件格式异常");
    }
}
