package bank;

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


        for (int i = 1 ;i <= 10 ; i++) {
            BankAccount bankAccount = new BankAccount(
                    1234,
                    new Customer(
                            "Radha",
                            "gandhi street",
                            "1234567890"));
            Runnable runnable1 = new DepositRunnable(bankAccount, 1000);
            Runnable runnable2 = new DepositRunnable(bankAccount,100);
            Runnable runnable3 = new DepositRunnable(bankAccount,400);

            Thread thread1 = new Thread(runnable1);
            Thread thread2 = new Thread(runnable2);
            Thread thread3 = new Thread(runnable3);

            thread1.start();
            thread2.start();
            thread3.start();

            thread1.join();
            thread2.join();
            thread3.join();

            System.out.println("The balance is " + bankAccount.getBalance());
        }
    }
}
