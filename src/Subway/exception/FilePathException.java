package Subway.exception;

public class FilePathException extends RuntimeException{
    private final String filePath;

    public FilePathException(String filePath){
        this.filePath = filePath;
    }

    @Override
    public void printStackTrace() {
        System.err.println("找不到文件：" + filePath);
    }
}
