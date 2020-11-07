package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final Scanner scanner = new Scanner(System.in);
    static char[][] room;

    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsPerRow = scanner.nextInt();

        /* Stage 3: Tickets */
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

        System.out.println();
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

    // TODO: check valid row and seat index
    private static void setBooked(int row, int seat) {
        room[row - 1][seat - 1] = 'B';
    }
}
