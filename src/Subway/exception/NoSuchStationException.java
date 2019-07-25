package Subway.exception;

public class NoSuchStationException extends RuntimeException{
    private String stationName;
    public NoSuchStationException(String stationName){
        this.stationName = stationName;
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.err.println("û�и�վ�㣺" + stationName);
    }
}
