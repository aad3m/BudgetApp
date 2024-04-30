package BudgetApp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class BalanceManager {
    private static final String File = "BalanceManager.txt";

    public static double loadBalance() {
        double balance = 0;
        try (Scanner scanner = new Scanner(new File(File))) {
            if (scanner.hasNextDouble()) {
                balance = scanner.nextDouble();
            }
        } catch (IOException | NoSuchElementException e) {
            System.out.println("Failed to load balance. Starting with default balance.");
        }
        return balance;
    }

    public static void saveBalance(double balance) {
        try (FileWriter writer = new FileWriter(File)) {
            writer.write(Double.toString(balance));
        } catch (IOException e) {
            System.out.println("Failed to save balance.");
        }
    }
}
