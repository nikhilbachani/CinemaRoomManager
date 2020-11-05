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
        int totalIncome;

        int seats = rows * seatsPerRow;
        if (seats <= 60) {
            totalIncome = seats * 10;
        } else {
            int frontRows = rows / 2;
            int backRows = rows - frontRows;
            totalIncome = frontRows * seatsPerRow * 10 + backRows * seatsPerRow * 8;
        }

        System.out.println("Total income: ");
        System.out.printf("$%d", totalIncome);
    }
}
