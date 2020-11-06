package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);
    static char[][] room;

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

        /* Stage 2: Sold! */
//        System.out.println("Enter the number of rows:");
//        int rows = scanner.nextInt();
//        System.out.println("Enter the number of seats in each row:");
//        int seatsPerRow = scanner.nextInt();

//        // calculate total seats in the screen room
//        int seats = rows * seatsPerRow;
//        int totalIncome = 0;
//        int pricePerSeat = 10;
//
//        // check seats, for not more than 60
//        if (seats <= 60) {
//            // if so, each ticket is $10
//            // calculate total income
//            totalIncome = seats * pricePerSeat;
//        } else { // if number of seats is > 60
//            // the first half of rows is the "front"
//            int frontRows = rows / 2;
//            // the remaining half is the "back"
//            int backRows = rows - frontRows;
//
//            // tickets for front half of rows are $10
//            // and $8 for the back half
//            // calculate total income
//            totalIncome += frontRows * seatsPerRow * pricePerSeat;
//            totalIncome += backRows * seatsPerRow * (pricePerSeat - 2);
//        }
//
//        // display total income
//        System.out.println("Total income: ");
//        System.out.printf("$%d", totalIncome);
//
//        /* Stage 3: Tickets */
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsPerRow = scanner.nextInt();

        initRoom(rows, seatsPerRow);
        printRoom();

        System.out.println("Enter a row number:");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seat = scanner.nextInt();

        setBooked(row, seat);

        System.out.printf("%nTicket Price: $%d%n", getTicketPrice(row));
        printRoom();
    }

    private static void initRoom(int rows, int seatsPerRow) {
        room = new char[rows][seatsPerRow];

        for (char[] vector: room) {
            Arrays.fill(vector, 'S');
        }
    }

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
        System.out.println();
    }

    private static int getTicketPrice(int row) {
        int seats = room.length * room[0].length;
        int ticketPrice;

        if (seats <= 60) {
            ticketPrice = 10;
        } else {
            ticketPrice = row <= room.length / 2 ? 10 : 8;
        }

        return ticketPrice;
    }

    private static void setBooked(int row, int seat) {
        room[row - 1][seat - 1] = 'B';
    }
}
