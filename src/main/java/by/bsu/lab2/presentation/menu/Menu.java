package by.bsu.lab2.presentation.menu;

import by.bsu.lab2.bisiness.Tour;
import by.bsu.lab2.bisiness.TourType;
import by.bsu.lab2.dbo.FileDbProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.util.Date;


public class Menu {
    private Input input = new Input();
    private FileDbProcessor processor = new FileDbProcessor();
    private Logger logger = LogManager.getLogger(Menu.class);

    private int choose(String question, int variantNumber) {
        int action;

        do {
            action = input.askInt(question + "\n");
        } while (action < 0 || action > variantNumber);

        return action;
    }

    public void showMainMenu() {
        while (true) {
            try {
                int action = choose("""
                        Choose action:
                        \t1) Show all
                        \t2) Find by ID
                        \t3) Create new
                        \t4) Exit""", 4);
                switch (action) {
                    case 1:
                        showAllMenu();
                        break;
                    case 2:
                        showFindByIdMenu();
                        break;
                    case 3:
                        Tour tour = new Tour();
                        showEditMenu(tour);
                        processor.create(tour);
                        break;
                    default:
                        return;
                }
            } catch (Exception e) {
                logger.error(e);
            }
        }
    }

    public void showAllMenu() throws Exception {
        Tour[] tours = processor.readAll();

        if (tours.length == 0) {
            System.out.println("There's no tours!");
        }

        for (Tour tour : tours) {
            System.out.println(tour);
            System.out.println("\n");
        }
    }

    public void showFindByIdMenu() throws Exception {
        String id = input.askString("Enter id: ");

        Tour tour = processor.readById(id);
        System.out.println(tour);

        int action = choose("""
                Choose action:
                \t1) Edit
                \t2) Delete
                \t3) Back to main menu""",3);

        switch (action) {
            case 1 -> {
                showEditMenu(tour);
                processor.update(tour);
            }
            case 2 -> processor.delete(tour);
        }
    }

    public void showEditMenu(Tour tour) {
        int type = choose("""
                Choose tour type:
                \t1) Relaxation
                \t2) Excursion
                \t3) Shopping""", 3);
        tour.setTourType(TourType.values()[type - 1]);

        boolean isBurning = input.askBool("Is it burning? (yes/no)\n");
        tour.setIsBurning(isBurning);

        String tourOperator = input.askString("Enter name of tour operator: ");
        tour.setTourOperator(tourOperator);

        String tourStartLocation = input.askString("Enter tourStartLocation: ");
        tour.setTourStartLocation(tourStartLocation);

        String tourFinishLocation = input.askString("Enter tourFinishLocation: ");
        tour.setTourFinishLocation(tourFinishLocation);

        double cost = input.askDouble("Enter cost: ");
        tour.setCost(cost);


        Date tourStartTime = input.askDate("Enter tourStartTime: ");
        tour.setTourStartTime(tourStartTime);

        Date tourFinishTime = input.askDate("Enter tourFinishTime: ");
        tour.setTourFinishTime(tourFinishTime);
    }
}
