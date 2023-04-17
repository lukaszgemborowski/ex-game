package pl.gemborowski.model.atmservice;

public class Task {
    private int region;
    private String requestType;
    private int atmId;

    public int getRegion()
    {
        return region;
    }

    public String getRequestType() {
        return requestType;
    }

    public int getAtmId() {
        return atmId;
    }
}