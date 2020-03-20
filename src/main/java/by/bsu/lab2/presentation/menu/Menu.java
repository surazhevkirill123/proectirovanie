package by.bsu.lab2.presentation.menu;

import by.bsu.lab2.bisiness.Tour;
import by.bsu.lab2.bisiness.TourType;
import by.bsu.lab2.dbo.FileDbProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;


public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private FileDbProcessor processor = new FileDbProcessor();
    private Logger logger = LogManager.getLogger(Menu.class);

    private int choose(String question, int variantNumber) {
        int action;

        do {
            System.out.println(question);
            action = scanner.nextInt();
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
        scanner.nextLine();
        System.out.print("Enter id: ");
        String id = scanner.nextLine();

        Tour tour = processor.readById(id);
        System.out.println(tour);

        int action = choose("""
                Choose action:
                \t1) Edit
                \t2) Delete
                \t3) Back to main menu""",3);

        switch (action) {
            case 1:
                showEditMenu(tour);
                processor.update(tour);
                break;
            case 2:
                processor.delete(tour);
        }
    }

    public void showEditMenu(Tour tour) throws ParseException {
        int type = choose("""
                Choose tour type:
                \t1) Relaxation
                \t2) Excursion
                \t3) Shopping""", 3);
        tour.setTourType(TourType.values()[type - 1]);

        int isBurning = choose("Is it burning? 1 = no, 2 = yes", 2);
        tour.setIsBurning(isBurning == 2);

        scanner.nextLine();

        System.out.print("Enter name of tour operator: ");
        String tourOperator = scanner.nextLine();
        tour.setTourOperator(tourOperator);

        System.out.print("Enter tourStartLocation: ");
        String tourStartLocation = scanner.nextLine();
        tour.setTourStartLocation(tourStartLocation);

        System.out.print("Enter tourFinishLocation: ");
        String tourFinishLocation = scanner.nextLine();
        tour.setTourFinishLocation(tourFinishLocation);

        System.out.print("Enter cost: ");
        double cost = scanner.nextDouble();
        tour.setCost(cost);

        scanner.nextLine();

        System.out.print("Enter tourStartTime: ");
        String tourStartTime = scanner.nextLine();
        tour.setTourStartTime(new SimpleDateFormat("dd/MM/yyyy").parse(tourStartTime));

        System.out.print("Enter tourFinishTime: ");
        String tourFinishTime = scanner.nextLine();
        tour.setTourFinishTime(new SimpleDateFormat("dd/MM/yyyy").parse(tourFinishTime));
    }
}
