package bank;
public class Customer {
   private String name;
   private String address;
   private String aadharNo;
   public Customer(String myname, String myaddress, String myaadharno)
   {
       name=myname;
       address=myaddress;
       aadharNo=myaadharno;
   }
   public void setName(String accName)
   {
     name=accName;
   }
   public String getName()
   {
       return name;
   }
   public void setAddress(String accAddress)
   {
       address=accAddress;
   }
   public String getAddress()
   {
       return address;
   }
   public void setAadhar(String accAadhar)
   {
       aadharNo=accAadhar;
   }
   public String getAadhar()
   {
       return aadharNo;
   }
   public void printCustomer()
   {
       System.out.println("The Customer name is "+name+" address is "+address+" aadharNo is "+aadharNo);
   }
   public boolean equalsCustomer(Customer otherCustomer)
   {
       if(this.name.equals(otherCustomer.name) && this.address.equals(otherCustomer.address) && this.aadharNo.equals(otherCustomer.aadharNo))
       {
           return true;
       }
       else
       {
           return false;
       }
   }
}