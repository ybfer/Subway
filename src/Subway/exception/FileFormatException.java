package Subway.exception;

public class FileFormatException extends RuntimeException{
    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.err.println("�ļ���ʽ�쳣");
    }
}
