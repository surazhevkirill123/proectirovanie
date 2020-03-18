package by.bsu.lab2.presentation.menu;

import java.util.Scanner;


public class Menu {
    private Scanner scanner = new Scanner(System.in);

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
            int action = choose("Choose action:\n\t1) Show all\n\t2) Find by ID\n\t3) Create new\n\t4) Exit", 4);
            switch (action) {
                case 1:
                    showAllMenu();
                    break;
                case 2:
                    showFindByIdMenu();
                    break;
                case 3:
                    showEditMenu();
                    break;
                default:
                    return;
            }
        }
    }

    public void showAllMenu() {
        // TODO: show all
    }

    public void showFindByIdMenu() {
        System.out.print("Enter id: ");
        int id = scanner.nextInt();

        // TODO: find by id

        int action = choose("Choose action:\n\t1) Edit\n\t2) Delete\n\t3) Back to main menu" ,3);

        switch (action) {
            case 1:
                break;
            case 2:
                // TODO: delete
        }
    }

    public void showEditMenu() {
        boolean isCorrect = true;

        int type = choose("Choose tour type:\n\t1) Relaxation\n\t2) Excursion\n\t3) Shopping", 3);
        // TODO: save type
        System.out.print(type);

        int isBurning = choose("Is it burning? 1 = no, 2 = yes", 2);
        // TODO: save isBurning
        System.out.print(isBurning);

        scanner.nextLine();

        System.out.print("Enter name of tour operator: ");
        String tourOperator = scanner.nextLine();
        // TODO: save tour operator
        System.out.print(tourOperator);

        System.out.print("Enter tourStartLocation: ");
        String tourStartLocation = scanner.nextLine();
        // TODO: save tourStartLocation
        System.out.print(tourStartLocation);

        System.out.print("Enter tourFinishLocation: ");
        String tourFinishLocation = scanner.nextLine();
        // TODO: save tourFinishLocation
        System.out.print(tourFinishLocation);

        System.out.print("Enter cost: ");
        double cost = scanner.nextDouble();
        // TODO: save cost
        System.out.print(cost);

        scanner.nextLine();

        System.out.print("Enter tourStartTime: ");
        String tourStartTime = scanner.nextLine();
        // TODO: save tourStartTime
        System.out.print(tourStartTime);

        System.out.print("Enter tourFinishTime: ");
        String tourFinishTime = scanner.nextLine();
        // TODO: save tourFinishTime
        System.out.print(tourFinishTime);

        // TODO: save to db
    }
}
