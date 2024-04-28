import java.util.Scanner;

public class BudgetApp {
    private final Scanner scanner = new Scanner(System.in);
    private double balance;

    public void start() {
        boolean isRunning = true;

        System.out.println("Welcome to the Budgeting App!");

        while (isRunning) {
            System.out.println("\n1. View Balance");
            System.out.println("2. Add Income");
            System.out.println("3. Add Expense");
            System.out.println("4. Quit");
            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    viewBalance();
                    break;
                case 2:
                    addIncome();
                    break;
                case 3:
                    addExpense();
                    break;
                case 4:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        System.out.println("Thank you for using the Budgeting App!");
        scanner.close();
    }

    private void viewBalance() {
        System.out.println("\nCurrent Balance: $" + balance);
    }

    private void addIncome() {
        System.out.print("Enter the amount of income: $");
        double income = scanner.nextDouble();
        balance += income;
        System.out.println("Income added successfully!");
    }

    private void addExpense() {
        System.out.print("Enter the amount of expense: $");
        double expense = scanner.nextDouble();
        if (expense > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= expense;
            System.out.println("Expense added successfully!");
        }
    }
}
