package by.bsu.lab2.presentation.menu;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);

    private String askRegex(String label, String regex) {
        String input;

        do {
            System.out.print(label);
            input = scanner.nextLine();
        } while (!input.matches(regex));

        return input;
    }

    public String askString(String label) {
        String input;

        do {
            System.out.print(label);
            input = scanner.nextLine();
        } while (input.isBlank());

        return input;
    }

    public int askInt(String label) {
        String numberString = askRegex(label, "[+-]?\\d+");
        return Integer.parseInt(numberString);
    }

    public boolean askBool(String label) {
        String boolString = askRegex(label, "(yes|no)");
        return boolString.equals("yes");
    }

    public double askDouble(String label) {
        String numberString = askRegex(label, "[-+]?[0-9]*\\.?[0-9]+([eE][-+]?[0-9]+)?");
        return Double.parseDouble(numberString);
    }

    public Date askDate(String label) {
        try {
            String dateString = askRegex(label, "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$");
            return new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
        } catch(Exception ignored) {

        }
        return new Date();
    }
}
