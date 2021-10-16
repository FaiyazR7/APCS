/*The Cats: Perry Huang, Xinqing Lin, Faiyaz Rafee
APCS
HW18 -- <CPA-One/Bank Account Java/Summary>
2021-08-15
*/

public class BankAccount{
	private String accHolderName;
	private String password;
	private int pin;
	private int accNumber;
	private double balance;

public BankAccount() {
	accHolderName = "TheCats";
	password = "ILikeCats";
	pin = 6969;
	accNumber = 000000001;
	balance = 420.69 ;
}

public BankAccount(String a, String b, int c, int d, double u){
	accHolderName = a;
        password = b;
        pin = c;
        accNumber = d;
        balance = u;
}

public static void accDetails( perryJR ){
	System.out.println(perryJR.accHoldername);
	System.out.println(perryJR.password);
	System.out.println(perryJR.pin);
	System.out.println(perryJR.accNumber);
	System.out.println(perryJR.balance);

}
public static void main(String[] args){
	BankAccount PerryThePlatypus = new BankAccount("PerryThePlatypus", "ILikePlatypuses", 1234, 000000002, 169);
	accDetails();
}


}
