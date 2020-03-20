package by.bsu.lab2.presentation.main;

import by.bsu.lab2.bisiness.Tour;
import by.bsu.lab2.bisiness.TourType;
import by.bsu.lab2.dbo.FileDbProcessor;

import java.util.Date;

public class RunMain {

    public static void main(String[] args) throws Exception {
        FileDbProcessor processor = new FileDbProcessor();
        Tour old = new Tour(TourType.Excursion, false, "new", "c", "sl", "fl", 1, new Date(1478991172134L), new Date(1478991192134L));
        processor.create(old);
        Tour tour = processor.readById(old.getId());
        System.out.println(tour.toString());
    }
}
