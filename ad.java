import java.util.Scanner;

public class ad {
    private static final int ROWS = 5;
    private static final int SEATS_PER_ROW = 5;
    private static char[][] seatingChart = new char[ROWS][SEATS_PER_ROW];

    public static void main(String[] args) {
        initializeSeatingChart();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            displayMenu();
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    displaySeatingChart();
                    break;
                case 2:
                    bookASeat(scanner);
                    break;
                case 3:
                    cancelABooking(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);
        scanner.close();
    }

    private static void initializeSeatingChart() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < SEATS_PER_ROW; j++) {
                seatingChart[i][j] = 'A'; // 'A' indicates available seat
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Theater Seating Management");
        System.out.println("1. Display Seating Chart");
        System.out.println("2. Book a Seat");
        System.out.println("3. Cancel a Booking");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    private static void displaySeatingChart() {
        System.out.println("\nSeating Chart:");
        for (int i = 0; i < ROWS; i++) {
            System.out.print("Row " + (i + 1) + " ");
            for (int j = 0; j < SEATS_PER_ROW; j++) {
                System.out.print(seatingChart[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bookASeat(Scanner scanner) {
        System.out.print("Enter row (1-" + ROWS + "): ");
        int row = scanner.nextInt() - 1;
        System.out.print("Enter seat (1-" + SEATS_PER_ROW + "): ");
        int seat = scanner.nextInt() - 1;

        if (row >= 0 && row < ROWS && seat >= 0 && seat < SEATS_PER_ROW) {
            if (seatingChart[row][seat] == 'A') {
                seatingChart[row][seat] = 'B'; // 'B' indicates booked seat
                System.out.println("Seat booked successfully.");
            } else {
                System.out.println("Seat is already booked.");
            }
        } else {
            System.out.println("Invalid row or seat number.");
        }
    }

    private static void cancelABooking(Scanner scanner) {
        System.out.print("Enter row (1-" + ROWS + "): ");
        int row = scanner.nextInt() - 1;
        System.out.print("Enter seat (1-" + SEATS_PER_ROW + "): ");
        int seat = scanner.nextInt() - 1;

        if (row >= 0 && row < ROWS && seat >= 0 && seat < SEATS_PER_ROW) {
            if (seatingChart[row][seat] == 'B') {
                seatingChart[row][seat] = 'A'; // Reset to available
                System.out.println("Booking canceled successfully.");
            } else {
                System.out.println("No booking found for this seat.");
            }
        } else {
            System.out.println("Invalid row or seat number.");
        }
    }
}