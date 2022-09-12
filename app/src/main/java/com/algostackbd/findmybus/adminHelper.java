package com.algostackbd.findmybus;

public class adminHelper {
    String Bus_Licence_Num,CodeNum,Capacity,Driver_name,DriveConNum,BusCondition;

    public adminHelper(String bus_Licence_Num, String codeNum, String capacity, String driver_name, String driveConNum, String busCondition) {
        Bus_Licence_Num = bus_Licence_Num;
        CodeNum = codeNum;
        Capacity = capacity;
        Driver_name = driver_name;
        DriveConNum = driveConNum;
        BusCondition = busCondition;
    }

    public String getBus_Licence_Num() {
        return Bus_Licence_Num;
    }

    public void setBus_Licence_Num(String bus_Licence_Num) {
        Bus_Licence_Num = bus_Licence_Num;
    }

    public String getCodeNum() {
        return CodeNum;
    }

    public void setCodeNum(String codeNum) {
        CodeNum = codeNum;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String capacity) {
        Capacity = capacity;
    }

    public String getDriver_name() {
        return Driver_name;
    }

    public void setDriver_name(String driver_name) {
        Driver_name = driver_name;
    }

    public String getDriveConNum() {
        return DriveConNum;
    }

    public void setDriveConNum(String driveConNum) {
        DriveConNum = driveConNum;
    }

    public String getBusCondition() {
        return BusCondition;
    }

    public void setBusCondition(String busCondition) {
        BusCondition = busCondition;
    }
}
