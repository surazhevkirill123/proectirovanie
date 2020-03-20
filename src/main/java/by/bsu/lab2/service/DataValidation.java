package by.bsu.lab2.service;

import java.util.Date;

public class DataValidation {

    public static boolean dateValidation(Date start, Date finish) {
        return start.getTime() < finish.getTime();
    }
    public static boolean costValidation(double cost) {
        return cost >= 0;
    }

}
