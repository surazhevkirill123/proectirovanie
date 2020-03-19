package by.bsu.lab2.service;

import java.io.IOException;
import java.util.Date;

public class DataValidation {

    public static void DateValidation(Date start,Date finish) throws Exception {
        if(start.getTime()>=finish.getTime())
            throw new Exception("Exception: tourStartTime more or equal to the tourFinishTime");
    }
    public static void CostValidation(double cost) throws Exception {
        if(cost<=0)
            throw new Exception("Exception: cost is less or equal to the 0");
    }

}
