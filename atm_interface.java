package internship;

import java.util.Scanner;
class BankAcc {

    int balance;
    int prevTransaction;
    String customerName;
    String Pin;
    int flag = 0;

    BankAcc(String cName, String cId) {
        customerName = cName;
        Pin = cId;
    }

// Function to authenticate id 
    void checkId() {
        
        System.out.println("WELCOME " + customerName);
        System.out.println();
        System.out.print("Please enter the PIN: ");
        Scanner id = new Scanner(System.in);
        String chk = id.nextLine();
        if (chk.equals(Pin)) {
            
            showMenu();
        } else {
            System.out.println("............................");
            System.out.println("Invaid Login!");
            System.out.println("............................");

            if (flag < 3) {
                flag++;
                checkId();
            }
        }
    }

// Function for deposit    
    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            prevTransaction = amount;
        }
    }

 // Function for withdrawal 
    void withdraw(int amount) {
        if (this.balance > amount) {
            balance = balance - amount;
            prevTransaction = -amount;
        } else {
            
            System.out.println("............................");
            System.out.println("Sufficient Balance not available for the withdrawl!");
            System.out.println("............................");
        }
    }

 // Function for Transaction
    void getPrevTransaction() {
        if (prevTransaction > 0) {
            System.out.println("Deposited: " + prevTransaction);
        } else if (prevTransaction < 0) {
            System.out.println("Withdraw: " + Math.abs(prevTransaction));
        } else {
            System.out.println("No Transaction Occured ");
        }
    }

 // Function for Transfer
    public void transfer(double amount, BankAcc acc) {
        if (this.balance < amount) {
            
            System.out.println("............................");
            System.out.println("Transfer Failed due to insufficient balance!");
            System.out.println("............................");
        } else {
            this.balance -= amount;
            acc.balance += amount;
            System.out.println( "Balance : " + this.balance);
            System.out.println(amount + " tranferred to prasad");
            System.out.println("\n");
        }
    }

 // Function for ATM_interface
    private void showMenu() {
        int option;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        do {
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Previous Transaction");
            System.out.println("5. Transfer");
            System.out.println("6. Exit");

            System.out.println("............................");
            System.out.println("Enter the option");
            System.out.println("............................");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    
                    System.out.println("............................");
                    System.out.println("Balance " + balance);
                    System.out.println("............................");
                    System.out.println("\n");
                    break;

                case 2:
                    
                    System.out.println("............................");
                    System.out.println("Enter the amount of money to deposit");
                    System.out.println("............................");
                    int amount = sc.nextInt();
                    deposit(amount);
                    System.out.println("\n");
                    break;

                case 3:
                    
                    System.out.println("............................");
                    System.out.println("Enter the amount of money to withdraw");
                    System.out.println("............................");
                    int amount2 = sc.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;

                case 4:
                    
                    System.out.println("............................");
                    getPrevTransaction();
                    System.out.println("............................");
                    System.out.println("\n");
                    break;

                case 5:
                    
                    System.out.println("............................");
                    System.out.println("To whom");
                    BankAcc bb = new BankAcc("prasad", "2002");
                    System.out.println(bb.customerName);
                    System.out.println("............................");
                    System.out.println("Amount to Transfer");
                    double am = sc.nextDouble();
                    System.out.println("............................");
                    transfer(am, bb);
                    break;

                case 6:
                    
                    System.out.println("............................");
                    break;
                    
                default :
                	System.out.println("Please select valid option");

            }

        } while (option != 6);
        System.out.println("ThankYou For using our services");

    }
}

public class atm_interface {
    public static void main(String[] args) {
        BankAcc s = new BankAcc("sanket", "1111");
        s.checkId();
    }

}