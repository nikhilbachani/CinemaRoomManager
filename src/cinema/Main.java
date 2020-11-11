package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);
    static char[][] room;

    public static void main(String[] args) {
        initRoom();

        int menuOption;
        do {
            printMenu();
            String userChoice = scanner.nextLine();
            menuOption = userChoice.matches("\\d+") ? Integer.parseInt(userChoice) : -1;

            switch (menuOption) {
                case 1:
                    printRoom();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 3:
                    printStatistics();
                    break;
                case 0:
                    break;
                default:
                    System.out.println();
                    System.out.println("Wrong input!");
                    break;
            }
        } while (menuOption != 0);
    }

    /* Stage 1: Arrangement */
    private static void printRoom() {
        System.out.println();
        System.out.println("Cinema:");
        System.out.print(" ");

        for (int i = 0; i < room[0].length; i++) {
            System.out.printf(" %d", i + 1);
        }

        System.out.println();

        for (int i = 0; i < room.length; i++) {
            System.out.printf("%d", i + 1);
            for (int j = 0; j < room[i].length; j++) {
                System.out.printf(" %c", room[i][j]);
            }
            System.out.println();
        }
    }

    /* Stage 2: Sold! */
    private static int getTicketPrice(int row) {
        int seats = room.length * room[0].length;
        int ticketPrice = 10; // default ticket price

        if (seats > 60 && row > room.length / 2) {
            ticketPrice = 8;
        }

        return ticketPrice;
    }

    /* Stage 3: Tickets */
    private static void initRoom() {
        boolean validInput = false;

        do {
            System.out.println("Enter the number of rows:");
            String strRows = scanner.nextLine();
            int rows = strRows.matches("\\d+") ? Integer.parseInt(strRows) : -1;

            System.out.println("Enter the number of seats in each row:");
            String strSeats = scanner.nextLine();
            int seatsPerRow = strSeats.matches("\\d+") ? Integer.parseInt(strSeats) : -1;

            if (rows <= 0 || seatsPerRow <= 0) {
                System.out.println();
                System.out.println("Wrong input!");
                System.out.println();
            } else {
                validInput = true;
                room = new char[rows][seatsPerRow];

                for (char[] vector: room) {
                    Arrays.fill(vector, 'S');
                }
            }
        } while (!validInput);
    }

    private static void bookSeat(int row, int seat) {
        room[row - 1][seat - 1] = 'B';
    }

    /* Stage 4: Menu, please! */
    private static void printMenu() {
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    private static void printTicketPrice(int row) {
        System.out.printf("%nTicket Price: $%d%n", getTicketPrice(row));
    }

    private static void buyTicket() {
        boolean validInput = false;

        do {
            System.out.println();
            System.out.println("Enter a row number:");
            String strRow = scanner.nextLine();
            int row = strRow.matches("\\d+") ? Integer.parseInt(strRow) : -1;

            System.out.println("Enter a seat number in that row:");
            String strSeat = scanner.nextLine();
            int seat = strSeat.matches("\\d+") ? Integer.parseInt(strSeat) : -1;

            if (row <= 0 || row > room.length || seat <= 0 || seat > room[0].length) {
                System.out.println();
                System.out.println("Wrong input!");
            } else if (room[row - 1][seat - 1] == 'B') {
                System.out.println();
                System.out.println("That ticket has already been purchased!");
            } else {
                validInput = true;
                bookSeat(row, seat);
                printTicketPrice(row);
            }
        } while (!validInput);
    }

    /* Stage 5: Errors! */
    private static void printStatistics() {
        int ticketsSold = 0;
        int currentIncome = 0;
        int totalIncome = 0;
        int totalSeats = room.length * room[0].length;

        for (int row = 1; row <= room.length; row++) {
            int seatPrice = getTicketPrice(row);

            for (int seat = 1; seat <= room[0].length; seat++) {

                if (room[row - 1][seat - 1] == 'B') {
                    ticketsSold++;
                    currentIncome += seatPrice;
                }

                totalIncome += seatPrice;
            }
        }

        System.out.println();
        System.out.printf("Number of purchased tickets: %d%n", ticketsSold);
        // To print a '%' sign using printf(), we use %% format specifier
        // https://stackoverflow.com/a/1708453
        // A .2f rounds the floating point data to 2 decimal places (Math.round() is also viable)
        System.out.printf("Percentage: %.2f%%%n", (float) ticketsSold / totalSeats * 100);
        System.out.printf("Current income: $%d%n", currentIncome);
        System.out.printf("Total income: $%d%n", totalIncome);
    }
}
