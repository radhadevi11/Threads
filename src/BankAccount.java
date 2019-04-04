public class BankAccount {
  private int accountNo;
    private double balance;
    private Customer accountHolder;
    public BankAccount(int number, Customer myHolder)
    {
    	this.accountNo=number;
    	this.accountHolder=myHolder;
    }
  public void deposit(double amount)
  {
    balance=amount+balance;
  }
  public void withdraw(double amount)
  {
    if(amount>balance)
    {
      System.out.println("oops your balance is too low!");
    }
    else
    {
      balance=balance-amount;
    }
  }
  public void printBalance()
   {
    System.out.println("The balance in account "+accountNo+" is "+balance);
   }
  public int getAccountNo()
   {
    return accountNo; 
   }
 public void setAccountno(int number)
   {
    if(number<1)
    {
      accountNo=1;
    }
    else
    {
      accountNo=number;
    }
   }
   public double getBalance()
   {
    return balance;
   }
   public boolean equals(BankAccount otherAccount) {
//to compare whether "this" bank account states are equal to
//another bank account states
//compare all the states
//return true if they are equal, false otherwise
    if(accountNo==otherAccount.accountNo && this.balance==otherAccount.balance && this.accountHolder.equalsCustomer(otherAccount.accountHolder))
    {
      return true;
    }
    else
    {
      return false;
    }
} 
public void setAccountHolder(Customer myCustomer)
   {
   accountHolder=myCustomer;
   }
 public Customer getAccountHolder()
 {
  return accountHolder;
 }
}