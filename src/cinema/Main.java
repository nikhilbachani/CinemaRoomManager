package cinema;

import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /* Stage 1: Arrangement */
        // System.out.println("Cinema:");
        // System.out.print(" ");

        // for (int i = 1; i <= 8; i++) {
        //     System.out.printf(" %d", i);
        // }

        // System.out.println();

        // for (int i = 1; i <= 7; i++) {
        //     System.out.printf("%d", i);
        //     System.out.println(" S S S S S S S S");
        // }

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsPerRow = scanner.nextInt();

        // calculate total seats in the screen room
        int seats = rows * seatsPerRow;
        int totalIncome = 0;
        int pricePerSeat = 10;

        // check seats, for not more than 60
        if (seats <= 60) {
            // if so, each ticket is $10
            // calculate total income
            totalIncome = seats * pricePerSeat;
        } else { // if number of seats is > 60
            // the first half of rows is the "front"
            int frontRows = rows / 2;
            // the remaining half is the "back"
            int backRows = rows - frontRows;

            // tickets for front half of rows are $10
            // and $8 for the back half
            // calculate total income
            totalIncome += frontRows * seatsPerRow * pricePerSeat;
            totalIncome += backRows * seatsPerRow * (pricePerSeat - 2);
        }

        // display total income
        System.out.println("Total income: ");
        System.out.printf("$%d", totalIncome);
    }
}
