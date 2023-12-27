import java.util.Scanner;


//HI, WELCOME TO MY CODSOFT ATM PROJECT, IN THIS PROJECT I HVE METHOD IMPLEMENTATIONS FOR WITHDRAWING,DEPOSITING AND CHECHIKNG OF BALANCE BY THE USER
public class ATM {
    private final BankAccount userAccount;
    private final Scanner scanner;

    public ATM(double initialBalance) {
        this.userAccount = new BankAccount(initialBalance);
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean exit = false;

        while (!exit) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    performWithdrawal();
                    break;
                case 2:
                    performDeposit();
                    break;
                case 3:
                    displayBalance();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

        System.out.println("Thank you for using the ATM. Goodbye!");
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    private int getUserChoice() {
        System.out.print("Enter your choice (1-4): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private double getAmountFromUser() {
        System.out.print("Enter the amount: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private void performWithdrawal() {
        double amount = getAmountFromUser();
        if (userAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. Remaining balance: R." + userAccount.getBalance());
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    private void performDeposit() {
        double amount = getAmountFromUser();
        userAccount.deposit(amount);
        System.out.println("Deposit successful. New balance: R." + userAccount.getBalance());
    }
    

    private void displayBalance() {
        System.out.println("Current balance: R." + userAccount.getBalance());
    }

    public static void main(String[] args) {
        ATM atm = new ATM(1000.0);
        atm.run();
    }
}
