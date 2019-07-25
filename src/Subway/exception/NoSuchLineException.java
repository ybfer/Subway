package Subway.exception;

public class NoSuchLineException extends RuntimeException {
    private String lineName;
    public NoSuchLineException(String lineName){
        this.lineName = lineName;
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.err.println("û�и���·��" + lineName);
    }
}
