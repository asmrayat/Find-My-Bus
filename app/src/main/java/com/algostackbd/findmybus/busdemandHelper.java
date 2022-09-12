package com.algostackbd.findmybus;

public class busdemandHelper {
    String RouteNum,time_slote,Consumer_catagory;

    public busdemandHelper(String routeNum, String time_slote, String consumer_catagory) {
        RouteNum = routeNum;
        this.time_slote = time_slote;
        Consumer_catagory = consumer_catagory;
    }

    public String getRouteNum() {
        return RouteNum;
    }

    public void setRouteNum(String routeNum) {
        RouteNum = routeNum;
    }

    public String getTime_slote() {
        return time_slote;
    }

    public void setTime_slote(String time_slote) {
        this.time_slote = time_slote;
    }

    public String getConsumer_catagory() {
        return Consumer_catagory;
    }

    public void setConsumer_catagory(String consumer_catagory) {
        Consumer_catagory = consumer_catagory;
    }
}
