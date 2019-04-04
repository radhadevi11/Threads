class DepositRunnable implements Runnable{

    private BankAccount bankAccount;
    private double amount;
    public DepositRunnable(BankAccount bankAccount, double amount){
        this.bankAccount = bankAccount;
        this.amount = amount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public void run() {
          this.bankAccount.deposit(this.amount);
    }
}

public class DepositRunnableTester{
    public static void main(String[] args) throws InterruptedException {

        BankAccount bankAccount = new BankAccount(
                1234,
                new Customer(
                        "Radha",
                        "gandhi street",
                        "1234567890"));

        Runnable runnable1 = new DepositRunnable(bankAccount, 1000);
         Runnable runnable2 = new DepositRunnable(bankAccount,100);

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("The balance is "+bankAccount.getBalance());
    }
}
