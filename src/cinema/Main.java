package cinema;

public class Main {
    public static void main(String[] args) {
        /* Stage 1: Arrangement */
        System.out.println("Cinema:");
        System.out.print(" ");

        for (int i = 1; i <= 8; i++) {
            System.out.printf(" %d", i);
        }
        System.out.println();

        for (int i = 1; i <= 7; i++) {
            System.out.printf("%d", i);
            System.out.println(" S S S S S S S S");
        }
    }
}
