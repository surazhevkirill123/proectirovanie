package by.bsu.lab2.bisiness;

import by.bsu.lab2.service.DataValidation;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;


enum TourType { Relaxation, Excursion, Shopping }

public class Tour {
    private static final AtomicInteger seed = new AtomicInteger();//для генерации уникального id


    private int id;
    private TourType tourType;
    private boolean isBurning;
    private String tourOperator;
    private String tourStartLocation;
    private String tourFinishLocation;
    private double cost;
    private Date tourStartTime;
    private Date tourFinishTime;
    public Tour(TourType tourType, boolean isBurning, String tourOperator,String customer,
                String tourStartLocation,String tourFinishLocation,double cost,Date tourStartTime,Date tourFinishTime) throws IllegalArgumentException {
        this.id = seed.incrementAndGet();
        setTourType(tourType);
        setIsBurning(isBurning);
        setTourOperator(tourOperator);
        setTourStartLocation(tourStartLocation);
        setTourFinishLocation(tourFinishLocation);
        setCost(cost);
        setTourStartTime(tourStartTime);
        setTourFinishTime(tourFinishTime);

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
    public void setCost(double cost) throws IllegalArgumentException {
        if (!DataValidation.costValidation(cost)) {
            throw new IllegalArgumentException("Cost cannot be negative!");
        }
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
    public void setTourFinishTime(Date tourFinishTime) throws IllegalArgumentException {
        if (!DataValidation.dateValidation(tourStartTime, tourFinishTime)) {
            throw new IllegalArgumentException("Cost cannot be negative!");
        }
        this.tourFinishTime = tourFinishTime;
    }

    public String toString()
    {

        return "Тип тура: " + getTourType().toString()+"\nТур горящий: " + getIsBurning()+"\nТуроператор: " + getTourOperator()+
                "\nМесто начала тура: " + getTourStartLocation()+"\nМесто конца тура: " + getTourFinishLocation()+
                "\nСтоимость: " + getCost()+"\nВремя начала тура: " + getTourStartTime().toString()+"\nВремя конца тура: " + getTourFinishTime().toString();
    }


}
