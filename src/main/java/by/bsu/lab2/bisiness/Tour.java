package by.bsu.lab2.bisiness;

import by.bsu.lab2.service.DataValidation;
import com.sun.istack.internal.NotNull;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;


enum TourType { Relaxation, Excursion, Shopping }

public class Tour {
    private static final AtomicInteger seed = new AtomicInteger();//для генерации уникального id


    private int id;
    private TourType tourType;
    private boolean isBurning;
    private String tourOperator;
    private String customer;
    private String tourStartLocation;
    private String tourFinishLocation;
    private double cost;
    private Date tourStartTime;
    private Date tourFinishTime;
    public Tour(TourType tourType, boolean isBurning, String tourOperator,String customer,
                String tourStartLocation,String tourFinishLocation,double cost,Date tourStartTime,Date tourFinishTime) throws Exception {
        try {
            DataValidation.CostValidation(cost);
            DataValidation.DateValidation(tourStartTime,tourFinishTime);
        }
        catch (Exception e)
        {
             e.getMessage();
        }
        this.id = seed.incrementAndGet();
        this.tourType = tourType;
        this.isBurning = isBurning;
        this.tourOperator = tourOperator;
        this.customer = customer;
        this.tourStartLocation = tourStartLocation;
        this.tourFinishLocation = tourFinishLocation;
        this.cost = cost;
        this.tourStartTime = tourStartTime;
        this.tourFinishTime = tourFinishTime;

    }

    public Tour() {
        this.id = seed.incrementAndGet();
    }
    public int getId() {
        return id;
    }

    public TourType getTourType() {
        return tourType;
    }
    public void setTourType(TourType tourType) {
        this.tourType = tourType;
    }

    public boolean getIsBurning() {
        return isBurning;
    }
    public void setIsBurning(boolean isBurning) {
        this.isBurning = isBurning;
    }

    public String getTourOperator() {
        return tourOperator;
    }
    public void setTourOperator(String tourOperator) {
        this.tourOperator = tourOperator;
    }

    public String getCustomer() {
        return customer;
    }
    public void setCustomer(String Customer) {
        this.customer = customer;
    }

    public String getTourStartLocation() {
        return tourStartLocation;
    }
    public void setTourStartLocation(String tourStartLocation) {
        this.tourStartLocation = tourStartLocation;
    }

    public String getTourFinishLocation() {
        return tourFinishLocation;
    }
    public void setTourFinishLocation(String tourFinishLocation) {
        this.tourFinishLocation = tourFinishLocation;
    }

    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getTourStartTime() {
        return tourStartTime;
    }
    public void setTourStartTime(Date tourStartTime) {
        this.tourStartTime = tourStartTime;
    }

    public Date getTourFinishTime() {
        return tourFinishTime;
    }
    public void setTourFinishTime(Date tourFinishTime) {
        this.tourFinishTime = tourFinishTime;
    }

    public String toString()
    {
        String output="Тип тура: " + this.tourType.toString()+"\nТур горящий: " + this.isBurning+"\nТуроператор: " + this.tourOperator+
                "\nЗаказчик: " + this.customer+"\nМесто начала тура: " + this.tourStartLocation+"\nМесто конца тура: " + this.tourFinishLocation+
                "\nСтоимость: " + this.cost+"\nВремя начала тура: " + this.tourStartTime.toString()+"\nВремя конца тура: " + this.tourFinishTime.toString();

        return output;
    }


}
