class Account {
    private String accountNum;
    private double balance;

    public Account(String accountNum, double initialBalance) {
        this.accountNum = accountNum;
        this.balance = initialBalance;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {

        if (amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
      
    }
}


public class BankingSystem {
    public static void main(String[] args) {
        Account obj = new Account("11223344", 1000.0);
        System.out.println("Account Number: " + obj.getAccountNum());
        System.out.println("Initial Balance: $" + obj.getBalance());  
        obj.deposit(250.0);
        System.out.println("Balance after deposit: $" + obj.getBalance());
        obj.withdraw(100.0);
        System.out.println("Balance after withdrawal: $" + obj.getBalance());
       
    }

}

