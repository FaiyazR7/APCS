public class Teller{

  private String name;
  private String passwd;
  private short pin;
  private int acctNum;
  private double balance;

  public static void main(String [] args){
    BankAccount cats = new BankAccount();
    cats.setName("Mr. Cat");
    cats.setPasswd("bugs4");
    cats.setAcctNum(999999998);
    cats.setPin((short)9998);
    cats.setBalance(1);
    cats.withdraw(1);
    cats.withdraw(-1);
    cats.withdraw(99);
    cats.deposit(-1);
    cats.deposit(99);
    System.out.println(cats.toString());
  }

}
